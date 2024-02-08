package lesson22;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class PArsersTest {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		String s = String.format("name= %1$s, patroname= %1$10s, age=%3$-3d"
						, "vassya", "pupkin", 22);
		System.err.println(s);
		
		SimpleDateFormat	sdf = new SimpleDateFormat("dd 'URA' MM-yyyy");
		
		Date d = sdf.parse("21 URA 01-2001");
		
		System.err.println("Date: "+sdf.format(d));
		
		DecimalFormat	sd = new DecimalFormat("##0.00");
		
		Number val = sd.parse("123,45");
		
		System.err.println("Val="+val.doubleValue());
	
		System.err.println(MessageFormat.format("name={0}, patroname={1}, age={2,number,integer} ", "vassya", "pupkin", 22));
	
		MessageFormat mf = new MessageFormat("name={0}, patroname={1}, age={2,number,integer}");
		
		Object[] vals = mf.parse("name=vassya, patroname=pupkin, age=22");
		
		System.err.println(Arrays.toString(vals));
		
		
	}

}
