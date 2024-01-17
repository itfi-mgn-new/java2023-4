package lesson17;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class SerializationTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Dept	d = new Dept(10);
		
		try(final OutputStream		os = new FileOutputStream("c:/temp/test.bin");
			final ObjectOutputStream	dos = new ObjectOutputStream(os)) {
		
			dos.writeBoolean(true);
			dos.writeInt(123456);
			dos.writeFloat(3.14f);
			dos.writeUTF("sasasasasas");
			dos.writeObject(new String[] {"vassya", "petya"});
			dos.writeObject(new Person("ivanov","ivan","ivanovich",21,d));
			dos.reset();
			dos.writeObject(new Person("petrov","petr","petrovich",35,d));
			dos.flush();
		}

		try(final InputStream		is = new FileInputStream("c:/temp/test.bin");
			final ObjectInputStream	dis = new ObjectInputStream(is)) {
		
			System.err.println("Boolean: "+dis.readBoolean());
			System.err.println("Int: "+dis.readInt());
			System.err.println("Float: "+dis.readFloat());
			System.err.println("String: "+dis.readUTF());
			System.err.println("Object1: "+Arrays.toString(((String[])dis.readObject())));
			Person	p1 = (Person)dis.readObject();
			
			System.err.println("Object2: "+p1);
			System.err.println("Equals: "+p1.dept.equals(d));
			
			Person	p2 = (Person)dis.readObject();
			
			System.err.println("Object3: "+p2);
			System.err.println("Equals: "+p2.dept.equals(d));
			
			System.err.println("Equals together: "+p2.dept.equals(p1.dept));
		}
	}
}
