
public class AgentMainGauche implements Agent {

    @Override
    public Action decider(Observation o) {
        if (o.murDevant) {
            // Devant et à droite
            if (o.murDroite) {
                if(o.murGauche) {
                    return Action.getRandomAction();
                }
                return Action.GAUCHE;
            } else {
                return Action.DROITE;
            }

        } else {
            // Pas de mur devant
            if(o.murGauche) {
                return Action.DEVANT;
            } else {
                // Pas de mur à gauche non plus
                if(o.murDroite) {
                    return Action.GAUCHE;
                } else {
                    return Action.getRandomAction();
                }
            }
        }
    }

}
