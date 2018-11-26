package premiumtravel.cache;

import premiumtravel.people.TravelAgent;

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
public class TravelAgentRegistry extends Registry<TravelAgent> {

	private static final long serialVersionUID = 7940610817830344001L;
}

