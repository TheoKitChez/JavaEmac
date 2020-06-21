/**
 * 
 */
package fr.emac.gipsi.gsi.animation;

import fr.emac.gipsi.gsi.screen.Screen;

/**
 * @author truptil
 *
 */
public class AnimationRideau extends AbstractAnimation{
 
    /**
     * 
     */
    public AnimationRideau() {
        
    }

    @Override
    public void runAnimation() {
        showScreen(ecranDeb);
        ecranInt=copyScreen(ecranDeb);
        for(int colonne = 0 ; colonne<14 ;colonne++) {
            System.out.println("Tadaaaaam");
            this.showScreen(ecranInt);
            for(int ligne=0;ligne<ecranInt.getLigMax()+1;ligne++) {
                ecranInt.updateColorByXY(ligne, colonne, ecranFin.getColorByXY(ligne,colonne));
                
                ecranInt.updateColorByXY(ligne, colonne+13, ecranFin.getColorByXY(ligne,colonne+13));}
            this.wait(400);
        
            
        }
        this.showScreen(ecranInt);
        
    }

    

} 