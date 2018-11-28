package premiumtravel.cache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Lock;
import javax.ejb.LockType;
import java.io.Serializable;
import java.util.*;

/**
 * A basic registry for storing items that extend from {@link RegistryObject}.
 *
 * @param <T> The type of object to be stored.
 */
public abstract class Registry<T extends RegistryObject> extends Observable implements Serializable {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );

	private static final long serialVersionUID = -5641676899131094013L;
	protected final List<T> registryList;

	protected Registry() {
		registryList = new LinkedList<>();
	}

	/**
	 * Resets the {@link T}s to the given list. The list can be made {@code null} in order to save on resources while
	 * indicating an empty list.
	 * <p></p>
	 * <p><i>Convenience method to be used by the {@link Cache} or current {@link DataSerializer}.</i></p>
	 *
	 * @param newList
	 */
	@Lock( LockType.WRITE )
	protected void resetRegistry( Collection<T> newList ) {
		this.registryList.clear();
		if ( newList != null ) {
			this.registryList.addAll( newList );
		}
	}

	/**
	 * Returns a clone that shows the current {@link T}s registered in the system.
	 *
	 * @return A new {@link List} of the {@link T}s in the system at the time the method was called.
	 */
	@Lock( LockType.READ )
	public List<T> getAll() {
		return new LinkedList<>( this.registryList );
	}

	/**
	 * Retrieves the registered item with the given {@code id}.
	 *
	 * @param id The {@link UUID} of the {@link RegistryObject} to be retrieved.
	 * @return The {@link RegistryObject} whose {@link UUID} corresponds with the given parameter if it exists, or
	 * {@code null} if no object is registered with that ID.
	 */
	@Lock( LockType.READ )
	public T get( UUID id ) {
		// This is inefficient. TODO Find if a hashmap or tree might be better
		for ( T t : this.registryList ) {
			if ( t.getID().equals( id ) ) {
				return t;
			}
		}
		return null;
	}

	/**
	 * Retrieves the registered item with the given {@code id}.
	 *
	 * @param id The {@link String} ID of the {@link RegistryObject} to be retrieved.
	 * @return The {@link RegistryObject} whose {@link UUID} corresponds with the given parameter if it exists, or
	 * {@code null} if no object is registered with that ID.
	 */
	@Lock( LockType.READ )
	public T get( String id ) {
		// This is inefficient. TODO Find if a hashmap or tree might be better
		for ( T t : this.registryList ) {
			if ( t.getID().toString().equals( id ) ) {
				return t;
			}
		}
		return null;
	}

	/**
	 * Adds a new {@link T} to the registry.
	 *
	 * @param t The new {@link T} to be added.
	 */
	@Lock( LockType.WRITE )
	public void add( T t ) {
		synchronized ( this.registryList ) {
			this.registryList.add( t );
		}
		notifyObservers();
	}
}
