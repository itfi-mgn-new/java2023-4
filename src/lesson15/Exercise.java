package lesson15;

import java.io.BufferedReader;
import java.io.File;
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

public class Exercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final File	src = new File("c:/temp/alles.txt");
		final File	dest = new File("c:/temp/allesnew.txt");
		
		try(final InputStream		is = new FileInputStream(src);
			final Reader			rdr = new InputStreamReader(is, "utf-8");
			final BufferedReader	brdr = new BufferedReader(rdr);
			final OutputStream		os = new FileOutputStream(dest);
			final Writer			wr = new OutputStreamWriter(os)) {
			
			String	line;
			int	lineNo = 0;
			
			line = brdr.readLine();
			wr.write(line+System.lineSeparator());
			
			while ((line = brdr.readLine()) != null) {
				lineNo++;
				String[]	parts = line.split(",");
				
				if (parts.length != 3) {
					throw new IOException("File ["+src+"], line ["+lineNo+"]: illegal record format, must be <family>, <name>, <salary>");
				}
				
				try {
					parts[2] = Integer.toString(Integer.valueOf(parts[2].trim()) * 2);
				} catch (NumberFormatException exc) {
					throw new IOException("File ["+src+"], line ["+lineNo+"]: salary ["+parts[2]+"] is not a number");
				}
				
				wr.write(parts[0]+','+parts[1]+','+parts[2]+System.lineSeparator());
			}
			wr.flush();
		} catch (FileNotFoundException e) {
			System.err.println("File ["+src+"] not found");
		} catch (IOException e) {
			System.err.println("File ["+src+"]: I/O error during parse ("+e.getLocalizedMessage()+")");
		}
	}

}
