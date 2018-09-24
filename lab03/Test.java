public class Test {
	public static void main(String [] args){
		// Running this should produce exactly TestOut.txt
		// Do the following: 
		// javac Test
		// java Test > MyOut.txt
		// diff TestOut.txt MyOut.txt
		// If they are identical, you will see nothing!!!

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
