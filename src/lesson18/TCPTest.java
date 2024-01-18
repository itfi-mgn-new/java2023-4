package lesson18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		try(final ServerSocket	ss = new ServerSocket(8000)) {
			try(final Socket		s = ss.accept();
				final InputStream	is = s.getInputStream();
				final OutputStream	os = s.getOutputStream(); 
				final Writer		wr = new OutputStreamWriter(os);
				final Reader			rdr = new InputStreamReader(is);
				final BufferedReader	brdr = new BufferedReader(rdr);	) {
					
				String	line;
					
				while ((line = brdr.readLine()) != null) {
						System.err.println(line);
				}
				final String 	resp = "skdfjkljdfkljsdf";
			    
				wr.write("HTTP/1.1 200 OK\r\n" +
			    "Content-Type: text/html\r\n" +
			    "Content-length: 0\r\n" +
			    resp + "\r\n" + 
			    "\r\n\r\n");
				wr.flush();
			}
		}
	}

}
