package premiumtravel.cache;

import premiumtravel.trip.Trip;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Named;

@Named
@Model
@Singleton
@ApplicationScoped
@ConcurrencyManagement( ConcurrencyManagementType.CONTAINER )
public class TripRegistry extends Registry<Trip> {
	private static final long serialVersionUID = 3095507398182883303L;
}
