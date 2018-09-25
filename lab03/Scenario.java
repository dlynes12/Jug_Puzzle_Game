/**
 * The main method of this class plays out a scenario...
 * Jack has two cans of soda,
 * RootBeer and GingerAle, Jill also has two cans, Cherry and Grape.
 * Jack opens his RootBeer first, and gives it to Jill.
 * Jill completely drinks the RootBeer. Jack asks her if she is still
 * thirsty, Jill responds. Now Jill opens her Cherry soda and drinks it until
 * she is satisfied, then gives it to Jack. He takes a sip, but doesn't
 * like it. Jill checks how much is left in her Cherry soda, but decides
 * not to drink any more. Jack asks Jill if he can try her Grape soda.
 * Jack drinks about half of it, then stops and tells Jill how he now feels.
 * Finally, they check the amount available in all of the cans.
 */
public class Scenario {
	public Scenario() {
		Person Jack = new Person("Jack");
		Person Jill = new Person("Jill");
		
		SodaCan Jacks1Soda = new SodaCan("RootBeer");
		SodaCan Jacks2Soda = new SodaCan("GingerAle");

		SodaCan Jills1Soda = new SodaCan("Cherry");
		SodaCan Jills2Soda = new SodaCan("Grape");

		Jacks1Soda.open();
		Jill.gulpFrom(Jacks1Soda);
		Jill.gulpFrom(Jacks1Soda);
		Jill.gulpFrom(Jacks1Soda);
		Jill.gulpFrom(Jacks1Soda);
		Jill.gulpFrom(Jacks1Soda);
		Jill.getThirstStatus();
		
		Jills1Soda.open();	
		Jill.gulpFrom(Jills1Soda);
		Jill.gulpFrom(Jills1Soda);
		Jill.gulpFrom(Jills1Soda);

		Jack.sipFrom(Jills1Soda);
		Jills1Soda.getAmount();

		Jills2Soda.open();

		Jack.gulpFrom(Jills2Soda);
		Jack.gulpFrom(Jills2Soda);
		Jack.sipFrom(Jills2Soda);

		Jacks1Soda.getAmount();
		Jacks2Soda.getAmount();
		Jills1Soda.getAmount();
		Jills1Soda.getAmount();

	}
}
