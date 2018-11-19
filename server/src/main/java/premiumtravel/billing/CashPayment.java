package premiumtravel.billing;

/**
 * <!-- begin-user-doc --> <!--  end-user-doc  -->
 *
 * @generated
 */

public class CashPayment extends Payment {
	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	private static final PaymentType type = PaymentType.Check;

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 */
	public CashPayment( double amount ) {
		super( PaymentType.Cash, amount );
	}

	@Override
	public String toString() {
		return null;
	}
}

