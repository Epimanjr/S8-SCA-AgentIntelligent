
public class Action {

	public static final Action GAUCHE = new Action("gauche");
	public static final Action DROITE = new Action("droite");
	public static final Action DEVANT = new Action("devant");

	/**
	 * le nom de l'action
	 */
	String nomAction;

	/**
	 * constructeur avec action
	 * 
	 * @param string
	 */
	public Action(String string) {
		this.nomAction = string;
	}
	
	public String toString()
	{
		return(nomAction);
	}

}
