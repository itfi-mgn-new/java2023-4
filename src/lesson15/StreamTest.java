package lesson15;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamTest {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub

		
//		try(InputStream is = new FileInputStream("c:/temp/source.txt");
//			OutputStream os = new FileOutputStream("c:/temp/target.txt")) {
//			byte	b = (byte)is.read();	// -1
//			System.err.println("Read: "+b);
//			os.write(b);
//			os.flush();
////			read(is);
//		} 
		try(InputStream is = new FileInputStream("c:/temp/source.txt");
			OutputStream os = new FileOutputStream("c:/temp/target.txt")) {
			byte[]	b = new byte[100000000];
			int len, displ = 0;
			
			while ((len = is.read(b, displ, b.length - displ)) > 0) {
				displ += len;
			}
			// b
			System.err.println("Read: "+	displ);
			os.write(b, 0, displ);
			os.flush();
//				read(is);
		} 
		// finally {
		// os.close();
		// is.close();
		//}
	}

//	static void read(final InputStream is) throws IOException {
//		byte	b = (byte)is.read();	// -1
//		System.err.println("Read: "+b);
//	}
	
}
