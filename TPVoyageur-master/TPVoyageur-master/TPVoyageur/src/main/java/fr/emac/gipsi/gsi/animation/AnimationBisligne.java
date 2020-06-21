/**
 * 
 */
package fr.emac.gipsi.gsi.animation;

import fr.emac.gipsi.gsi.screen.Screen;

/**
 * @author truptil
 *
 */
public class AnimationBisligne extends AbstractAnimation {
 
    /**
     * 
     */
    public AnimationBisligne() {

    }

    @Override
    public void runAnimation() {
        showScreen(ecranDeb);
        ecranInt=copyScreen(ecranDeb);
        for(int ligne=0;ligne<ecranInt.getLigMax()+1;ligne++) {
            System.out.println("startSend");
            this.showScreen(ecranInt);
            for(int col=0;col<ecranInt.getColMax()+1;col++) {
                if (ligne%2!=0) {
                    ecranInt.updateColorByXY(26-ligne, col, ecranFin.getColorByXY(26-ligne,col));}
                else {ecranInt.updateColorByXY(ligne, col, ecranFin.getColorByXY(ligne,col));} 
            }
            this.wait(100);

        }
        this.showScreen(ecranInt);

    }



}
