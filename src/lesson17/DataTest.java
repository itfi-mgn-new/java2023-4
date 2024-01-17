package lesson17;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DataTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		try(final OutputStream		os = new FileOutputStream("c:/temp/test.bin");
			final DataOutputStream	dos = new DataOutputStream(os)) {
		
			dos.writeBoolean(true);
			dos.writeInt(123456);
			dos.writeFloat(3.14f);
			dos.writeUTF("sasasasasas");
			dos.flush();
		}

		try(final InputStream		is = new FileInputStream("c:/temp/test.bin");
			final DataInputStream	dis = new DataInputStream(is)) {
		
			System.err.println("Boolean: "+dis.readBoolean());
			System.err.println("Int: "+dis.readInt());
			System.err.println("Float: "+dis.readFloat());
			System.err.println("String: "+dis.readUTF());
		}
	}

}
