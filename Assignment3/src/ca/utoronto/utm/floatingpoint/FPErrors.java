package ca.utoronto.utm.floatingpoint;

public class FPErrors {
	/**
	 * During a floating point calculation we arrive at result c.
	 * if we could perform the calculation
	 * on real numbers we would arrive at the actual result a. 
	 * 
	 * We define
	 * the absolute error = |a-c|
	 * the relative error = |a-c|/|a|
	 **/


	public static void main(String [] args){
		FPErrors e = new FPErrors();
		e.a();
		e.b();
	}
	
	/** 
	 * a) Give an example of a float computation which results in
	 *    an absolute error >= 1000 AND a relative error <= 10^-6.
	 *    Explain, using binRep and your understanding of floating
	 *    point calculations. Note: This is a large absolute error
	 *    and a small relative error.
	 */
	public void a() {
		float a = 2.75e-2f; // replace this with what you expect the actual to be
		float c = 0.0f; 
		
		// YOUR CALCULATION GOES HERE.

		System.out.println("question a: absoluteError="+absoluteError(a,c));
		System.out.println("question a: relativeError="+relativeError(a,c));

		/**
		 * YOUR EXPLANATION GOES HERE. WRITE DOWN YOUR CALCULATION
		 * USING THE IEEE SINGLE STANDARD TO CLARIFY WHY THE 
		 * CALCULATION INTRODUCES ERRORS (Hint: Use binRep)
		 * 
		 * SEE EXAMPLE ON ASSIGNMENT WEB PAGE
		 */
	}
	
	/**   
	 * b) Give an example of a float computation which results in
	 *    a relative error >= 10^-1 AND an absolute error >= 10^2.
	 *    Explain, using binRep and your understanding of floating
	 *    point calculations. Note: This is a large relative error
	 *    and small absolute error.
	 */
	public void b() {
		float a = 2.78e12f; // replace this with what you expect the actual to be
		float c = 0.0f;
		// YOUR CALCULATION GOES HERE
		
		System.out.println("question b: absoluteError="+absoluteError(a,c));
		System.out.println("question b: relativeError="+relativeError(a,c));

		/**
		 * YOUR EXPLANATION GOES HERE. WRITE DOWN YOUR CALCULATION
		 * USING THE IEEE SINGLE STANDARD TO CLARIFY WHY THE 
		 * CALCULATION INTRODUCES ERRORS (Hint: Use binRep)
		 * 
		 * SEE EXAMPLE ON ASSIGNMENT WEB PAGE
		 */
	}
	/**
	 * We approximate the absolute error behind a floating point
	 * calculation. Note that we can't actually compute
	 * the real absoluteError, since we don't have access
	 * to the real result of the calculation, and we are using
	 * floating point arithmetic to calculate.
	 * 
	 * @param a What the actual result of the calculation should be.
	 * @param c The computed result of the calculation.
	 * @return |a-c|
	 */
	public float absoluteError(float a, float c){
		return Math.abs(a-c);
	}

	/**
	 * We approximate the relative error behind a floating point
	 * calculation. Note that we can't actually compute
	 * the real relativeError, since we don't have access
	 * to the real result of the calculation, and we are using
	 * floating point arithmetic to calculate.
	 * 
	 * @param a What the actual result of the calculation should be.
	 * @param c The computed result of the calculation.
	 * @return
	 */
	public float relativeError(float a, float c){
		return Math.abs(a-c)/Math.abs(a);
	}

}
