package lesson24;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class RAFTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try(final RandomAccessFile	raf = new RandomAccessFile("c:/temp/kali-linux-2020.1b-live-amd64.iso","rw")) {
			final FileChannel fc = raf.getChannel();

			try(FileLock lock = fc.lock(100, 200, true)) {  // synchronized(..) {
			// sdkldjfkljksdfjlk
			} //lock.close();								// }
		}
	}
}
