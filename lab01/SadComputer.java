import java.util.Scanner;

class SadComputer {
	
	/**
	 * Convert a decimal (base 10) number into a binary (base 2) number. 
	 * Make sure the binary string is 8 bits long! For aesthetic purposes.
	 *
	 * @param  decimalNum  the decimal number to convert into binary number
	 * @return 			   the binary number in String format (know why?)
	 */
	public static String decimalToBinary(int decimalNum) {
		String binaryStr = "";
		
		while (decimalNum != 0) {
			binaryStr += Integer.toString(decimalNum % 2);
			decimalNum /= 2;
		}
		
		for (int count = binaryStr.length(); count < 8; count++) {
			binaryStr += "0";
		}

		return binaryStr;
	}

	/**
	 * Asks for the users age. Gets sad when it realizes it can't understand 
	 * the decimal (base 10) system.
	 *
	 * @param  args the command line arguments presented as an array of Strings
	 * @return 		none
	 */
	public static void main(String[] args) {
		Scanner userIn = new Scanner(System.in);
		String name, ageStringBits;
		int age;

		System.out.println("Hey there! My  name is Computer - what's yours?");
		
		name = userIn.nextLine();

		System.out.println("\nNice to meet you " + name + "!");
		System.out.print("By the way, I think I'm older than you. ");
		System.out.println("How old are you anyways??");

		age  = userIn.nextInt();
		
		ageStringBits = decimalToBinary(age);

		System.out.println("\nWhoa! You're " + ageStringBits + " years old!?");
		System.out.println("\nI guess I was wrong :'(");
		System.out.println("Looks like you're the older one.");
	}

}
