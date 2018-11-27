package premiumtravel.billing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.people.Person;

import java.math.BigDecimal;

/**
 * <!-- begin-user-doc --> <!--  end-user-doc  -->
 *
 * @generated
 */

public class CreditCardPayment extends Payment {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );

	private static final PaymentType type = PaymentType.Check;
	private static final long serialVersionUID = -6270018816292065767L;
	private final String creditCardNumber;
	private final String expirationDate;

	/**
	 *
	 */
	public CreditCardPayment( BigDecimal amount, Person payer, String creditCardNumber, String expirationDate ) {
		super( PaymentType.CreditCard, amount, payer );
		this.creditCardNumber = creditCardNumber;
		this.expirationDate = expirationDate;
	}

	@Override
	public String toString() {
		return null;
	}
}

