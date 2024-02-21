package lesson25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.Reader;
import java.io.Writer;

public class PipeTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		try(final PipedOutputStream	pos = new PipedOutputStream();
			final PipedInputStream	pis = new PipedInputStream(pos)) {
		
			Thread	t1 = new Thread(()->{
					final Reader			rdr = new InputStreamReader(pis);
					final BufferedReader	brdr = new BufferedReader(rdr);
					
					try {
						System.err.println("Read: "+brdr.readLine());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			});
			
			final Writer	wr = new OutputStreamWriter(pos);
			
			t1.start();
			
			wr.write("URA!!!\n");
			wr.flush();
			Thread.sleep(1000);
		}
	}

}
