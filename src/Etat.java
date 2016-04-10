
public class Etat {

	public final static int NORD = 0;
	public final static int EST = 1;
	public final static int SUD = 2;
	public final static int OUEST = 3;

	/**
	 * position de l'agent
	 */
	int x, y;

	/**
	 * direction (cf constantes)
	 */
	int direction;

	/**
	 * constructeur par copie
	 * 
	 * @param e
	 *            etat a partir duquel faire la copie
	 */
	public Etat(Etat e) {
		this.x = e.x;
		this.y = e.y;
		this.direction = e.direction;
	}

	/**
	 * constructeur simple
	 * 
	 * @param i
	 *            x de l'etat
	 * @param j
	 *            y etat
	 * @param direc
	 *            direction etat
	 */
	public Etat(int i, int j, int direc) {
		this.x = i;
		this.y = j;
		this.direction = direc;
	}

	/**
	 * methode affichage console
	 */
	public String toString() {
		return ("(" + this.x + "," + this.y + ") -> " + getCharDirection(this.direction));
	}

	public static String getCharDirection(int direction2) {
		switch (direction2) {
		case NORD:
			return ("N");
		case SUD:
			return ("S");
		case EST:
			return ("E");
		case OUEST:
			return ("O");
		}
		throw new Error("erreur direction inconnue" + direction2);

	}

	/**
	 * permet de calculer la direction quand on tourne à droite
	 * 
	 * @param ancienneDirection
	 *            direction avant rotation
	 * @return direction apres rotation
	 */
	public static int calculerDirectionDroite(int ancienneDirection) {
		// on decale la direction de 1 (cf constantes)
		int nouvelleDirection = ancienneDirection + 1;
		if (nouvelleDirection > 3)
			nouvelleDirection = nouvelleDirection - 4;
		return nouvelleDirection;
	}

	/**
	 * permet de calculer la direction quand on tourne à gauche
	 * 
	 * @param ancienneDirection
	 *            direction avant rotation
	 * @return direction apres rotation
	 */
	public static int calculerDirectionGauche(int ancienneDirection) {
		// on decale la direction de 1 (cf constantes)
		int nouvelleDirection = ancienneDirection - 1;
		if (nouvelleDirection < 0)
			nouvelleDirection = nouvelleDirection + 4;
		return nouvelleDirection;
	}

	/**
	 * calcule la case suivante en fonction d'une direction et d'une position
	 * 
	 * @param x
	 *            x de la case
	 * @param y
	 *            y de la case
	 * @param direction
	 *            direction du deplacement
	 * @return position apres deplacement
	 */
	public static int[] calculerPositionDirection(int x, int y, int direction) {
		// integre etat possible en fonction direction
		switch (direction) {
		case Etat.NORD:
			y--;
			break;
		case Etat.SUD:
			y++;
			break;
		case Etat.EST:
			x++;
			break;
		case Etat.OUEST:
			x--;
			break;
		}
		int[] resultat = { x, y };
		return (resultat);
	}

	/**
	 * retourne la position suivante a partir d'un etat
	 * 
	 * @param s
	 *            etat (position + direction)
	 * @return position si on avance
	 */
	public static int[] calculerPositionDirection(Etat s) {
		return calculerPositionDirection(s.x, s.y, s.direction);
	}

}
