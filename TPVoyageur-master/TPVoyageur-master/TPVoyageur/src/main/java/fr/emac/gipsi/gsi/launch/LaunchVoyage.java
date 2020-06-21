/**
 * 
 */
package fr.emac.gipsi.gsi.launch;

import java.util.ArrayList;

import fr.emac.gipsi.gsi.ecran.ListScreen;
import fr.emac.gipsi.gsi.voyage.Planete;
import fr.emac.gipsi.gsi.voyage.Voyage;
import fr.emac.gipsi.gsi.voyageur.AbstractVoyageur;
import fr.emac.gipsi.gsi.voyageur.VoyageurSimuler;

/**
 * @author Truptil Sebastien - sebastien.truptil@gmail.com
 *
 */
public class LaunchVoyage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<Planete> listPlanete = new ArrayList<>();
		
		Planete p1 = new Planete();
		p1.setColorName("DarkSalmon");
		p1.setImage(ListScreen.bat());
		p1.setEchantillonRoche(ListScreen.PowerStone());
		p1.setEchantillonSol(ListScreen.batlogo());
		p1.setRayon(0);
		p1.getPos().setX(1);
		p1.getPos().setY(1);
		 
		
		
		Planete p2 = new Planete();
		p2.setColorName("DeepPink");
		p2.setImage(ListScreen.Captain());
		p2.setEchantillonRoche(ListScreen.RealityStone());
		p2.setEchantillonSol(ListScreen.captlogo());
		p2.setRayon(0);
		p2.getPos().setX(2);
		p2.getPos().setY(2);
		
		
		
		Planete p3= new Planete();
		p3.setColorName("Green");
		p3.setImage(ListScreen.Hulk());
		p3.setEchantillonSol(ListScreen.batlogo());
		p3.setRayon(0);
		p3.getPos().setX(1);
		p3.getPos().setY(5);
		

		
		Planete p4= new Planete();
		p4.setColorName("Red");
		p4.setImage(ListScreen.ww());
		p4.setEchantillonRoche(ListScreen.SpaceStone());
		p4.setEchantillonSol(ListScreen.wwlogo());
		p4.setRayon(0);
		p4.getPos().setX(6);
		p4.getPos().setY(5);
		
	

		Planete p5= new Planete();
		p5.setColorName("Yellow");
		p5.setImage(ListScreen.IronMan());
		p5.setRayon(0);
		p5.getPos().setX(3);
		p5.getPos().setY(1);
		
		p1.getListAccessibilite().add(p3); 
		p1.getListAccessibilite().add(p2); 
		
		p2.getListAccessibilite().add(p1);
		p2.getListAccessibilite().add(p4);
		p2.getListAccessibilite().add(p3);
		
		p3.getListAccessibilite().add(p1);
		p3.getListAccessibilite().add(p2);
		
		
		p4.getListAccessibilite().add(p2);
		
		
		p5.getListVisibilite().add(p4); 
		p5.getListVisibilite().add(p2); 
		p5.getListVisibilite().add(p1);
		
		p1.getListVisibilite().add(p5);
		p2.getListVisibilite().add(p5);
		p4.getListVisibilite().add(p5);
		
		
		
		listPlanete.add(p1);
		listPlanete.add(p2);
		listPlanete.add(p3);
		listPlanete.add(p4);
		listPlanete.add(p5);
		
		AbstractVoyageur simulatedVoyageur = new VoyageurSimuler();
		
		simulatedVoyageur.getPosTete().setX(listPlanete.get(0).getPos().getX());
		simulatedVoyageur.getPosTete().setY(listPlanete.get(0).getPos().getY()+1);
		simulatedVoyageur.getPosBody().setX(listPlanete.get(0).getPos().getX());
		simulatedVoyageur.getPosBody().setY(listPlanete.get(0).getPos().getY());
		simulatedVoyageur.setDirection("E");
		
		Voyage voyage = new Voyage(listPlanete, simulatedVoyageur);

		voyage.lancementSimuler();
	}

}














