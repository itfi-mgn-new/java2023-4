package lesson18;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientTest {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		try(final Socket	s = new Socket("mail.ru",443);
			final InputStream	is = s.getInputStream();
			final OutputStream	os = s.getOutputStream(); ) {
			
			/// lkvjklfdjvlkj
		}
	}

}
