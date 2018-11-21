package premiumtravel.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Mark Zeagler
 * @version 1.0
 */
class TravelAgentRegistryTest {

	private ArrayList<TravelAgent> travelAgents = new ArrayList<>();
	private int initialSize;

	@BeforeEach
	void setUp() {
		this.initialSize = TravelAgentRegistry.getTravelAgents().size();
		for ( int i = 0; i < 10; i++ ) {
			addTravelAgent( new TravelAgent( "firstName" + i, "lastName" + i, "phoneNumber" + i ) );
		}
	}

	@Test
	void getTravelAgents() {
		// Save the returned set, add a new travel agent, and make sure the size changes with it
		Set<TravelAgent> travelAgents = TravelAgentRegistry.getTravelAgents();
		addTravelAgent( new TravelAgent( "newFirstName", "newLastName", "newPhoneNumber" ) );
		assertEquals( this.travelAgents.size() + initialSize, travelAgents.size() );

		// Make sure the returned set is unmodifiable
		assertThrows( UnsupportedOperationException.class,
				() -> travelAgents.add( new TravelAgent( "excFirstName", "excLastName", "excPhoneNumber" ) ) );
	}

	@Test
	void addTravelAgent() {
		// Test that the number of agents in the registry is the number that were added in the setup
		assertEquals( this.travelAgents.size() + initialSize, TravelAgentRegistry.getTravelAgents().size() );

		// Add another agent and make sure the registry size changes as well
		addTravelAgent( new TravelAgent( "newFirstName", "newLastName", "newPhoneNumber" ) );
		assertEquals( this.travelAgents.size() + initialSize, TravelAgentRegistry.getTravelAgents().size() );
	}

	private void addTravelAgent( TravelAgent travelAgent ) {
		travelAgents.add( travelAgent );
		TravelAgentRegistry.addTravelAgent( travelAgent );
	}
}
