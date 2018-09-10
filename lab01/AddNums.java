class AddNums {

	/**
	 * Parses the command line arguments and accumulated their sum and 
	 * displays the total.
	 *
	 * @param  args the command line arguments presented in an array of Strings
	 * @return 		none
	 */
	public static void main(String[] args) {
		int total = 0;
		
		for (int argIndex = 0; argIndex < args.length; argIndex++) {
			total += Integer.parseInt(args[argIndex]);
		}

		System.out.println("The total is...." + total);
	}

}
