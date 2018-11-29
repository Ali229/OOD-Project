package premiumtravel.cache;

import premiumtravel.trip.PackageFactory;
import premiumtravel.trip.TravelPackage;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 */
@Named
@Model
@Startup
@Singleton
@ApplicationScoped
@DependsOn( { "PlaceRegistry", "PackageFactory" } )
@ConcurrencyManagement( ConcurrencyManagementType.CONTAINER )
public class PackageRegistry extends Registry<TravelPackage> {

	private static final long serialVersionUID = 5858594429818177713L;

	@Inject private transient PackageFactory packageFactory;
	@Inject private transient PlaceRegistry placeRegistry;

	@PostConstruct
	void init() {
		resetRegistry( packageFactory.generatePackages( placeRegistry.getAll() ) );
	}
}

