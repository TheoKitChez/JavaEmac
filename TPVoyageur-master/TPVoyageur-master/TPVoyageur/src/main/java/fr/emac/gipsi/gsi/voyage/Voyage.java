/**
 *
 */
package fr.emac.gipsi.gsi.voyage;

import fr.emac.gipsi.gsi.voyageur.AbstractVoyageur;

import java.util.ArrayList;
import java.util.Arrays;
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
    
    
    /* ci dessous plusieurs méthodes que l'ont va utiliser dans lancement simuler*/
    
    
    /* On dresse la liste des planètes à visiter en regardant si elle possède un échantillon à prendre*/
   public ArrayList<Planete> PlaneteAV() {
    ArrayList<Planete> PlaneteAV = new ArrayList<Planete>();
    ArrayList<Planete> ListePlanete = getListPlanete(); 
    for (int i=0; (i<ListePlanete.size()); i++) {
    	if ((ListePlanete.get(i).getEchantillonRoche()!= null) || (ListePlanete.get(i).getEchantillonSol()!= null)) {
    		PlaneteAV.add(ListePlanete.get(i)); 
    	}
    }
    return PlaneteAV;
   }
   /*La méthode PlaneteAV revoie la liste des planètes à visiter*/
    
    /*on calcule tous les chemins possibles en fonction du nombre de planètes à visiter*/
   /*Pour comprendre comment ça marche prenons l'exemple des permutations de l'ensemble {1,2,3}*/
   /* le chiffre entre ** correspond à la position de l'indice*/
   /* A chaque fois on échange la position des élements situés aux positions indice et indice +1, en itérant ce système 
    * on obtient toutes les permutations possibles*/
   /* [*1*,2,3];[2,*1*,3];[*2*,3,1];[3,*2*,1];[*3*,1,2];[1,3,2] */
    public ArrayList<Planete> permutation( ArrayList<Planete> PlanetAV, int indice) {
    	 Planete a = PlanetAV.get(indice);
    	 Planete b = PlanetAV.get(indice+1); 
    	 PlanetAV.set(indice, b); 
    	 PlanetAV.set(indice+1, a);
    	 return PlanetAV;	    	
    }


    /* On crée la méthode qui permet de calculer la rotation otpimale de la tête pour prendre les photos*/
    /* on calcule le nb de rotations pour aller d'une direction à une autre*/
    public int nbrotation(String directionA, String directionB) {
    	int nb = 0;
    	if (((directionA== "N") && (directionB=="S")) || ((directionB=="N")&&(directionA=="S"))) {
    		nb = 2; 
    	}
    	if (((directionA=="N")&& (directionB=="O")) || ((directionB=="N") && (directionA=="O"))) {
    		nb = 1; 
    	}
    	if (((directionA=="N") && (directionB=="E"))|| ((directionB=="N") && (directionA=="E"))) {
    		nb = 1; 
    	}
    	if (((directionA== "E") && (directionB=="S")) || ((directionB=="E")&&(directionA=="S"))) {
    		nb = 1; 
    	}
    	if (((directionA== "E") && (directionB=="O")) || ((directionB=="E")&&(directionA=="O"))) {
    		nb = 2; 
    	}
    	if (((directionA== "S") && (directionB=="O")) || ((directionB=="S")&&(directionA=="O"))) {
    		nb = 1; 
    	}    	    		
    		return nb;  
    } 
    /* Renvoie l'indice du min d'un tableau*/
    
    public int indicemin(int [] liste) {
    	 int indicemin = 0;
    	 for (int i=0; (i<liste.length); i++ ) {
    		 if(liste[i]<liste[indicemin]) {
    			 indicemin=i; 
    		 }
    	 }
    	return indicemin; 
    } 
    
    
    /*Etant donné la position du robot et les photos qu'il doit prendre, cette méthode renvoie la direction 
     * où doit regarder le robot pour prendre la prochaine direction*/
    
    public String prochainedirection(String directionR, String [] directionsPP)  {
    	String prochainedirection;
    	int indicemin = 0; 
    	int [] Lnbrotation = new int [directionsPP.length];     
    	for (int i=0; (i<directionsPP.length); i++ ) {
    		Lnbrotation[i]=nbrotation(directionR,directionsPP[i]);     	/* On calcule le nombre de rotations pour aller de la 
    																	direction du robot à chacune des directions des planètes à photographier*/	
    	}
    	indicemin = indicemin(Lnbrotation);
    	prochainedirection= directionsPP[indicemin];
    	
    return 	prochainedirection; 
    } 
    
    /* On cherche les directions des planètes d'une liste par rapport au corps du robot*/
    public String [] PositionPlanete (ArrayList<Planete> ListePlanete) {
    String [] directionPP = new String [ListePlanete.size()]; /*Liste des position des planètes par rapport au robot*/
    for (int i=0 ; (i<ListePlanete.size()); i++  ) {
 	   int RX = getSimulatedvoyageur().getPosBody().getX(); 
 	   int RY= getSimulatedvoyageur().getPosBody().getY();
 	   int PiX= ListePlanete.get(i).getPos().getX(); 
 	   int PiY= ListePlanete.get(i).getPos().getY(); 
 	   
 	   if ((RX==PiX)&&(RY<PiY)) {
 		   directionPP[i]="E"; 
 	   }
 	   else if ((RX==PiX)&&(RY>PiY)) {
 		   directionPP[i]="O"; 
 	   }
 	   else if ((RY==PiY)&&(RX<PiX)) {
 		   directionPP[i]="N"; 
 	   }
 	   else if ((RY==PiY)&& (RX>PiX)) {
 		   directionPP[i]= "S"; 
 	   }
 	   }
    return directionPP; 
    }
    
    /*On crée la méthode qui permet au robot d'avancer */
    /*On met en entrée de la méthode la position de la prochaine planete que l'on veut visiter*/ 
    public void avancer(Position posPC) {
    	Position posr = getSimulatedvoyageur().getPosBody(); /*Position du robot*/
    	String directionR= getSimulatedvoyageur().getDirection(); /*Direction du robot*/
    	String directionP ; /*Direction de la planete*/
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
    	
    	
    } 
    
    /*on crée la méthode factorielle*/
    public int fact(int n) {
    	int result;
    	if(n==1)
    	return 1;
    	result = fact(n-1) * n;
    	return result;
    	}
    
    /**/
    public ArrayList<Planete> cheminopt(Planete a, Planete b) {
    	
    	
    	
    	return ; 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void lancementSimuler() { 
    	afficheEcran();
        // TODO Auto-generated method stub
    	/*On crée la matrice des distances entre chaque planète*/
    	int n = getListPlanete().size(); 
    	float[][] M_distance=new float[n][n];
        for(int i=0;i<n; i++) {
            for(int j=0;j<n;j++) {
                float x=getListPlanete().get(i).getPos().getX()-getListPlanete().get(j).getPos().getX();
                float y=getListPlanete().get(i).getPos().getY()-getListPlanete().get(j).getPos().getY();
                M_distance[i][j]= (float) Math.sqrt(x*x+y*y);
                
            }
        }
        /*On regarde les planètes sur lesquelles on doit aller*/
        ArrayList<Planete> PlaneteAV= PlaneteAV();
        /*pour chaque chemin donné on va regarder comment l'executer de façon optimale*/
        /*On fera le calcul pour toutes les permutations possibles de chemin comprenant les planètes à visiter*/
        /*On comparera les chemins grâce aux distances en supposant que le chemin avec la distance minimal induira une energie dépensée minimale aussi*/
        int nbrcas = fact(PlaneteAV.size());
        int indice=0;
        ArrayList<Planete> PermutationMin = PlaneteAV; /* c'est le chemin optimal, on l'initialise au chemin basique PlaneteAV*/
        float distancemin = Float.MAX_VALUE;
        float distanceparcourue; 
        for (int i=0; (i<nbrcas); i++ ) {
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	PlaneteAV= permutation(PlaneteAV,indice); 
        }
    	
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

        // On connait l'indice de la planète ou l'ont est
        // ensuite on doit recup les planetes accesibles depuis celle ou on est , et on creer
        //la liste avec les distances!
        //ensuite on cherche la distance minimale
    	
    	Planete Planete_acc = getListPlanete().get(indp);
    	ArrayList<Planete> Liste_acc = Planete_acc.getListAccessibilite(); 
    	float [] distance_acc = new float [Liste_acc.size()];
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

    	

            /* il faut prendre la liste des planètes visibles pour prendre en photo toutes les planètes*/
            /* indp est l'indice de la planète sur laquelle se trouve le robot*/
            /*Planete Planete_acc = getListPlanete().get(indp); (planète sur laquelle on est)*/
            /* On part du principe qu'on ne prend en photo la planète visible seulement si elle ne possède pas d'échantillon ,
             * car si elle possède un échantillon on prendra la photo lorsque l'on ira sur la planète*/
            /*On doit aussi vérifier qu'on ne possède pas déja la planète en photo*/
            
           ArrayList<Planete> Liste_PPhoto= new ArrayList<Planete>(); /* Liste des planètes prises en photo*/
           ArrayList<Planete> Liste_vis = Planete_acc.getListVisibilite(); /* planètes visibles d'où on est*/
           ArrayList<Planete> Liste_PP = new ArrayList<Planete>(); /* Liste des planètes à prendre en photo*/
           for (int i=0; (i<Liste_vis.size());i++ ) {
        	   for (int j=0; (i<Liste_acc.size()); j++) {
        		   for (int k=0; (k<Liste_PPhoto.size()); k++) {
        			   if ((Liste_vis.get(i).getPos()!= Liste_acc.get(j).getPos()) && (Liste_vis.get(i).getPos()!= Liste_PPhoto.get(k).getPos())) {
        				   Liste_PP.add(Liste_vis.get(i));        			   
        			   }
        		   }
        	   }	   
           }
           
           /*Ici List_PP a donc les positions des planètes que l'on doit prendre en photo*/
           /* On doit maintenant tourner la tête du robot pour qu'il puisse prendre en photo la planète*/
           /* On cherche les directions des planètes par rapport au corps du robot*/
           /*on a maintenant les directions de toutes les planètes par rapport au robot, il faut maintenant trouver le sens de la rotation optimale pour le robot*/
           /* On a trouvé la prochaine planète où on doit aller */
           
           
           String prochainedirection;
           Planete PlanetePhoto= new Planete();
           String[] directionPP = PositionPlanete(Liste_PP); /*renvoie la liste des directions des planètes à  prendre en photo*/ 
           String directionR= getSimulatedvoyageur().getDirection(); /*Direction du robot*/
           for (int i=0; (i < directionPP.length); i++ ) {
        	   prochainedirection=prochainedirection(directionR, directionPP);
        	   for (int j=0; (j<directionPP.length) ; j++) {
        		   if (prochainedirection==directionPP[j]) {
        			   PlanetePhoto=Liste_PP.get(i); /*on a le nom de la planète que l'on va photographier*/
        		   }
        		   		
        	   }
        	   
        	   if (((directionR=="N")&&(prochainedirection=="E")) || ((directionR=="O")&&(prochainedirection=="N")) || ((directionR=="S")&&(prochainedirection=="O")) || ((directionR=="E")&&(prochainedirection=="S")))    {
        		   getSimulatedvoyageur().turnRight();
        		   directionR=prochainedirection;
        		   getSimulatedvoyageur().takePicture(PlanetePhoto);
        		   Liste_PPhoto.add(PlanetePhoto); 
        	   }
        	   if (((directionR=="N")&&(prochainedirection=="O")) || ((directionR=="E")&&(prochainedirection=="N")) || ((directionR=="S")&&(prochainedirection=="E")) || ((directionR=="O")&&(prochainedirection=="S")))   {
        		   getSimulatedvoyageur().turnLeft();
        		   directionR=prochainedirection;
        		   getSimulatedvoyageur().takePicture(PlanetePhoto);
        		   Liste_PPhoto.add(PlanetePhoto); 
        	   }
        	   if (((directionR=="N")&&(prochainedirection=="S")) || ((directionR=="S")&&(prochainedirection=="N")) || ((directionR=="O")&&(prochainedirection=="E")) || ((directionR=="E")&&(prochainedirection=="O")))  {
        		   getSimulatedvoyageur().turnRight();
        		   getSimulatedvoyageur().turnRight();
        		   directionR=prochainedirection;
        		   getSimulatedvoyageur().takePicture(PlanetePhoto);
        		   Liste_PPhoto.add(PlanetePhoto); 
        	   }
        	  			   
           }
           

               
    		
    	afficheEcran();    	}	
    	
}










        
    

