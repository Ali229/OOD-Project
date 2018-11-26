package premiumtravel.cache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * <!-- begin-user-doc --> <!--  end-user-doc  -->
 *
 * @generated
 */

public class JSONSerializer extends DataSerializer {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 */
	public JSONSerializer( File file ) {
		super( file );
	}

	@Override
	protected void saveData( SaveData data ) {

	}

	@Override
	protected SaveData loadData() {
		return null;
	}
}

