//package premiumtravel.state;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import premiumtravel.people.PersonFactory;
//import premiumtravel.people.TravelAgent;
//import premiumtravel.people.Traveller;
//import premiumtravel.trip.Trip;
//
//import java.util.HashMap;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//public class StateControllerTest {
//
//	Trip trip;
//
//	@Before
//	public void setup() {
//		PersonFactory personFactory = new PersonFactory();
//		TravelAgent travelAgent = personFactory.getTravelAgent( "Bob", "Smith", "23123094593" );
//		this.trip = new Trip( travelAgent );
//		Traveller traveller = personFactory.getTraveller( "Danny", "Anderson", "213290131" );
//	}
//
//	@Test
//	public void testStateFlow() {
//		// Test initial state
//		assertEquals( States.ADD_TRAVELLERS, this.trip.getState() );
//		// Test exception thrown when attempting to advance state when not ready
//		assertThrows( RuntimeException.class, () -> this.trip.getStateController().nextState() );
//		// Add traveller
//		HashMap<String, String> data = new HashMap<>(  );
//		data.put( "traveller",  )
//		this.trip.getStateController().accept(  );
//	}
//
//}
