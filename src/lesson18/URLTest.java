package lesson18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import sun.net.www.protocol.file.FileURLConnection;

public class URLTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		final URL	url = new URL("file://./c:/temp/vassya.txt");
		final FileURLConnection	conn = (FileURLConnection)url.openConnection();
		
		
		System.err.println("Conn.class="+conn.getClass());
		
		try(final InputStream		is = conn.getInputStream();
			final Reader			rdr = new InputStreamReader(is);
			final BufferedReader	brdr = new BufferedReader(rdr);	) {
			
			String	line;
			
			while ((line = brdr.readLine()) != null) {
				System.err.println(line);
			}
			
		}
		
	}

}
