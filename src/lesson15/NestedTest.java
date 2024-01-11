package lesson15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class NestedTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		try(InputStream is = new FileInputStream("c:/temp/vassya.txt");
			Reader		rdr = new InputStreamReader(is);
			BufferedReader	brdr = new BufferedReader(rdr);
//			OutputStream os = new FileOutputStream("c:/temp/target.txt");
//			GZIPOutputStream	g = new GZIPOutputStream(os);	
//			Writer		wr = new OutputStreamWriter(os)
				) {
			
//			char[]	b = new char[100000000];
//			int len, displ = 0;
//			
//			while ((len = rdr.read(b, displ, b.length - displ)) > 0) {
//				displ += len;
//			}
//			System.err.println("Read: "+	displ);
//			wr.write(b, 0, displ);
//			wr.flush();
			String	s;
			int sum = 0;
			while ((s = brdr.readLine()) != null) {
				System.err.println("Read: "+s);
				sum += Integer.valueOf(s);
				//wr.write(s);
			}
			//wr.flush();
			System.err.println("Sum="+sum);
			} 
		}

}
