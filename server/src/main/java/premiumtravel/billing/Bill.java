package premiumtravel.billing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class Bill implements Serializable {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	private static final long serialVersionUID = 7822660391813459523L;

	public List<Payment> payments = new LinkedList<>();
	private String billText;
	private BigDecimal amount;

	/**
	 *
	 */
	public Bill( Product product ) {
		this.billText = product.getBillText();
		this.amount = product.getPrice();
	}

	/**
	 *
	 */
	public BigDecimal getTotalPrice() {
		return this.amount;
	}

	/**
	 *
	 */
	public void submitPayment( Payment payment ) {
		this.payments.add( payment );
	}

	/**
	 *
	 */
	public boolean isPaidInFull() {
		BigDecimal totalPayments = new BigDecimal( 0.0 );
		for ( Payment payment : this.payments ) {
			totalPayments = totalPayments.add( payment.amountPaid );
		}
		return totalPayments.equals( this.amount );
	}

	public String getBillText() {
		return this.billText;
	}
}

