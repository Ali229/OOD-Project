package premiumtravel.trip;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.Date;

/**
 * <!-- begin-user-doc --> <!--  end-user-doc  -->
 *
 * @generated
 */

public class Reservation implements Product, Serializable {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	private static final long serialVersionUID = -3053082615290789288L;
	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	public Trip trip;
	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	public TravelPackage chosenPackage;
	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	private Date departingOn;
	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	private Date arrivingOn;

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	public Reservation( TravelPackage travelPackage, Date departureDate ) {
		super();
		// TODO construct me
	}

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	public Date getDepartureDate() {
		// TODO implement me
		return new Date();
	}

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	public Date getArrivalDate() {
		// TODO implement me
		return new Date();
	}

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	public TravelPackage getPackage() {
		// TODO implement me
		return null;
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

}

