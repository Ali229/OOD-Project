package premiumtravel.cache;

import premiumtravel.trip.Place;

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
public class PlaceRegistry extends Registry<Place> {

	private static final long serialVersionUID = 7459049092316123354L;
}

