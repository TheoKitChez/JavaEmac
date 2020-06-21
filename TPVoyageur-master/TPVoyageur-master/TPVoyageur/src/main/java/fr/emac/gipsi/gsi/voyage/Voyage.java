/**
 *
 */
package fr.emac.gipsi.gsi.voyage;

import fr.emac.gipsi.gsi.animation.AbstractAnimation;
import fr.emac.gipsi.gsi.animation.AnimationBisligne;
import fr.emac.gipsi.gsi.animation.AnimationByColumn;
import fr.emac.gipsi.gsi.animation.AnimationDiag;
import fr.emac.gipsi.gsi.animation.AnimationFlash;
import fr.emac.gipsi.gsi.animation.AnimationRideau;
import fr.emac.gipsi.gsi.animation.Animationligne;
import fr.emac.gipsi.gsi.ecran.ListScreen;
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
    
    /*On cherche la planète sur laquelle se trouve le robot*/
    public Planete planeteActuL(Position posr) {
	/*Position posr = getSimulatedvoyageur().getPosBody();*/ 	/* position du robot et donc de la planète sur laquelle se trouve le robot*/
			/* position de la i ème planète de la liste*/ 
	int indp=0;  												
	for (int i = 0; (i<(getListPlanete().size())); i++) {
		Position posi = getListPlanete().get(i).getPos();	/* indice de la planète dans la liste de planètes*/
		if ((posr.getX()== posi.getX())  && (posr.getY()== posi.getY())) {
			indp = i;      			
		}
		
	}
	return getListPlanete().get(indp); 
    }
    /* On dresse la liste des planètes à visiter en regardant si elle possède un échantillon à prendre*/
   public ArrayList<Planete> PlaneteAV() {
    ArrayList<Planete> PlaneteAV = new ArrayList<Planete>();
    PlaneteAV.add(planeteActuL(getSimulatedvoyageur().getPosBody())); 
    ArrayList<Planete> ListePlanete = getListPlanete(); 
    for (int i=0; (i<ListePlanete.size()); i++) {
    	if (((ListePlanete.get(i).getEchantillonRoche()!= null) || (ListePlanete.get(i).getEchantillonSol()!= null)) && (ListePlanete.get(i)!= PlaneteAV.get(0))){
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
 	   else if ((RY==PiY)&&(RX>PiX)) {
 		   directionPP[i]="S"; 
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
    	if(n==1) {
    		return 1;
    	}
    	result = fact(n-1) * n;
    	return result;
    	}
    
   /*On crée la méthode qui renvoie l'indice dans la liste de planète d'une planète donnée*/ 
    public int indicePlanete(Planete a) {
    	Position posP=a.getPos(); 
    	int indicePlanete=0; 
    	for (int i=0; (i<getListPlanete().size()); i++){
    		if (posP==getListPlanete().get(i).getPos()) {
    			indicePlanete = i; 
    		}
    	}
    	return indicePlanete; 		
    }
    /*Cette méthode nous renvoie la distance entre 2 planètes*/
    
    public float distance(Planete a,Planete b) {

        int k=indicePlanete(a);
        int l=indicePlanete(b);
        float distance;
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

        distance= M_distance[k][l];

        return distance; 

    }
    
    /*On crée la methode qui permet de vérifier si 2 listes de planètes ont des planètes communes*/
    public ArrayList<Planete> Planetecommunes (ArrayList<Planete> a, ArrayList<Planete> b) {
    	ArrayList<Planete> Planetecommunes = new ArrayList<Planete>();    	
    	for (int i=0; (i<a.size()); i++) {
    		for ( int j=0; (j<b.size()); j++) {
    			if (a.get(i)==b.get(j)) {
    				Planetecommunes.add(b.get(j)); 
    			}
    		}
    	}
    	return Planetecommunes; 
    }

    /**/
    public ArrayList<Planete> cheminopt(Planete a, Planete b, ArrayList<Planete> Visitee) {
    	
    	ArrayList<Planete> cheminopt =new  ArrayList<Planete>();
    
    	cheminopt.add(a);
    	
    	float distancemin= Float.MAX_VALUE;
    	float distanceparcourue = 0;
    	float dist_total = 0;
    	Planete alternative = b; 
    	 if (a.getListAccessibilite().contains(b)) {
             distancemin=distance(a,b);
             dist_total=dist_total+ distancemin;
             cheminopt.add(b); 
             }
    	 else if (Planetecommunes(Planetecommunes(a.getListAccessibilite(),b.getListAccessibilite()), Visitee).size() == 0) {
    		 cheminopt.remove(a); 
    	 } 
    	 else { 
    		 for(int i=0;i<Visitee.size(); i++){

             if ((Visitee.get(i).getListAccessibilite().contains(b)) && (a.getListAccessibilite().contains(Visitee.get(i)))){
            	 distanceparcourue=distance(Visitee.get(i),b) + distance(a,Visitee.get(i));
                 if (distanceparcourue< distancemin) {
                     distancemin=distanceparcourue; 
                     alternative = Visitee.get(i);  
     
             }
             }
    		 }
    		 cheminopt.add(alternative); 
    		 cheminopt.add(b); 
    	 }
    	return cheminopt; 
    		
    		 
    }
    
   public float distancetotale(ArrayList<Planete> cheminopt) {
	   float distancetotale=0; 
	   for (int i=0; (i<(cheminopt.size()-1)); i++) {
		   distancetotale+=distance(cheminopt.get(i), cheminopt.get(i+1)); 
	   }
	   if (cheminopt.size()==0) {
		   distancetotale=Float.MAX_VALUE; 
	   }
	   return distancetotale; 
	   
   }
    
    
    
    

    @Override
    public void lancementSimuler() { 
    	afficheEcran();
    	wait(1500); 
        // TODO Auto-generated method stub
    	 
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
         
        ArrayList<Planete> Liste_PPhoto= new ArrayList<Planete>(); /* Liste des planètes prises en photo*/
        /*pour chaque chemin donné on va regarder comment l'executer de façon optimale*/
        /*On fera le calcul pour toutes les permutations possibles de chemin comprenant les planètes à visiter*/
        /*On comparera les chemins grâce aux distances en supposant que le chemin avec la distance minimal induira une energie dépensée minimale aussi*/
        int nbrcas = fact(PlaneteAV.size()-1);
        int indice=1;
        ArrayList<Planete> Dejavu= new ArrayList<Planete>();
        int test = 0; 
       
        float distancemin = Float.MAX_VALUE;
        float distanceparcourue=0;
        ArrayList<Planete> Visitee=new ArrayList<Planete>(); 
        ArrayList<Planete> cheminfinal= new ArrayList<Planete>(); /* c'est le chemin optimal*/
        ArrayList<Planete> trajeteff = new ArrayList<Planete>(); 
        for (int i=0; (i<nbrcas); i++ ) {
        	
        	Visitee.add(PlaneteAV.get(0)); 
        	for (int j= 0; (j<(PlaneteAV.size()-1)); j++) {
        		distanceparcourue+=distancetotale(cheminopt(PlaneteAV.get(j), PlaneteAV.get(j+1),Visitee));
        		Visitee.add(PlaneteAV.get(j+1)); 
        		trajeteff.addAll(cheminopt(PlaneteAV.get(j), PlaneteAV.get(j+1), Visitee)); 
        	}
        	
        	if (distanceparcourue<distancemin) {
        		cheminfinal.clear(); 
        		distancemin=distanceparcourue;
        		cheminfinal.addAll(trajeteff); 
        		
        	}
        	distanceparcourue=0; 
        	trajeteff.clear();
        	Visitee.clear();
        	if (indice<PlaneteAV.size()-2) {
        		indice=indice+1; 
        		}
        	else {
        		indice=1; 
        	}

        	PlaneteAV= permutation(PlaneteAV,indice); 
        }
        for (int w=0; (w<cheminfinal.size()) ; w++) {
        	if (Dejavu.contains(planeteActuL(getSimulatedvoyageur().getPosBody()))) {
        		test = 1; 
        	}
        	else {
        		test=0; 
        	}
        	if (test==0){
        		getSimulatedvoyageur().takePicture(planeteActuL(getSimulatedvoyageur().getPosBody()));
            	Liste_PPhoto.add(planeteActuL(getSimulatedvoyageur().getPosBody()));
            	

            	Dejavu.add(planeteActuL(getSimulatedvoyageur().getPosBody())); 
            	getSimulatedvoyageur().takeEchantillonSol(planeteActuL(getSimulatedvoyageur().getPosBody()));
            	
            	getSimulatedvoyageur().takeEchantillonRoche(planeteActuL(getSimulatedvoyageur().getPosBody()));
        	}
        	
        	/* il faut prendre la liste des planètes visibles pour prendre en photo toutes les planètes*/
            
            
            /* On part du principe qu'on ne prend en photo la planète visible seulement si elle ne possède pas d'échantillon ,
             * car si elle possède un échantillon on prendra la photo lorsque l'on ira sur la planète*/
            /*On doit aussi vérifier qu'on ne possède pas déja la planète en photo*/
            
           int test2=0; 
           ArrayList<Planete> Liste_vis = planeteActuL(getSimulatedvoyageur().getPosBody()).getListVisibilite(); /* planètes visibles d'où on est*/
           ArrayList<Planete> Liste_PP = new ArrayList<Planete>(); /* Liste des planètes à prendre en photo*/
           for (int z=0; (z<Liste_vis.size());z++ ) {
        	   for (int j=0; (j<planeteActuL(getSimulatedvoyageur().getPosBody()).getListAccessibilite().size()); j++) {
        		   for (int k=0; (k<Liste_PPhoto.size()); k++) {
        			   if ((Liste_vis.get(z).getPos()!= planeteActuL(getSimulatedvoyageur().getPosBody()).getListAccessibilite().get(j).getPos()) && (Liste_vis.get(z).getPos()!= Liste_PPhoto.get(k).getPos())) {
        				   if (Liste_PP.contains(Liste_vis.get(z))){
        					   test2=1;}
        				   else {
        					   test2=0;}
        				   if (test2==0) {
        					   Liste_PP.add(Liste_vis.get(z));
        				   }
        				  
        				    
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
           //
          
           //
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
           
	

        if (w<cheminfinal.size()-1) {  
        	avancer(cheminfinal.get(w+1).getPos()); }
        /*on affiche le trajet du robot*/
        afficheEcran(); 	
       	wait(1500); 
       	
        
        }

   /*On affiche dans l'ordre où on a pris en photo les planètes au cours de notre
    * voyage, l'image de chaque planète ainsi que les échantillons de sol puis de roche si il y'a.*/     
for (int i=0; (i<Liste_PPhoto.size()) ; i++)   	{
	AbstractAnimation aa = new AnimationBisligne();
		aa.setEcranDeb(ListScreen.space()); 
		aa.setEcranFin(Liste_PPhoto.get(i).getImage());	
		aa.runAnimation();
		if (Liste_PPhoto.get(i).getEchantillonSol()!=null) {
			AbstractAnimation bb = new AnimationDiag();
			bb.setEcranDeb(ListScreen.space());
			
			bb.setEcranFin(Liste_PPhoto.get(i).getEchantillonSol());	
			bb.runAnimation();
		}
		if (Liste_PPhoto.get(i).getEchantillonRoche()!=null) {
			AbstractAnimation cc = new AnimationByColumn();
			cc.setEcranDeb(ListScreen.space());
			
			cc.setEcranFin(Liste_PPhoto.get(i).getEchantillonRoche());	
			cc.runAnimation();
		}
		
			
	
}	

}
}











        
    

