public class TestSodaCan {
	/**
         * javac TestSodaCan
         * java TestSodaCan > MyTestSodaCanOut.txt
         * diff TestSodaCanOut.txt MyTestSodaCanOut.txt
         * Above should return nothing if your output exactly matches mine
         */

	public static void main(String [] args){
		System.out.println("Testing a can of soda");

		SodaCan s1 = new SodaCan("RootBeer");
		System.out.println(s1);
		System.out.println("isOpen="+s1.isOpen());
		System.out.println("Sipping "+s1.sip());
		System.out.println(s1);
		System.out.println("Gulping "+s1.gulp());
		System.out.println(s1);
		System.out.println("Opening ");
		s1.open();
		System.out.println("isOpen="+s1.isOpen());
		System.out.println(s1);
		System.out.println("Sipping "+s1.sip());
		System.out.println(s1);
		System.out.println("Gulping "+s1.gulp());
		System.out.println(s1);
		System.out.println("Sipping "+s1.sip());
		System.out.println(s1);
		System.out.println("Gulping "+s1.gulp());
		System.out.println(s1);
		System.out.println("Gulping "+s1.gulp());
		System.out.println(s1);
		System.out.println("Gulping "+s1.gulp());
		System.out.println(s1);
		System.out.println("Gulping "+s1.gulp());
		System.out.println(s1);
		System.out.println("Sipping "+s1.sip());
		System.out.println(s1);
		System.out.println("Gulping "+s1.gulp());
		System.out.println(s1);
	}
}
