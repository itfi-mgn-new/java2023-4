package lesson1;

public class PrimitiveTypes {
	static final int 	TEN_MINUTES = 10;
/*	byte;	// signed char; -128..+127
	short;	// singed short; -32768..+32767
	int;	// signed int;	 -2^31+2^31
	long;	// signed long;		-2^63..2^63  
	char;	// unsigned short;  0..65535
	
	float;	// +-10-38..+-10^38, 6 значащих цифр
	double; // +-10-306..+-10^306, 15 значащих цифр
	
	boolean;	false/true;
	
	Object	&z;
	int[]   z = new int[10];
	
	*/
	
	public static void main(final String[] args) {
		// TODO Auto-generated method stub
		final byte	b1 = 10, b2 = 20, b3 = (byte)(b1 + b2);
		
		System.err.println("b1+b2="+(b1+b2));
		System.err.println("b1-b2="+(b1-b2));
		System.err.println("b1*b2="+(b1*b2));
		System.err.println("b1/b2="+(b1/b2));
		System.err.println("b1%b2="+(b1%b2));

		short	s1 = 10, s2 = 20, s3 = (short)(s1 + s2);
		
		System.err.println("s1+s2="+(s1+s2));
		System.err.println("s1-s2="+(s1-s2));
		System.err.println("s1*s2="+(s1*s2));
		System.err.println("s1/s2="+(s1/s2));
		System.err.println("s1%s2="+(s1%s2));
		
		float	f1 = 10, f2 = 20, f3 = f1 + f2;
		
		System.err.println("f1+f2="+(f1+f2));
		System.err.println("f1-f2="+(f1-f2));
		System.err.println("f1*f2="+(f1*f2));
		System.err.println("f1/f2="+(f1/f2));
		System.err.println("f1%f2="+(f1%f2));
		
		char	c1 = 10, c2 = 20, c3 = (char)(c1 + c2);
		
		System.err.println("c1+c2="+(c1+c2));
		System.err.println("c1-c2="+(c1-c2));
		System.err.println("c1*c2="+(c1*c2));
		System.err.println("c1/c2="+(c1/c2));
		System.err.println("c1%c2="+(c1%c2));
		
		boolean	z1 = true, z2 = false;
		
		System.err.println("z1||z22="+(z1||z2));
		System.err.println("z1&&z22="+(z1&&z2));
		System.err.println("!z1="+(!z1));

		System.err.println("z1|z22="+(z1|z2));
		System.err.println("z1&z22="+(z1&z2));
		
		System.err.println("c1 > c2? "+(c1 > c2));
		System.err.println("c1 >= c2? "+(c1 >= c2));
		System.err.println("c1 < c2? "+(c1 < c2));
		System.err.println("c1 <= c2? "+(c1 <= c2));
		System.err.println("c1 == c2? "+(c1 == c2));
		System.err.println("c1 != c2? "+(c1 != c2));
		
		System.err.println("c1 != c2 ? 10 : 20 = "+(c1 != c2 ? 10 : 20));
	
		System.err.println("-------------------------");
		
		int	x1 = 5 /* 0b0101 */, x2 = 10 /* 0b1010 */;
		
		System.err.println("x1 | x2 = "+(x1 | x2));
		System.err.println("x1 & x2 = "+(x1 & x2));
		System.err.println("x1 ^ x2 = "+(x1 ^ x2));
		System.err.println("~x1 = "+(~x1)); /* 0b11111111111111111111111111111010 */

		// IEEE754
		System.err.println("x2 << 2 = "+(x2 << 2));
		System.err.println("x2 >> 2 = "+(x2 >> 2));
		System.err.println("x2 >>> 2 = "+(x2 >>> 2));
		
		System.err.println("(-x2) >> 2 = "+((-x2) >> 2));
		System.err.println("(-x2) >>> 2 = "+((-x2) >>> 2));
		
		x1 = 10;
		x1 = 0xFEdA;
		x1 = 0b1100;
		x1 = 077;
		
		long	long1;
		
		long1 = 0xDE00;
		long1 = 1234567890123456L;
		
		float float1;
		
		float1 = 0;
		float1 = 0.5f;
		
		c1 = 0;
		c1 = 'a';
		c1 = '\n';
		c1 = '\077';
		c1 = '\u2Ed0';
		
		float1 = 1_0_0_0_000.120_450e-12f;
		
//		int аццкийСотона = 13;
		
	}
}
