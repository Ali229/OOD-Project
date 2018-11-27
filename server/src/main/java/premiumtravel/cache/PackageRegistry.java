package premiumtravel.cache;

import premiumtravel.trip.PackageFactory;
import premiumtravel.trip.TravelPackage;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Named;

/**
 *
 */
@Named
@Model
@Startup
@Singleton
@ApplicationScoped
@DependsOn( {"PlaceRegistry", "PackageFactory"} )
@ConcurrencyManagement( ConcurrencyManagementType.CONTAINER )
public class PackageRegistry extends Registry<TravelPackage> {

	private static final long serialVersionUID = 5858594429818177713L;

	@EJB private transient PackageFactory packageFactory;

	@PostConstruct
	void init() {
		resetRegistry( packageFactory.generatePackages() );
	}
}

