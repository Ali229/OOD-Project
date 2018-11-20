package premiumtravel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.billing.BillController;
import premiumtravel.billing.PaymentController;
import premiumtravel.trip.TripController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Mark Zeagler
 * @version 1.0
 */
@ApplicationPath( "/" )
public class PremiumTravelServer extends Application {

	private static final Logger logger = LogManager.getLogger("premiumtravel.PremiumTravelServer");

	public Set<Class<?>> getClasses() {
		HashSet<Class<?>> h = new HashSet<>();
		h.add( BillController.class );
		h.add( PaymentController.class );
		h.add( TripController.class );
		return h;
	}
}
