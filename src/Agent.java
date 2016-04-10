/*
on doit acceder aux observations des états anterieurs [EA] (pas acces à etat courant[EC) -> on se sert d'un etat interne
Eat Interne (EI) :concentre l'histo des perception. Actualisation de EI = evol de l'environnement + actions de agent modifient monde
donc EC = EA + observation actuelle.

pouf faire une action on doit :
- actualiser l'EI -> nous donne l'EC
- on applique on règle quidépend de l'etat actuell et de notre observation actuelle -> si je suis dans
tel situation,que puis-je faire (ReGLE CONDITION ACTON
- on faitl'action qui découle de la règle

*/
public interface Agent {

	public abstract Action decider(Observation o);
	
}
