package premiumtravel.cache;

import premiumtravel.people.TravelAgent;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;

/**
 *
 */
@Singleton
@ConcurrencyManagement( ConcurrencyManagementType.CONTAINER )
public final class TravelAgentRegistry extends Registry<TravelAgent> {

	private static final long serialVersionUID = 7940610817830344001L;

	private TravelAgentRegistry() {
	}
}

