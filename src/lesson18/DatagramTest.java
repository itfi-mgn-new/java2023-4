package lesson18;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class DatagramTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Thread	t = new Thread(()->{
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			try(final DatagramSocket	socket = new DatagramSocket(9999)) {
				final byte[]			content = new byte[5];
				final DatagramPacket	pack = new DatagramPacket(content, content.length);
			
				socket.receive(pack);
				
				System.err.println("Recv: "+new String(content, 0, pack.getLength()));
			} catch (IOException e) {
			}
		});
		t.setDaemon(true);
		t.start();
		
		try(final DatagramSocket	socket = new DatagramSocket(8000)) {
			final byte[]			content = "test string".getBytes();
			final DatagramPacket	pack = new DatagramPacket(content, content.length, new InetSocketAddress("localhost",9999));
		
			socket.send(pack);
		}
		System.err.println("Done");
	}

}
