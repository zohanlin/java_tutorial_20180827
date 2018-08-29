
public class Variables_Test {

	public static void main(String[] args) {
		final double PI_value = 3.141596;
		
		// TODO Auto-generated method stub
		System.out.println("Variables_Test!");
		System.out.printf("Byte : %d ~ %d%n", Byte.MIN_VALUE, Byte.MAX_VALUE);
		System.out.printf("Short : %d ~ %d%n", Short.MIN_VALUE, Short.MAX_VALUE);
		System.out.printf("Integer : %d ~ %d%n", Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.printf("Long : %d ~ %d%n", Long.MIN_VALUE, Long.MAX_VALUE);

		System.out.printf("Float : %f ~ %f%n", Float.MIN_VALUE, Float.MAX_VALUE);
		System.out.printf("Float : example:%f%n", 15.1234);
		System.out.printf("Float : example(%%.2f):%.2f%n", 15.1234);
		System.out.printf("Float : example(%%7f):%7f%n", 15.1234);
		System.out.printf("Float : example(%%10f):%10f%n", 15.1234);
		System.out.printf("Float : example(%%7.2f):%7.2f%n", 15.1234);
		
		System.out.printf("Double : %f ~ %f%n", Double.MIN_VALUE, Double.MAX_VALUE);

		System.out.printf("Character(%%h) : %h ~ %h%n", Character.MIN_VALUE, Character.MAX_VALUE);
		System.out.printf("Boolean : %b ~ %b%n", Boolean.TRUE, Boolean.FALSE);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.printf("%nPI_value=%f%n", PI_value);
		//PI_value += 1; //error
		//The final local variable PI_value cannot be assigned. It must be blank and not using a compound assignment
		double PI1;
		PI1 = PI_value + 1;
		System.out.printf("PI1=%f%n", PI1);
		
		int num1 = 11;
		int num2 = 0xa2;
		int num3 = 0Xaf;
		int num4 = 073;

		System.out.printf("num1=%d%n", num1);
		System.out.printf("num2=%d%n", num2);
		System.out.printf("num3=%d%n", num3);
		System.out.printf("num4(%%d)=%d%n", num4);
		System.out.printf("num4(%%o)=0%o%n", num4);
		System.out.printf("num4(%%x)=0x%x%n", num4);
		System.out.printf("num4(%%h)=0x%h%n", num4);
		
		double numf1 = 0.00456;
		double numf2 = 4.56e-3;
		double numf3 = 456E-3;
		System.out.printf("numf1(%%f)=%f%n", numf1);
		System.out.printf("numf1(%%e)=%e%n", numf1);
		System.out.printf("numf1(%%E)=%E%n", numf1);
		System.out.printf("numf2(%%f)=%f%n", numf2);
		System.out.printf("numf2(%%e)=%e%n", numf2);
		System.out.printf("numf2(%%E)=%E%n", numf2);
		System.out.printf("numf3(%%f)=%f%n", numf3);
		System.out.printf("numf3(%%e)=%e%n", numf3);
		System.out.printf("numf3(%%E)=%E%n", numf3);

		Character ch1 = 'A';
		char ch2 = 'B';
		char ch3 = 'µ¤';
		Character ch4 = 67;
		Character ch5 = 0x67;
		System.out.printf("%nch1(%%c)=%c%n", ch1);
		System.out.printf("ch1(%%s)=%s%n", ch1);
		System.out.printf("ch1(%%h)=%h%n", ch1);
		System.out.printf("ch2(%%C)=%C%n", ch2);
		System.out.printf("ch2(%%H)=%H%n", ch2);
		System.out.printf("ch3(%%c)=%c%n", ch3);
		System.out.printf("ch3(%%h)=%h%n", ch3);
		System.out.printf("ch4(%%c)=%c%n", ch4);
		System.out.printf("ch4(%%h)=%h%n", ch4);
		System.out.printf("ch5(%%c)=%c%n", ch5);
		System.out.printf("ch5(%%h)=%h%n", ch5);
		
		System.out.printf("\u0041\u0042\u0000042\u7ae3\u0041\n");//require 4 numbers, %n is better than \n.
		
		boolean bool1 = true;
		boolean bool2 = false;

		System.out.printf("bool1(%%b)=%b%n", bool1);
		System.out.printf("bool1(%%B)=%B%n", bool1);
		System.out.printf("bool2(%%b)=%b%n", bool2);
		System.out.printf("bool2(%%B)=%B%n", bool2);
		
		int num_1 = 1_456_777;
		double num_d1 = 3.141_592_653;
		System.out.printf("num_1=%d%n", num_1);
		System.out.printf("num_d1=%f%n", num_d1);

		int binary_1 = 0b1111_1111_1111;
		int binary_2 = 0B1000_0000_0000;
		System.out.printf("binary_1(%%d)=%d%n", binary_1);
		System.out.printf("binary_1(%%o)=0%o%n", binary_1);
		System.out.printf("binary_1(%%x)=0x%x%n", binary_1);
		System.out.printf("binary_1(%%h)=0x%h%n", binary_1);
		System.out.printf("binary_1=%d=0b%s%n", binary_1, Integer.toBinaryString(binary_1));
		System.out.printf("binary_2(%%d)=%d%n", binary_2);
		System.out.printf("binary_2(%%o)=0%o%n", binary_2);
		System.out.printf("binary_2(%%x)=0x%x%n", binary_2);
		System.out.printf("binary_2(%%h)=0x%h%n", binary_2);
		System.out.printf("binary_2=%d=0b%s%n", binary_2, Integer.toBinaryString(binary_2));

		///////////////////////////////////////// Bitwise Operation //////////////////////////////////////////////////////////
		
		int a = 10, b = 3;
		if(b != 0 && a / b > 2) //Avoid divide zero.
		{
			System.out.println("True");
		}

		System.out.println("\n///////////////  Bitwise Operation  ///////////////");
		int shift_1 = 0b0000_1111;
		int shift_2 = 0b1111_0000;
		short shift_3 = 0b0000_1111;
		short shift_4 = 0b0111_0001_0111_0000;
		short shift_5 = 0b0111_1111_1111_1111;
		//short shift_6 = 0b1111_1111_1111_1111; //Type mismatch: cannot convert from int to short
		System.out.println("Shift shift_1 test");
		System.out.println(Integer.toBinaryString(shift_1 << 2));
		System.out.println(Integer.toBinaryString(shift_1 >> 2));
		System.out.println(Integer.toBinaryString(shift_1 >>> 2));
		
		System.out.println("Shift shift_2 test");
		System.out.println(Integer.toBinaryString(shift_2 << 2));
		System.out.println(Integer.toBinaryString(shift_2 >> 2));
		System.out.println(Integer.toBinaryString(shift_2 >>> 2));

		System.out.println();
		System.out.print("shift_1 & shift_2 = ");
		System.out.println(Integer.toBinaryString(shift_1 & shift_2));
		System.out.println();
		System.out.print("shift_1 | shift_2 = ");
		System.out.println(Integer.toBinaryString(shift_1 | shift_2));
		System.out.print(" shift_1 = \t\t0000");//add four 0s for test
		System.out.println(Integer.toBinaryString(shift_1));
		System.out.print(" shift_1 >> 2 = \t000000");//add six 0s for test
		System.out.println(Integer.toBinaryString(shift_1 >> 2));
		System.out.print(" shift_1 >>> 2 = \t000000");//add six 0s for test
		System.out.println(Integer.toBinaryString(shift_1 >>> 2));
		System.out.print(" shift_1 << 2 = \t00");//add two 0s for test
		System.out.println(Integer.toBinaryString(shift_1 << 2));
		System.out.print(" ~shift_1 = \t\t");
		System.out.println(Integer.toBinaryString(~shift_1));
		System.out.print(" ~shift_1 >> 2 = \t");
		System.out.println(Integer.toBinaryString(~shift_1 >> 2));
		System.out.print(" ~shift_1 >>> 2 = \t00");//add two 0s for test
		System.out.println(Integer.toBinaryString(~shift_1 >>> 2));
		System.out.print(" ~shift_1 << 2 = \t");
		System.out.println(Integer.toBinaryString(~shift_1 << 2));
		System.out.print(" ~shift_2 = ");
		System.out.println(Integer.toBinaryString(~shift_2));
		System.out.print(" shift_4 = ");
		System.out.println(Integer.toBinaryString(shift_4));
		System.out.print(" ~shift_4 = ");
		System.out.println(Integer.toBinaryString(~shift_4));
		System.out.print(" shift_5 = ");
		System.out.println(Integer.toBinaryString(shift_5));
		System.out.print(" ~shift_5 = ");
		System.out.println(Integer.toBinaryString(~shift_5));
		
		int shift_6 = 0;
		System.out.print("shift_6 | shift_6 = ");
		System.out.println(shift_6 | shift_6);
		System.out.print("shift_6 | ~shift_6 = ");
		System.out.println(shift_6 | ~shift_6);
		System.out.print("shift_6 & ~shift_6 = ");
		System.out.println(shift_6 & ~shift_6);
		System.out.print("~shift_6 & ~shift_6 = ");
		System.out.println(~shift_6 & ~shift_6);

		System.out.printf("shift_6 | shift_6 = 0b%s%n", Integer.toBinaryString((shift_6 | shift_6)));
		System.out.printf("shift_6 | ~shift_6 = 0b%s%n", Integer.toBinaryString((shift_6 | ~shift_6)));
		System.out.printf("shift_6 & shift_6 = 0b%s%n", Integer.toBinaryString((shift_6 & shift_6)));
		System.out.printf("shift_6 & ~shift_6 = 0b%s%n", Integer.toBinaryString((shift_6 & ~shift_6)));
		System.out.printf("~shift_6 & ~shift_6 = 0b%s%n", Integer.toBinaryString((~shift_6 & ~shift_6)));
		System.out.printf("shift_6 ^ shift_6 = 0b%s%n", Integer.toBinaryString((shift_6 ^ shift_6)));
		System.out.printf("shift_6 ^ ~shift_6 = 0b%s%n", Integer.toBinaryString((shift_6 ^ ~shift_6)));
		System.out.printf("~shift_6 ^ ~shift_6 = 0b%s%n", Integer.toBinaryString((~shift_6 ^ ~shift_6)));
		

		///////////////////////////////////////// Logical Operation ////////////////////////////////////////////////////////
		
		System.out.println("\n///////////////  Logical Operation  ///////////////");
		boolean bool3 = true;
		boolean bool4 = false;
		
		if(bool3)
			System.out.println("bool3 is True");
		else
			System.out.println("bool3 is False");
		
		if(bool4)
			System.out.println("bool4 is True");
		else
			System.out.println("bool4 is False");

		System.out.printf("bool3 is %b%n", bool3?Boolean.TRUE:Boolean.FALSE);
		System.out.printf("!bool3 is %b%n", !bool3?Boolean.TRUE:Boolean.FALSE);
		System.out.printf("bool4 is %b%n", bool4?Boolean.TRUE:Boolean.FALSE);
		System.out.printf("!bool4 is %b%n", !bool4?Boolean.TRUE:Boolean.FALSE);
		System.out.printf("bool3 || bool4 is %b%n", bool3 || bool4?Boolean.TRUE:Boolean.FALSE);
		System.out.printf("!bool3 || bool4 is %b%n", !bool3 || bool4?Boolean.TRUE:Boolean.FALSE);
		System.out.printf("bool3 && bool4 is %b%n", bool3 && bool4?Boolean.TRUE:Boolean.FALSE);
		System.out.printf("bool3 && !bool4 is %b%n", bool3 && !bool4?Boolean.TRUE:Boolean.FALSE);
		
		int bool_5 = 10, bool_6 = 15;
		System.out.printf("bool_5 > 5 || bool_6 > 20 is %b%n", bool_5 > 5 || bool_6 > 20?Boolean.TRUE:Boolean.FALSE);
		System.out.printf("!(bool_5 > 5) || bool_6 > 20 is %b%n", !(bool_5 > 5) || bool_6 > 20?Boolean.TRUE:Boolean.FALSE);
		System.out.printf("bool_5 > 5 && bool_6 > 20 is %b%n", bool_5 > 5 && bool_6 > 20?Boolean.TRUE:Boolean.FALSE);
		System.out.printf("bool_5 > 5 && !(bool_6 > 20) is %b%n", bool_5 > 5 && !(bool_6 > 20)?Boolean.TRUE:Boolean.FALSE);

		
		System.out.println("\n///////////////  ????????  ///////////////");
		int i_add_1 = 0;
		int i_add_sum = 0;

		System.out.printf("i_add_sum=%d, i_add_1=%d%n", i_add_sum, i_add_1);
		System.out.printf("i_add_sum = ++i_add_1, i_add_sum=%d, i_add_1=%d%n", i_add_sum=++i_add_1, i_add_1);//i_add_1 = i_add_1 + 1; i_add_sum = i_add_1;
		System.out.printf("i_add_sum = i_add_1++, i_add_sum=%d, i_add_1=%d%n", i_add_sum=i_add_1++, i_add_1);//i_add_sum = i_add_1; i_add_1 = i_add_1 + 1;
		System.out.printf("i_add_sum = --i_add_1, i_add_sum=%d, i_add_1=%d%n", i_add_sum=--i_add_1, i_add_1);//i_add_1 = i_add_1 - 1; i_add_sum = i_add_1;
		System.out.printf("i_add_sum = i_add_1--, i_add_sum=%d, i_add_1=%d%n", i_add_sum=i_add_1--, i_add_1);//i_add_sum = i_add_1; i_add_1 = i_add_1 - 1;

		System.out.println(0.8-1.0);
		System.out.println(1.2-1.0);
		System.out.println(1.0-0.8);
		
		int j = 1;
		System.out.println(++j/3);
		System.out.println(j);
		System.out.println(++j/3);
		System.out.println(j);
		System.out.println(++j/j);
		
		
		back1:
			for(int i = 0; i < 10; i++) 
			{
				back2:
					for(int j2 = 0; j2 < 10; j2++)
					{
						if(j2==9)
						{
							continue back1;
						}
					}
		System.out.println("Test");
			}
		
		
		///////////////////////////////////////// Test ////////////////////////////////////////
		//greatest common factor (greatest common divisor) 
		//(1000,495)=?
		int m = 1000, n = 495;
		int gcd_m = m, gcd_n = n;
		
		while(m > 0 && n > 0)
		{
			if(m >= n)// "m==n" make m = 0;
			{
				m -= n;
				continue;
			}
			n -= m;
		}
		
		System.out.printf("m=%d, n=%d%n", m, n);
		System.out.printf("(%d,%d) = %d%n", gcd_m ,gcd_n, n==0?m:n);		
		System.out.printf("[%d,%d] = %d%n", gcd_m ,gcd_n, (gcd_m * gcd_n) / (n==0?m:n));
		
		
		
		//Find all Armstrong number between 1 and 1000;
		//ex. 1^3 + 5^3 + 3^3
		double Armstrong = 0;
		System.out.println("Armstrong Number(1~1000):");
		for(int arm1 = 1; arm1 < 10; arm1++)
		{
			for(int arm2 = arm1; arm2 < 10; arm2++)
			{
				for(int arm3 = arm2; arm3 < 10; arm3++)
				{
					Armstrong = Math.pow(arm1, 3) + Math.pow(arm2, 3) + Math.pow(arm3, 3);
					if(Armstrong < 1000)
					{
						System.out.printf("%d^3 + %d^3 + %d^3 = ", arm1, arm2, arm3);
						//System.out.println(Armstrong);
						System.out.println((int)Armstrong);
					}
				}
			}
		}		
		
		
		
	}

}
