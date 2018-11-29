package premiumtravel.cache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ini4j.Wini;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
@Named
@Model
@Default
@Startup
@Singleton
@ApplicationScoped
@ConcurrencyManagement( ConcurrencyManagementType.CONTAINER )
@DependsOn( { "PackageRegistry", "PersonRegistry", "TravelAgentRegistry", "TravellerRegistry", "TripRegistry" } )
public class PremiumTravelCache {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );

	/**
	 * Singleton bean instantiated by Java EE
	 */
	@Inject private TravelAgentRegistry travelAgentRegistry;
	/**
	 * Singleton bean instantiated by Java EE
	 */
	@Inject private TravellerRegistry travellerRegistry;
	/**
	 * Singleton bean instantiated by Java EE
	 */
	@Inject private PersonRegistry personRegistry;
	/**
	 * Singleton bean instantiated by Java EE
	 */
	@Inject private TripRegistry tripRegistry;
	/**
	 * Singleton bean instantiated by Java EE
	 */
	@Inject private PackageRegistry packageRegistry;

	private SerializationProtocol protocol;
	private DataSerializer serializer;
	private File file;
	private Wini ini;

	/**
	 * This is Java EE's Singleton "constructor"
	 */
	@PostConstruct
	void init() {
		try {
			ini = new Wini( getClass().getResourceAsStream( "/config.ini" ) );
		} catch ( Exception e ) {
			logger.error( "The config file could not be loaded." );
			logger.error( e.getClass().getSimpleName() + ": " + e.getMessage() );
		}
		setProtocol( SerializationProtocol.valueOf( ini.get( "Serializer", "serializer" ).trim() ) );
		this.file = new File( ini.get( "Serializer", "saveFilePath" ) );

		if ( file.exists() ) {
			try {
				reloadAll();
			} catch ( Exception e ) {
				logger.error( "There was an error loading data from the file set in config.ini" );
				logger.error( e.getMessage() );
			}
		}
	}

	/**
	 * Called immediately before the singleton is destroyed (presumably on system shutdown). Used to save the system
	 * data using the assigned serialization protocol or with the default cache if there's an error.
	 */
	@PreDestroy
	void tearDown() {
		if ( this.serializer == null ) {
			logger.error(
					"The system is shutting down while no cache is set. The data will be serialized with the DEFAULT cache." );
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd_HH-mm-ss" );
			try {
				this.serializer = new DefaultSerializer(
						new File( "/saves/dump" + dateFormat.format( date ) + ".ptsave" ) );
			} catch ( IOException e ) {
				logger.error( "There was an error creating the error dump file." );
				logger.error( e.getMessage() );
				return;
			}
			try {
				saveAll();
			} catch ( IOException e ) {
				logger.error( "There was an error while saving the current data to the dump file." );
				logger.error( e.getMessage() );
				return;
			}
		}
		try {
			saveAll();
		} catch ( Exception e ) {
			logger.error( "There was an error while saving the current data to the designated save file." );
			logger.error( e.getMessage() );
		}
	}

	@Lock( LockType.READ )
	public SerializationProtocol getProtocol() {
		return this.protocol;
	}

	/**
	 *
	 */
	@Lock( LockType.WRITE )
	public void setProtocol( SerializationProtocol protocol ) {
		this.protocol = protocol;
		try {
			DataSerializer serializer = this.protocol.getSerializer( this.file );
			this.serializer = serializer; // Separated so an exception won't mess up anything
		} catch ( Exception e ) {
			logger.error( "The new " + this.protocol.name() + " cache serializer could not be created." );
			logger.error( e.getClass() + ": " + e.getMessage() );
		}
	}

	@Lock( LockType.READ )
	private void saveAll() throws IOException {
		serializer.saveData( new SaveData( this.personRegistry.getAll(), this.travelAgentRegistry.getAll(),
				this.travellerRegistry.getAll(), this.tripRegistry.getAll() ) );
	}

	@Lock( LockType.WRITE )
	private void reloadAll() throws IOException, ClassNotFoundException {
		SaveData saveData = serializer.loadData();
		this.personRegistry.resetRegistry( saveData.people );
		this.travelAgentRegistry.resetRegistry( saveData.travelAgents );
		this.travellerRegistry.resetRegistry( saveData.travellers );
		this.tripRegistry.resetRegistry( saveData.trips );
	}

	@Lock( LockType.READ )
	public TravelAgentRegistry getTravelAgentRegistry() {
		return travelAgentRegistry;
	}

	@Lock( LockType.READ )
	public TravellerRegistry getTravellerRegistry() {
		return travellerRegistry;
	}

	@Lock( LockType.READ )
	public PersonRegistry getPersonRegistry() {
		return personRegistry;
	}

	@Lock( LockType.READ )
	public TripRegistry getTripRegistry() {
		return tripRegistry;
	}

	@Lock( LockType.READ )
	public PackageRegistry getPackageRegistry() {
		return packageRegistry;
	}
}

