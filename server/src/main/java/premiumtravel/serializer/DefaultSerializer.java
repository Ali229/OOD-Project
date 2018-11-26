package premiumtravel.serializer;

import java.io.*;

public class DefaultSerializer extends DataSerializer {

	private ObjectOutputStream out;
	private ObjectInputStream in;

	/**
	 * @param file The file to save/load from
	 */
	protected DefaultSerializer( File file ) throws IOException {
		super( file );
		this.out = new ObjectOutputStream( new FileOutputStream( file ) );
		this.in = new ObjectInputStream( new FileInputStream( file ) );
	}

	@Override
	protected void saveData( SaveData data ) throws IOException {
		this.out.writeObject( data );
	}

	@Override
	protected SaveData loadData() throws IOException, ClassNotFoundException {
		return (SaveData) this.in.readObject();
	}
}
