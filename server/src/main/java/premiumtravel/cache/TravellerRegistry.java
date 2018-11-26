package premiumtravel.cache;

import premiumtravel.people.Traveller;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;

/**
 *
 */
@Singleton
@ConcurrencyManagement( ConcurrencyManagementType.CONTAINER )
public final class TravellerRegistry extends Registry<Traveller> {

	private static final long serialVersionUID = -9147025168632893220L;

	private TravellerRegistry() {
	}
}

