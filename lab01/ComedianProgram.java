import java.util.Scanner;

class ComedianProgram { 

	/**
	 * Tells a knock knock.
	 *
	 * @param  args the command line arguments presented as an array of Strings
	 * @return 		none
	 */
	public static void main(String[] args) {
		Scanner userIn = new Scanner(System.in);

		System.out.println("To exit at anytime hit ctrl-c/command-c\n");

		while (true) {
			System.out.println("Knock Knock.");
			userIn.nextLine();
			System.out.println("Recursion.");
			userIn.nextLine();
		}

		// Since we never reach here we never close the scanner
		// This is bad!!
		//userIn.close();
	}

}
