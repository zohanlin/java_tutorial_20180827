
public class Variables_Test {

	public static void main(String[] args) {
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

		System.out.printf("Character : %h ~ %h%n", Character.MIN_VALUE, Character.MAX_VALUE);
		System.out.printf("Boolean : %b ~ %b%n", Boolean.TRUE, Boolean.FALSE);
	}

}
