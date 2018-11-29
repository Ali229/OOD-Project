package premiumtravel.trip;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.billing.Product;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 */
public class Reservation implements Product, Serializable {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	private static final long serialVersionUID = -3053082615290789288L;

	public TravelPackage chosenPackage;
	private String departingOn;
	private String arrivingOn;

	/**
	 *
	 */
	public Reservation( TravelPackage travelPackage, String departureDate, String arrivalDate ) {
		this.chosenPackage = travelPackage;
		this.departingOn = departureDate;
		this.arrivingOn = arrivalDate;
	}

	/**
	 *
	 */
	public String getDepartureDate() {
		return this.departingOn;
	}

	/**
	 *
	 */
	public String getArrivalDate() {
		return this.arrivingOn;
	}

	/**
	 *
	 */
	public TravelPackage getPackage() {
		return this.chosenPackage;
	}

	/**
	 *
	 */
	public BigDecimal getPrice() {
		return this.chosenPackage.getPrice();
	}

	@Override
	public String getBillText() {
		return this.chosenPackage.getBillText() + " [departing: " + this.departingOn + "], [arriving: "
				+ this.arrivingOn + "]\n\t$" + getPrice() + "\n";
	}
}

