package premiumtravel.trip;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.cache.PlaceRegistry;

import javax.ejb.*;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Named;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 */
@Named
@Model
@Startup
@Singleton
@ApplicationScoped
@DependsOn( "PlaceRegistry" )
@ConcurrencyManagement( ConcurrencyManagementType.CONTAINER )
public class PackageFactory {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );

	@EJB PlaceRegistry placeRegistry;

	public TravelPackage getPackage( Place placeFrom, Place placeTo, TransportType transportType ) {
		Random random = new Random();
		BigDecimal price = new BigDecimal( random.nextDouble() );
		price = price.setScale( 2, RoundingMode.CEILING );
		return new TravelPackage( placeFrom, placeTo, transportType, random.nextInt(), price );
	}

	public List<TravelPackage> generatePackages() {
		List<TravelPackage> packages = new LinkedList<>();
		for ( Place placeFrom : this.placeRegistry.getAll() ) {
			for ( Place placeTo : this.placeRegistry.getAll() ) {
				if ( !placeFrom.equals( placeTo ) ) {
					for ( TransportType transportType : TransportType.values() ) {

						packages.add( getPackage( placeFrom, placeTo, transportType ) );
					}
				}
			}
		}
		return packages;
	}
}

