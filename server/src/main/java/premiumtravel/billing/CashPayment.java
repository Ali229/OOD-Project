package premiumtravel.billing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.people.Person;

import java.math.BigDecimal;

/**
 *
 */
public class CashPayment extends Payment {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );

	private static final PaymentType type = PaymentType.Check;
	private static final long serialVersionUID = -7201630434936505385L;

	/**
	 *
	 */
	public CashPayment( BigDecimal amount, Person payer ) {
		super( PaymentType.Cash, amount, payer );
	}

	@Override
	public String toString() {
		return null;
	}
}

