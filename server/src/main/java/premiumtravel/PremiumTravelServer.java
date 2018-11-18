package premiumtravel;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Mark Zeagler
 * @version 1.0
 */
@ApplicationPath( "/premium-travel-backend" )
public class PremiumTravelServer extends Application {

	public Set<Class<?>> getClasses() {
		HashSet<Class<?>> h = new HashSet<>();
		return h;
	}
}
