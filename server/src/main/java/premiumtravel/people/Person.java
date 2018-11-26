package premiumtravel.people;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.serializer.RegistryObject;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

/**
 *
 */
public class Person implements RegistryObject {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	private static final long serialVersionUID = 1136327435690788571L;

	/**
	 * Used to verify that each ID is unique.
	 */
	private static Set<UUID> registeredIDs = new LinkedHashSet<>();

	private final String firstName;
	private final String lastName;
	private final String phoneNumber;
	private final UUID personID;

	/**
	 * Constructs a new Person and automatically generates a new ID.
	 */
	Person( String firstName, String lastName, String phoneNumber ) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;

		// Generate a new ID
		UUID generatedID = null;
		boolean idSet = false;
		while ( !idSet ) {
			try {
				generatedID = UUID.randomUUID();
				registeredIDs.add( generatedID );
				idSet = true;
			} catch ( UnsupportedOperationException e ) {
				// Do nothing
			}
		}

		this.personID = generatedID;

		logger.trace( String.format(
				"Creating new Person with first name: %s, last name: %s, phone number: %s, and person ID: %s",
				firstName, lastName, phoneNumber,
				this.personID.toString() ) ); // It's redundant, but I'm using TRACE to log basically everything
	}

	/**
	 * Retrieves this person's first name.
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Retrieves this person's last name.
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Retrieves the phone number associated with this Person.
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * Retrieves the ID of the person
	 */
	public String getPersonID() {
		return this.personID.toString();
	}

	@Override
	public UUID getID() {
		return this.personID;
	}
}

