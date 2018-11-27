package premiumtravel.cache;

import premiumtravel.trip.Place;
import premiumtravel.trip.PlaceFactory;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Named;

@Named
@Model
@Startup
@Singleton
@ApplicationScoped
@DependsOn( "PlaceFactory" )
@ConcurrencyManagement( ConcurrencyManagementType.CONTAINER )
public class PlaceRegistry extends Registry<Place> {

	private static final long serialVersionUID = 7459049092316123354L;
	@EJB private transient PlaceFactory placeFactory;

	/**
	 * This is Java EE's Singleton "constructor"
	 */
	@PostConstruct
	void init() {
		resetRegistry( placeFactory.loadPlacesFromFile() );
	}
}

