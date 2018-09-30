package ca.utoronto.utm.lab04;
public class UnderstandInheritance {

	public static void main(String[] args) {
		// 6) Review class Square, understand what happens when we execute the following:
		// that is, which methods are called and when...
		
		System.out.println("Starting");
		Square s=new Square(); 
		System.out.println(s.toString());
		s.setWidth(20);
		s.setX(10);
		
	}

}
