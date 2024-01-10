package lesson15;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Arrays;

public class ByteArrayTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		byte[]	content;
		
		try(OutputStream	os = new ByteArrayOutputStream()) {
		
			os.write("123456789".getBytes());
			content = ((ByteArrayOutputStream)os).toByteArray();
		}
		
		try(InputStream		is = new ByteArrayInputStream(content);
			Reader		rdr = new InputStreamReader(is);
			BufferedReader	brdr = new BufferedReader(rdr)) {
			
			System.err.println("ReadL "+brdr.readLine());
//			byte[]	b = new byte[100];
//			int len, displ = 0;
//			
//			while ((len = is.read(b, displ, b.length - displ)) > 0) {
//				displ += len;
//			}
//			System.err.println("Read: "+Arrays.toString(b));
		}
	}

}
