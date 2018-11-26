package premiumtravel.cache;

import premiumtravel.trip.TravelPackage;

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
public class PackageRegistry extends Registry<TravelPackage> {

	private static final long serialVersionUID = 5858594429818177713L;

}

