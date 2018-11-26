package premiumtravel.cache;

import premiumtravel.people.Traveller;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Named;

/**
 *
 */
@Named
@Model
@Singleton
@ApplicationScoped
@ConcurrencyManagement( ConcurrencyManagementType.CONTAINER )
public class TravellerRegistry extends Registry<Traveller> {

	private static final long serialVersionUID = -9147025168632893220L;
}

