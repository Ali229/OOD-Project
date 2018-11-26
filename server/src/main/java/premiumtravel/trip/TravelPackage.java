package premiumtravel.trip;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.serializer.PackageRegistry;
import premiumtravel.serializer.RegistryObject;

import java.util.Set;
import java.util.UUID;

/**
 * <!-- begin-user-doc --> <!--  end-user-doc  -->
 *
 * @generated
 */

public class TravelPackage implements Product, RegistryObject {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	public final double price = 0.0;

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	public final int hoursOfTravelTime = 0;

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	public final TransportType transportType = TransportType.PrivateJet;

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	public Set<Reservation> reservation;

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	public Place place;

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	public PackageRegistry packageList;

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 */
	public TravelPackage() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	public String toString() {
		// TODO implement me
		return "";
	}

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	public double getPrice() {
		// TODO implement me
		return 0.0;
	}

	@Override
	public UUID getID() {
		return null;
	}
}

