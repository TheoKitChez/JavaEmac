/**
 *
 */
package fr.emac.gipsi.gsi.voyage;

import fr.emac.gipsi.gsi.voyageur.AbstractVoyageur;

import java.util.ArrayList;
import java.util.Collections;

import org.omg.CORBA.SystemException;

/**
 * @author Truptil Sebastien - sebastien.truptil@gmail.com
 *
 */
public class Voyage extends AbstractVoyage {

    /**
     * @param listPlanete
     * @param simulatedVoyageur
     */
    public Voyage(ArrayList<Planete> listPlanete, AbstractVoyageur simulatedVoyageur) {
        super(listPlanete, simulatedVoyageur);
        // TODO Auto-generated constructor stub
        
        }
        

    /**
     * @param listPlanete
     * @param simulatedVoyageur
     * @param realVoyager
     */
    public Voyage(ArrayList<Planete> listPlanete, AbstractVoyageur simulatedVoyageur, AbstractVoyageur realVoyager) {
        super(listPlanete, simulatedVoyageur, realVoyager);
        
               
        
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#showFromPlanete(fr.emac.gipsi.gsi.voyage.Planete)
     */
    @Override
    public int showFromPlanete(Planete p) {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#showAll()
     */
    @Override
    public int showAll() {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#pilotage()
     */
    @Override
    public void lancement() {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#pilotageSimuler()
     */
    @Override
    public void lancementSimuler() {
        // TODO Auto-generated method stub
    	/*On cherche d'abord la distance la plus courte entre le corps du robots et les planètes  */
    	Position a = getSimulatedvoyageur().getPosBody();
    	float distance [] = new float[3];
    	float min = Float.MAX_VALUE;
    	int indp = 0;
    	for (int i = 0; (i<(distance.length)) ; i++ ) {
    		
    		Position dp = getListPlanete().get(i).getPos();
    		distance[i]= (float) Math.sqrt(Math.pow((a.getX()-dp.getX()), 2)+Math.pow((a.getY()-dp.getY()), 2));
    		if (distance[i] < min) {
                    min = distance[i];
    				indp=i;   				
            }
    	Position posPlaneteCible = getListPlanete().get(indp).getPos();
    	
    	while (a.getY()> posPlaneteCible.getY()) {
    		getSimulatedvoyageur().
    	}
    	}
      
    		
    	}

        //afficheEcran();
        
        /*getSimulatedvoyageur().goForward();
        getSimulatedvoyageur().turnRight();
        getSimulatedvoyageur().goForward();
        getSimulatedvoyageur().turnLeft();
        getSimulatedvoyageur().goForward();
        getSimulatedvoyageur().turnRight(); 
       afficheEcran();*/
    }

