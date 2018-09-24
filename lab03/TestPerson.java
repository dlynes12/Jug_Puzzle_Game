public class TestPerson {
	/**
	 * javac TestPerson
	 * java TestPerson > MyTestPersonOut.txt
	 * diff TestPersonOut.txt MyTestPersonOut.txt
	 * Above should return nothing if your output exactly matches mine
	 */
	public static void main(String [] args){
		System.out.println("Testing a person interacting with a can of soda");
		Person p = new Person("Joe");
		SodaCan s2 = new SodaCan("Raspberry");
		System.out.println("Joe is sipping from the can of soda");
		p.sipFrom(s2);
		System.out.println(p);
		System.out.println(s2);
		System.out.println("Opening");
		s2.open();
		System.out.println("Joe is sipping from the can of soda");
		p.sipFrom(s2);
		System.out.println(p);
		System.out.println(s2);
		System.out.println("Joe is sipping from the can of soda");
		p.sipFrom(s2);
		System.out.println(p);
		System.out.println(s2);
		System.out.println("Joe is gulping from the can of soda");
		p.gulpFrom(s2);
		System.out.println(p);
		System.out.println(s2);
		System.out.println("Joe is gulping from the can of soda");
		p.gulpFrom(s2);
		System.out.println(p);
		System.out.println(s2);
		System.out.println("Joe is gulping from the can of soda");
		p.gulpFrom(s2);
		System.out.println(p);
		System.out.println(s2);
		System.out.println("Joe is gulping from the can of soda");
		p.gulpFrom(s2);
		System.out.println(p);
		System.out.println(s2);
		System.out.println("Joe is gulping from the can of soda");
		p.gulpFrom(s2);
		System.out.println(p);
		System.out.println(s2);
		System.out.println("Joe is gulping from the can of soda");
		p.gulpFrom(s2);
		System.out.println(p);
		System.out.println(s2);

	
		System.out.println("Joe is taking 4 gulps from a new can of soda");
		SodaCan s3 = new SodaCan("Coke");
		s3.open();
		p.gulpFrom(s3);
		p.gulpFrom(s3);
		p.gulpFrom(s3);
		p.gulpFrom(s3);
		System.out.println(p);
		System.out.println(s3);
	}
}
