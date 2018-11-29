package premiumtravel.billing;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 */
public interface Product extends Serializable {

	/**
	 *
	 */
	BigDecimal getPrice();

	String getBillText();
}

