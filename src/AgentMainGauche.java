
import java.util.ArrayList;

public class AgentMainGauche implements Agent {

    /**
     * Contient toutes les cases déjà visités.
     */
    ArrayList<Case> memoireCases = new ArrayList<>();

    Etat etatActuel = null;

    @Override
    public Action decider(Observation o) {
        /* PAS DE MUR DEVANT */
        if (!o.murDevant && !o.murDroite && !o.murGauche) {
            // Si à gauche déjà visité, je vais devant
            int[] tab = Etat.calculerPositionDirection(etatActuel.x, etatActuel.y, directionGauche());
            if (caseDejaVisitee(tab)) {
                return Action.DEVANT;
            }
        }
        if (!o.murDevant && !o.murDroite && o.murGauche) {
            // Il continue son chemin
            return Action.DEVANT;
        }
        if (!o.murDevant && o.murDroite && !o.murGauche) {
            // Il ne va pas à gauche s'il a déjà visité la case
            int[] tab = Etat.calculerPositionDirection(etatActuel.x, etatActuel.y, directionGauche());
            if (caseDejaVisitee(tab)) {
                return Action.DEVANT;
            }
        }
        if (!o.murDevant && o.murDroite && o.murGauche) {
            return Action.DEVANT;
        }
        /* MUR DEVANT */
        if (o.murDevant && !o.murDroite && !o.murGauche) {
            int[] tab = Etat.calculerPositionDirection(etatActuel.x, etatActuel.y, directionDroite());
            // Gauche si case droite déjà visitée, sinon droite
            return (caseDejaVisitee(tab)) ? Action.GAUCHE : Action.DROITE;
        }
        if (o.murDevant && !o.murDroite && o.murGauche) {
            return Action.DROITE;
        }
        if (o.murDevant && o.murDroite && !o.murGauche) {
            //
        }
        if (o.murDevant && o.murDroite && o.murGauche) {
            // Mur partout
        }
        // Par défaut, l'agent main gauche va à gauche
        return Action.GAUCHE;
    }

    private int directionDroite() {
        int direction = etatActuel.direction + 1;
        if (direction > 3) {
            return 0;
        } else {
            return direction;
        }
    }

    private int directionGauche() {
        int direction = etatActuel.direction - 1;
        if (direction < 0) {
            return 3;
        } else {
            return direction;
        }
    }

    private boolean caseDejaVisitee(int[] caseATester) {
        return this.memoireCases.contains(new Case(caseATester[0], caseATester[1]));
    }

}
