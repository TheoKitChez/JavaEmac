/**
 * 
 */
package fr.emac.gipsi.gsi.animation;

import fr.emac.gipsi.gsi.screen.Screen;

/**
 * @author truptil
 *
 */
public class Animationligne extends AbstractAnimation{
 
    /**
     * 
     */
    public Animationligne() {
        
    }

    @Override
    public void runAnimation() {
        showScreen(ecranDeb);
        ecranInt=copyScreen(ecranDeb);
        for(int ligne=0;ligne<ecranInt.getLigMax()+1;ligne++) {
            System.out.println("startSend");
            this.showScreen(ecranInt);
            for(int col=0;col<ecranInt.getColMax()+1;col++) {
                ecranInt.updateColorByXY(ligne, col, ecranFin.getColorByXY(ligne,col));
            }
            this.wait(100);
            
        }
        this.showScreen(ecranInt);
        
    }

    

}