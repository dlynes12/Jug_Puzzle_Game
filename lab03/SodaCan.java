/**
 * Capture a Can of Soda.
 * A Can of Soda has a type, amount (initially 250) and is initially closed.
 * Once opened, you can sip (take at most 10) or gulp (take at most 50) from
 * the can. Obviously, at all times, the amount of soda in the can is between 0 and 250.
 * An opened can can not be closed.
 */
public class SodaCan {

	/**
	 * Construct a new SodaCan of the specified type.
	 * The new can has 250 units in it, and is closed.
	 * @param t the type of soda, for example "RootBeer", "Coke", "Cherry"
	 */

        /**
         * open this SodaCan
         */

	/**
	 * @return whether this is open
	 */
	
        /**
         * remove up to 10cc of soda from this, provided this is open
         * @return the amount of soda actually removed
         */

        /**
         * remove up to 50cc of soda from this, provided this is open
         * @return the amount of soda actually removed
         */

        /**
         * @return the amount of soda left in this
         */

        /**
         * @return a string representation of this
         */
        public String toString(){
		String openString = (this.isOpen)?"open":"closed";
		return this.type+" "+openString+" "+this.amount;
        }
}
