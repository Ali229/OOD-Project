package premiumtravel.billing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.people.Person;

import java.math.BigDecimal;

/**
 *
 */
public class CheckPayment extends Payment {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	private static final PaymentType type = PaymentType.Check;
	private static final long serialVersionUID = -717931169491085126L;

	private String checkNumber;

	public CheckPayment( BigDecimal amount, Person payer, String checkNumber ) {
		super( PaymentType.Check, amount, payer );

		this.checkNumber = checkNumber;
	}

	@Override
	public String toString() {
		return null;
	}
}

