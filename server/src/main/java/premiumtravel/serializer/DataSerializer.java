package premiumtravel.serializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public abstract class DataSerializer
{

	private static final Logger logger = LogManager.getLogger("premiumtravel.PremiumTravelServer");

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Cache cache;


	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	protected DataSerializer( File file ) {
		super();
		// TODO construct me
		LogManager.getLogger().info( "Setting save file: " + file.getAbsolutePath() );
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	protected abstract void saveData(PeopleTripsTuple data) ;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	protected abstract PeopleTripsTuple loadData() ;

}

