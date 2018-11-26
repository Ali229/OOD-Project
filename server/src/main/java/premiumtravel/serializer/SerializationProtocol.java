package premiumtravel.serializer;

import java.io.File;
import java.io.Serializable;
import java.util.function.Function;

/**
 *
 */
public enum SerializationProtocol {

	DEFAULT( DefaultSerializer::new ),
	XML( XMLSerializer::new ),
	JSON( XMLSerializer::new );

	private MyFunction<File, DataSerializer> createSerializer;

	SerializationProtocol( MyFunction<File, DataSerializer> createSerializer ) {
		this.createSerializer = createSerializer;
	}

	public DataSerializer getSerializer( File file ) throws Exception {
		return this.createSerializer.apply( file );
	}

	/**
	 * Implementation of {@link Function} that allows for throwing exceptions
	 *
	 * @param <T>
	 * @param <R>
	 */
	public interface MyFunction<T, R> extends Serializable {
		R apply( T t ) throws Exception;
	}

}
