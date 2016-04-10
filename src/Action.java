
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

    public String toString() {
        return (nomAction);
    }
    
    public static Action getRandomAction() {
        int alea = (int)(Math.random() * 3);
        switch(alea) {
            case 0:
                return Action.GAUCHE;
            case 1:
                return Action.DROITE;
            case 2: 
                return Action.DEVANT;
            default: 
                System.err.println("Erreur: sélection incorrecte d'action");
                System.exit(0);
        }
        return null;
    }

}
