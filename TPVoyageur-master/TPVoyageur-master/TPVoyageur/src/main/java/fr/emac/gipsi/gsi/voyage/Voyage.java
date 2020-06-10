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
    	/*On cherche la planète sur laquelle se trouve le robot*/
    	Position posr = getSimulatedvoyageur().getPosBody(); 	/* position du robot et donc de la planète sur laquelle se trouve le robot*/
    	Position posi = getListPlanete().get(i).getPos();			/* position de la i ème planète de la liste*/ 
    	int indp;  												/* indice de la planète dans la liste de planètes*/
    	for (int i = 0; (i<(getListPlanete().size())); i++) {
    		if ((posr.getX()== posi.get(X))  && (posr.getY()== posi.getY())) {
    			indp = i;      			
    		}
    		
    	}
    	//On cherche la distance minimale parmis les planètes accessibles

        // indice de la planète ou on est: indp

        // On connait l'indice de la planète ou l'ont est ( kintana fait ca)
        // ensuite on doit recup les planetes accesibles depuis celle ou on est , et on creer
        //la liste avec les distances!
        //ensuite on cherche la distance minimale
    	
    	Planete Planete_acc = getListPlanete().get(indp);
    	ArrayList<Planete> Liste_acc = Planete_acc.getListAccessibilite(); 
    	float distance_acc [] = new float [Liste_acc.size()];
    	float min = Float.MAX_VALUE;
    	int ind_PC; 
    	for (int i = 0; (i<(distance_acc.length)) ; i++ ) {
    		Position dp = Liste_acc.get(i).getPos(); 
    		distance_acc[i]= (float) Math.sqrt(Math.pow((posr.getX()-dp.getX()), 2)+Math.pow((posr.getY()-dp.getY()), 2));
    		if (distance_acc[i] < min) {
                    min = distance_acc[i];
    				ind_PC=i;   				
            }
    	
    	}

    	
    	
    	
    	
    	
    	
    	/* Il faut définir la direction de la planète par rapport au robot.*/
    	
    	Position posPC = getListPlanete().get(ind_PC).getPos(); /* position de la planète où on veut aller*/
    	String directionp ; 
    	if ((posr.getX()== posPC.getX()) && (posr.getY()== posPC.getY())) { 
    		
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

