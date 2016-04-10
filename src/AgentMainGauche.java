
public class AgentMainGauche implements Agent {

    @Override
    public Action decider(Observation o) {
        if(o.murDevant) {
            // Si un mur à droite, on va à gauche, sinon on va à droite
            return (o.murDroite) ? Action.GAUCHE : Action.DROITE;
        } else {
            /*
             Pour rémuser, on va tout le temps devant, 
             Sauf si un mur à droite et pas à gauche
            */
            return (!o.murGauche && o.murDroite) ? Action.GAUCHE: Action.DEVANT;
        }
    }

}
