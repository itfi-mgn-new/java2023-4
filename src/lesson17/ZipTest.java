package lesson17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		try(final InputStream 	is = new FileInputStream("c:/temp/temp.zip");
			final ZipInputStream	zis = new ZipInputStream(is)) {
		
			ZipEntry	ze;
			
			while ((ze = zis.getNextEntry()) != null) {
				// try() - is wrong!!!!!!!!
				//zis.closeEntry();
				byte[] 	buffer = new byte[100];
				int		length, displ = 0;
				
				while ((length = zis.read(buffer, displ, buffer.length - displ)) > 0) {
					displ += length;
				}
				System.err.println("Part: "+ze.getName()+", content: "+new String(buffer, 0, displ));
			}
		}
		
		try(final OutputStream 		os = new FileOutputStream("c:/temp/assa.zip");
			final ZipOutputStream	zos = new ZipOutputStream(os)) {
		
			ZipEntry	ze = new ZipEntry("a/b/c/d/e.txt");
			
			ze.setMethod(ZipEntry.DEFLATED);
			zos.putNextEntry(ze);
			
			Writer	wr = new OutputStreamWriter(zos);
			
			wr.write("kdsjfksdfjklj");
			wr.flush();
			
			ze = new ZipEntry("a.txt");
			
			ze.setMethod(ZipEntry.DEFLATED);
			zos.putNextEntry(ze);
			
			wr = new OutputStreamWriter(zos);
			
			wr.write("4838897");
			wr.flush();
			
			// zos.finish();
		}
		
	}
}
