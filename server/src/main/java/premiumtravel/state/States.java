package premiumtravel.state;

import premiumtravel.trip.Trip;

import java.util.function.Function;

public enum States {
	ADD_TRAVELLERS( AddTravelersStateController::new ),
	ADD_PACKAGES( AddPackagesStateController::new ),
	SELECT_PAYMENT_TYPE( SelectPaymentStateController::new ),
	PAYMENT( PaymentStateController::new ),
	THANK_YOU( ThankYouStateController::new ),
	SHOW_ITENERARY( FinalStateController::new );

	private final Function<Trip, StateController> stateControllerFunction;

	States( Function<Trip, StateController> stateControllerFunction ) {
		this.stateControllerFunction = stateControllerFunction;
	}

	public StateController getStateController( Trip trip ) {
		return this.stateControllerFunction.apply( trip );
	}
}
