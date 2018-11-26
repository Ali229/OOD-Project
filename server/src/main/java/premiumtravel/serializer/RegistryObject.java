package premiumtravel.serializer;

import java.io.Serializable;
import java.util.UUID;

public interface RegistryObject extends Serializable {
	UUID getID();
}
