package premiumtravel.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractRESTController {

	static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	static final Gson gson;

	static {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.enableComplexMapKeySerialization();
		gsonBuilder.generateNonExecutableJson();
		gsonBuilder.serializeNulls();
		gson = gsonBuilder.create();
	}
}
