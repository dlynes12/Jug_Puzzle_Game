/**
 * Capture a person who can drink soda.
 * A person can sip or gulp from a can of soda.
 * The person knows how much soda they have consumed,
 * and know how thirsty they are.
 */
public class Person {
    private int amountOfSodaDrunk;
    private String name;

    /**
     * Construct a new Person with the given name.
     * So far they will have consumed 0 soda
     * @param name the name given to this person
     */
    public Person(String name){
        this.name = name;
        this.amountOfSodaDrunk = 0;
    }

    /**
     * Take a sip from s, modifying the amount this has consumed
     * @param s the can of soda this will gulp from
     */
    public void sipFrom(SodaCan s){
        s.sip();
    }

    /**
     * Take a gulp from s, modifying the amount this has consumed
     * @param s the can of soda this will gulp from
     */
    public void gulpFrom(SodaCan s){
        returns.gulp();
    }

    /**
     * A person is
     * "very thirsty" if they drank less than 175,
     * "thirsty" if they drank less than 375,
     * "satisfied" if they drank at least 375
     * @return the thirst status of this
     */
    public String getThirstStatus(){
        if (this.amountOfSodaDrunk < 175) {
            return "very thirsty";
        }

        else if (this.amountOfSodaDrunk < 375) {
	     return "thirsty";
        }


        else {
            return "satisfied";
        }
    }


    /**
     * @return a string representation of this
     */

    public String toString(){
        return "I am "+this.name+", and I am "+this.getThirstStatus();
    }
}
