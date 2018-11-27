package premiumtravel.trip;

import premiumtravel.billing.Bill;

import java.math.BigDecimal;

/**
 * <!-- begin-user-doc --> <!--  end-user-doc  -->
 *
 * @generated
 */
public interface Product {
	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	public Bill bill = null;

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	public BigDecimal getPrice();

}

