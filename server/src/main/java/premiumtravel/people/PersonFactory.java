package premiumtravel.people;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.cache.TravelAgentRegistry;
import premiumtravel.cache.TravellerRegistry;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.EnumMap;
import java.util.Map;

/**
 *
 */
@Singleton
@ConcurrencyManagement( ConcurrencyManagementType.CONTAINER )
public class PersonFactory {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );

	private Map<PersonType, MyFunction> personFunctionMap = new EnumMap<>( PersonType.class );

	@EJB private TravelAgentRegistry travelAgentRegistry;

	@EJB private TravellerRegistry travellerRegistry;

	/**
	 * This is Java EE's Singleton "constructor"
	 */
	@PostConstruct
	void init() {
		personFunctionMap.put( PersonType.TravelAgent, this::getTravelAgent );
		personFunctionMap.put( PersonType.Traveller, this::getTraveller );
		personFunctionMap.put( PersonType.SystemGuest, this::getGuest );
	}

	/**
	 *
	 */
	public Person getPerson( PersonType personType, String firstName, String lastName, String phoneNumber ) {
		return personFunctionMap.get(personType).apply( firstName, lastName, phoneNumber );
	}

	public TravelAgent getTravelAgent( String firstName, String lastName, String phoneNumber ) {
		TravelAgent travelAgent = new TravelAgent( firstName, lastName, phoneNumber );
		this.travelAgentRegistry.add( travelAgent );
		return travelAgent;
	}

	public Traveller getTraveller( String firstName, String lastName, String phoneNumber ) {
		Traveller traveller = new Traveller( firstName, lastName, phoneNumber );
		this.travellerRegistry.add( traveller );
		return traveller;
	}

	public Person getGuest( String firstName, String lastName, String phoneNumber ) {
		Person person = new Person( firstName, lastName, phoneNumber );
		//		this.personRegistry.add(person);
		return person;
	}

	public enum PersonType {
		Traveller,
		TravelAgent,
		SystemGuest;
	}

	private interface MyFunction {
		Person apply( String firstName, String lastName, String phoneNumber );
	}
}

