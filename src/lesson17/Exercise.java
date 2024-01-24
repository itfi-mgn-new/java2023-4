package lesson17;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Exercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final File	src = new File("c:/temp/alles.zip");
		final File	dest = new File("c:/temp/allesnew.zip");
		
		try(final InputStream		is = new FileInputStream(src);
			final ZipInputStream	zis = new ZipInputStream(is);
			final OutputStream		os = new FileOutputStream(dest);
			final ZipOutputStream	zos = new ZipOutputStream(os)) {

			zis.getNextEntry();		

			final Reader			rdr = new InputStreamReader(zis, "utf-8");
			final BufferedReader	brdr = new BufferedReader(rdr);
	
			ZipEntry	ze = new ZipEntry("dslkfjklsdj");
			
			ze.setMethod(ZipEntry.DEFLATED);
			zos.putNextEntry(ze);
			
			final Writer			wr = new OutputStreamWriter(zos);
			
			String	line;
			
			line = brdr.readLine();
			wr.write(line+System.lineSeparator());
			
			while ((line = brdr.readLine()) != null) {
				String[]	parts = line.split(",");
				
				parts[2] = Integer.toString(Integer.valueOf(parts[2].trim()) * 2);
				
				wr.write(parts[0]+','+parts[1]+','+parts[2]+System.lineSeparator());
			}
			wr.flush();
		} catch (IOException e) {
			System.err.println("Vse propalo, gips snimayut, klient uezzhaet!!!");
		}
	}

}
