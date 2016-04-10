
public class Observation {

	/**
	 * les boolean observes. L'agent voit uniquement les murs
	 * <li>- qui se trouve juste devant
	 * <li>- qui se trouve juste a sa gauche
	 * <li>- qui se trouve juste a sa doite
	 * 
	 */
	boolean murDevant;
	boolean murGauche;
	boolean murDroite;

	public String toString() {
		String r = "D: " + murDevant;
		r += " G: " + murGauche;
		r += " D: " + murDroite;
		return (r);
	}
}
