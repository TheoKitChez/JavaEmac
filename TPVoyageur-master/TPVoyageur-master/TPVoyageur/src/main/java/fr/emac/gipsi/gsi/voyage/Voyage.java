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
    	afficheEcran();
        // TODO Auto-generated method stub
    	/*On cherche la planète sur laquelle se trouve le robot*/
    	Position posr = getSimulatedvoyageur().getPosBody(); 	/* position du robot et donc de la planète sur laquelle se trouve le robot*/
    			/* position de la i ème planète de la liste*/ 
    	int indp=0;  												
    	for (int i = 0; (i<(getListPlanete().size())); i++) {
    		Position posi = getListPlanete().get(i).getPos();	/* indice de la planète dans la liste de planètes*/
    		if ((posr.getX()== posi.getX())  && (posr.getY()== posi.getY())) {
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
    	int ind_PC=0; 
    	for (int i = 0; (i<(distance_acc.length)) ; i++ ) {
    		Position dp = Liste_acc.get(i).getPos(); 
    		distance_acc[i]= (float) Math.sqrt(Math.pow((posr.getX()-dp.getX()), 2)+Math.pow((posr.getY()-dp.getY()), 2));
    		if (distance_acc[i] < min) {
                    min = distance_acc[i];
    				ind_PC=i;   				
            }
    	
    	}

    	
    	/* Il faut définir la direction de la planète par rapport au robot.*/
    	
    	Position posPC = Liste_acc.get(ind_PC).getPos(); /* position de la planète où on veut aller*/
    	String directionP ;
    	String directionR= getSimulatedvoyageur().getDirection();
    	int RX = posr.getX(); 
    	int RY = posr.getY();
    	int PCX= posPC.getX();
    	int PCY = posPC.getY();

    	/* Cas où la planète cible se situe en diagonale du robot*/
    	
    	if ((RX !=PCX) && (RY != PCY)) {
    		if ((directionR == "E")|| (directionR== "O")) {
    			while (((directionR=="E")&&(RY>PCY)) || ((directionR == "O") &&(RY<PCY))) {
    				getSimulatedvoyageur().goBackward();
    				RY = getSimulatedvoyageur().getPosBody().getY();
    			}
    			while (((directionR == "E") && (RY<PCY)) || ((directionR == "O") && (RY>PCY))) {
    				getSimulatedvoyageur().goForward();
    				RY = getSimulatedvoyageur().getPosBody().getY();
    		}
    		}
    		if ((directionR == "N")||(directionR =="S")) {
    			while (((directionR=="N")&&(RX<PCX)) || ((directionR =="S") && (RX>PCX))) {
    				getSimulatedvoyageur().goBackward();
    				RX = getSimulatedvoyageur().getPosBody().getX();  
    			}
    			while (((directionR == "N")&& (RX>PCX))|| ((directionR== "S")&& (RX <PCX))) {
    				getSimulatedvoyageur().goForward();
    				RX = getSimulatedvoyageur().getPosBody().getX(); 
    			}
    		}
    		}
    	
    	/* 1er cas la planète se situe à l'Est du robot*/
    	if ((RX==PCX) && (RY < PCY)) { 
    		directionP = "E";
    		if (directionP==directionR) { 
    			while (RY< PCY) {
    				getSimulatedvoyageur().goForward();
    				RY = getSimulatedvoyageur().getPosBody().getY();
    			}
    		}
    		else if (directionR=="N") {
    			getSimulatedvoyageur().turnRight();
    			while (RY< PCY) {
    				getSimulatedvoyageur().goForward();
    				RY = getSimulatedvoyageur().getPosBody().getY();
    			}
    		}
    		else if (directionR == "O") {
    			while (RY< PCY) {
    				getSimulatedvoyageur().goBackward();
    				RY = getSimulatedvoyageur().getPosBody().getY();
    				}
    		}
    		else if (directionR == "S") {
    			getSimulatedvoyageur().turnLeft();
    			while (RY< PCY) {
    				getSimulatedvoyageur().goForward();
    				RY = getSimulatedvoyageur().getPosBody().getY(); 
    			}
    		}
    			
    			
    		}
    	/*2 ème cas, la planète est à l'Ouest du voyageur*/
    	if ((RX==PCX) && (RY > PCY)) { 
           directionP = "O";
            if (directionP==directionR) { 
            	while (RY>PCY) {
            		getSimulatedvoyageur().goForward();
            		RY = getSimulatedvoyageur().getPosBody().getY(); 
                }
            }
            else if (directionR=="N") {
            	getSimulatedvoyageur().turnLeft();
                while (RY>PCY) {
                	getSimulatedvoyageur().goForward();
                	RY = getSimulatedvoyageur().getPosBody().getY();
                }
            }
            else if (directionR == "E") {
                
            	while (RY>PCY) {
            		getSimulatedvoyageur().goBackward();
            		RY = getSimulatedvoyageur().getPosBody().getY();
            	}
            }
            else if (directionR == "S") {
            	getSimulatedvoyageur().turnRight();
            	while (RY>PCY) {
            		getSimulatedvoyageur().goForward();
            		RY = getSimulatedvoyageur().getPosBody().getY();
            	}
            }
    	}
                
    	/* Cas robot et planète aligné selon Y, et robot en dessous de la planète ( au Nord)  */
        if ((RX>PCX) && (RY == PCY)) { 
            directionP = "N";
            if (directionP==directionR) { 
            	while (RX> PCX) {
            		getSimulatedvoyageur().goForward();
            		RX = getSimulatedvoyageur().getPosBody().getX(); 
                    }
                }
            else if (directionR=="E") {
                getSimulatedvoyageur().turnLeft();
                while (RX> PCX) {
                    getSimulatedvoyageur().goForward();
                    RX = getSimulatedvoyageur().getPosBody().getX();  
                }
                }
            else if (directionR == "O") {
                getSimulatedvoyageur().turnRight();
                while (RX> PCX) {
                    getSimulatedvoyageur().goForward();
                    RX = getSimulatedvoyageur().getPosBody().getX();      
                }
            }
            else if (directionR == "S") {
                while (RX> PCX) {
                    getSimulatedvoyageur().goBackward();
                    RX = getSimulatedvoyageur().getPosBody().getX();  
                } 


                }    
            }
        /* Cas robot et planète aligné selon Y, et robot au dessus de la planète (au nord de la planète) */
        if ((RX<PCX) && (RY == PCY)) {
            directionP = "S";
            if (directionP==directionR) { 
                while (RX<PCX) {
                	getSimulatedvoyageur().goForward();
                	RX = getSimulatedvoyageur().getPosBody().getX();     
                }
                }   
            else if (directionR=="E") {
                getSimulatedvoyageur().turnRight();
                while (RX < PCX) {
                    getSimulatedvoyageur().goForward();
                    RX = getSimulatedvoyageur().getPosBody().getX();  
                    }
                }
            else if (directionR == "O") {
                getSimulatedvoyageur().turnLeft();
                while (RX < PCX) {
                    getSimulatedvoyageur().goForward();
                    RX = getSimulatedvoyageur().getPosBody().getX();  
                        }
                }
            else if (directionR == "N") {
                while (RX<PCX) {
                    getSimulatedvoyageur().goBackward();
                    RX = getSimulatedvoyageur().getPosBody().getX();  }
                }
                    
                    
                }
    		
    	afficheEcran();    	}	
    	
}

        
    

