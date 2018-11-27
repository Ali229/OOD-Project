package premiumtravel.trip;

import javax.ejb.*;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Named;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mark Zeagler
 * @version 1.0
 */
@Named
@Model
@Singleton
@ApplicationScoped
@ConcurrencyManagement( ConcurrencyManagementType.CONTAINER )
public class PlaceFactory {

	public List<Place> loadPlacesFromFile() {
		Scanner in = new Scanner( getClass().getClassLoader().getResourceAsStream( "places.txt" ) );
		List<Place> places = new LinkedList<>();
		while ( in.hasNextLine() ) {
			places.add( new Place( in.nextLine() ) );
		}
		return places;
	}
}
