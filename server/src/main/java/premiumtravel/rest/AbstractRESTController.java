package premiumtravel.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.core.Response;

public abstract class AbstractRESTController {

	static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	static final Gson gson;

	static {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.enableComplexMapKeySerialization();
		gsonBuilder.serializeNulls();
		gson = gsonBuilder.create();
	}

	Response.ResponseBuilder addHeaders( Response.ResponseBuilder responseBuilder ) {
		responseBuilder.header( "Access-Control-Allow-Origin", "*" );
		responseBuilder.header( "Access-Control-Allow-Headers", "origin, content-type, accept, authorization" );
		responseBuilder.header( "Access-Control-Allow-Credentials", "true" );
		responseBuilder.header( "Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD" );
		return responseBuilder;
	}
}
