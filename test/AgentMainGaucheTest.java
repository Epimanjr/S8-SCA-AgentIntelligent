/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maxime
 */
public class AgentMainGaucheTest {
    
    public AgentMainGaucheTest() {
    }

    @Test
    public void testActionWithoutMemory() throws Exception {
        AgentMainGauche amg = new AgentMainGauche();
        // Devant = false, Gauche = false, Droite = true
        assertEquals(amg.decider(new Observation(false, false, true)), Action.GAUCHE);
        // Devant = false, Gauche = true, Droite = false
        assertEquals(amg.decider(new Observation(false, true, false)), Action.DEVANT);
        // Devant = false, Gauche = true, Droite = true
        assertEquals(amg.decider(new Observation(false, true, true)), Action.DEVANT);
        // Devant = true, Gauche = false, Droite = false
        assertEquals(amg.decider(new Observation(true, false, false)), Action.DROITE);
        // Devant = true, Gauche = false, Droite = true
        assertEquals(amg.decider(new Observation(true, false, true)), Action.GAUCHE);
        // Devant = true, Gauche = true, Droite = false 
        assertEquals(amg.decider(new Observation(true, true, false)), Action.DROITE);
    }
    
}
