
public class Main {

	public static void main(String[] args) {
		// on cree le probleme
		ProblemeMainGauche pb = new ProblemeMainGauche();
		System.out.println(pb);

		// on cree un agent
		AgentMainGauche agt = new AgentMainGauche();

		// on cree etat de depart (en 0,0 oriente vers le nord)
		Etat s = new Etat(1, 1, Etat.NORD);

		// on effectue une boucle (perception action)
		for (int i = 0; i < 72; i++) {
			System.out.println("************************");
			System.out.println(i);
			System.out.println("\t - etat :" + s);
                        // Ajout de la case en mémoire (et l'état)
                        agt.memoireCases.add(new Case(s.x, s.y));
                        agt.etatActuel = s;
			// on regarde
			Observation o = pb.observer(s);
			System.out.println("\t - observation :" + o);
			// on decide
			Action a = agt.decider(o);
			System.out.println("\t - action :" + a);
			// on agit
			s = pb.transition(s, a);
			System.out.println("\t - etat :" + s);
			System.out.println(pb.toString(s));
		}
	}

}
