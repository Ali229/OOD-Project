package premiumtravel.state;

import premiumtravel.billing.PaymentType;
import premiumtravel.trip.Trip;

import java.util.function.Function;

public enum States {
	ADD_TRAVELLERS( AddTravelersStateController::new ),
	ADD_PACKAGES( AddPackagesStateController::new ),
	SELECT_PAYMENT_TYPE( SelectPaymentStateController::new ),
	PAYMENT( trip -> {
		if ( trip.getPaymentType() == PaymentType.Check ) {
			return new CheckPaymentStateController( trip );
		} else if ( trip.getPaymentType() == PaymentType.CreditCard ) {
			return new CreditCardPaymentStateController( trip );
		} else {
			return new CashPaymentStateController( trip );
		}
	} ),
	THANK_YOU( ThankYouStateController::new ),
	SHOW_ITINERARY( FinalStateController::new );

	private final Function<Trip, StateController> stateControllerFunction;

	States( Function<Trip, StateController> stateControllerFunction ) {
		this.stateControllerFunction = stateControllerFunction;
	}

	public StateController getStateController( Trip trip ) {
		return this.stateControllerFunction.apply( trip );
	}
}
