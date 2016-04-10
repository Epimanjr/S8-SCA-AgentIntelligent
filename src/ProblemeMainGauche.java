
public class ProblemeMainGauche {

	/**
	 * permet de savoir quelle case correpond à un mur
	 */
	boolean[][] murs;

	/**
	 * la taille du labyrinthe
	 */
	int taille;

	/**
	 * la sortie
	 */
	int sortieX, sortieY;

	/**
	 * construit un probleme par defaut
	 */
	public ProblemeMainGauche() {
		this.taille = 10;
		this.murs = new boolean[taille][taille];
		// cree arene
		for (int i = 0; i < taille; i++) {
			this.murs[0][i] = true;
			this.murs[taille - 1][i] = true;
			this.murs[i][taille - 1] = true;
			this.murs[i][0] = true;
		}

		// murs en plus
		for (int i = 0; i < 8; i++)
			murs[2][i] = true;
		for (int i = 6; i < 9; i++)
			murs[i][6] = true;
		for (int i = 4; i < 9; i++)
			murs[i][4] = true;
		for (int i = 4; i < 7; i++)
			murs[i][2] = true;
		murs[6][1] = true;
	}

	/**
	 * fait evoluer l'etat
	 * 
	 * @param e
	 *            etat precedent
	 * @param a
	 *            action faite
	 * @return nouvel etat
	 */
	public Etat transition(Etat e, Action a) {
		switch (a.nomAction) {
		case "gauche":
			return (this.tournerGauche(e));
		case "droite":
			return (this.tournerDroite(e));
		case "devant":
			return (this.avancer(e));
		}
		throw new Error("action non reconnue : " + a.nomAction);
	}

	/**
	 * methode qui permet d'avancer d'une case dans la direction choisie On est
	 * bloque si on avance contre un mur
	 * 
	 * @param e
	 *            ancien etat
	 * @return nouvel etat apres avancer.
	 */
	private Etat avancer(Etat e) {
		// copie etat d'arrivee
		Etat res = new Etat(e);

		// calcule position en fonction direction
		int[] position = Etat.calculerPositionDirection(res.x, res.y, res.direction);
		res.x = position[0];
		res.y = position[1];

		// si le nouvel etat est atteignable
		if (this.etreEtatAtteignable(res)) {
			// on retourne le nouvel etat
			return (res);
		} else {
			// sinon on ne bouge pas
			return (new Etat(e));
		}
	}

	/**
	 * permet de verifier si un etat est atteignable
	 * 
	 * @param etat
	 *            etat a tester
	 * @return true si l'etat est atteignable (pas de mur ni en dehors du
	 *         labyrinthe)
	 */
	private boolean etreEtatAtteignable(Etat etat) {
		int x = etat.x;
		int y = etat.y;
		// si on est hors du labyrinthe
		if (!etreDansLabyrinthe(x, y)) {
			return (false);
		}
		// retourne la presence de mur
		return (!this.murs[x][y]);
	}

	private boolean etreDansLabyrinthe(int x, int y) {
		return (x >= 0) && (x < taille) && (y >= 0) && (y < taille);
	}

	/**
	 * methode qui fait tourner la direction d'un cran vers la droite
	 * 
	 * @param e
	 *            etat de depart
	 * @return nouvel etat apres rotation droite
	 */
	private Etat tournerDroite(Etat e) {
		Etat res = new Etat(e);
		res.direction = Etat.calculerDirectionDroite(res.direction);
		return res;
	}

	/**
	 * methode qui fait tourner la direction d'un cran vers la gauche
	 * 
	 * @param e
	 *            etat de depart
	 * @return nouvel etat apres rotation gauche
	 */
	private Etat tournerGauche(Etat e) {
		Etat res = new Etat(e);
		res.direction = Etat.calculerDirectionGauche(res.direction);
		return res;
	}

	/**
	 * permet d'observer les murs autour de l'etat courant
	 * 
	 * @param s
	 *            etat a partir duquel on observe
	 */
	public Observation observer(Etat s) {
		Observation obs = new Observation();
		// on regarde les murs devant, gauche et droite
		obs.murDevant = murDirection(s.x, s.y, s.direction);
		obs.murGauche = murDirection(s.x, s.y, Etat.calculerDirectionGauche(s.direction));
		obs.murDroite = murDirection(s.x, s.y, Etat.calculerDirectionDroite(s.direction));
		return (obs);
	}

	/**
	 * permet de connaitre s'il y a un mur dans une direction
	 * 
	 * @param x
	 *            case de depart
	 * @param y
	 *            case de depart
	 * @param direction
	 *            regardee
	 * @return mur dans le direction correspondante
	 * 
	 */
	private boolean murDirection(int x, int y, int direction) {
		boolean murDirection;
		int[] caseDirection = Etat.calculerPositionDirection(x, y, direction);
		if (etreDansLabyrinthe(caseDirection[0], caseDirection[1]))
			murDirection = this.murs[caseDirection[0]][caseDirection[1]];
		else
			murDirection = true;
		return murDirection;
	}

	/**
	 * affiche le labyrinthe
	 */
	public String toString() {
		String r = "";
		for (int i = 0; i < this.taille; i++) {
			for (int j = 0; j < this.taille; j++) {
				if (this.murs[j][i])
					r += "X";
				else
					r += ".";
			}
			r += "\n";
		}
		return (r);

	}

	/**
	 * affiche le labyrinthe avec Etat
	 */
	public String toString(Etat s) {
		String r = "";
		for (int ligne = 0; ligne < this.taille; ligne++) {
			for (int col = 0; col < this.taille; col++) {
				if (this.murs[col][ligne])
					r += "X";
				else {
					if ((col == s.x) && (ligne == s.y))
						r += Etat.getCharDirection(s.direction);
					else
						r += ".";
				}

			}
			r += "\n";
		}
		return (r);

	}

}
