package premiumtravel.billing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.people.Person;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 */
public abstract class Payment implements Serializable {
	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	private static final long serialVersionUID = -710050998840868000L;

	protected final BigDecimal amountPaid;
	protected final Person payer;
	protected final PaymentType type;

	/**
	 *
	 */
	Payment( PaymentType type, BigDecimal amountPaid, Person payer ) {
		this.type = type;
		this.amountPaid = amountPaid;
		this.payer = payer;
	}

	/**
	 *
	 */
	public PaymentType getType() {
		return this.type;
	}

	/**
	 *
	 */
	public BigDecimal getAmountPaid() {
		return this.amountPaid;
	}

	/**
	 *
	 */
	public abstract String toString();
}

