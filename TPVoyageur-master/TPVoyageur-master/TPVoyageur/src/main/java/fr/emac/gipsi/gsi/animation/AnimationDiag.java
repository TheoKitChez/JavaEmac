/**
 * 
 */
package fr.emac.gipsi.gsi.animation;

import fr.emac.gipsi.gsi.screen.Screen;

/**
 * @author truptil
 *
 */
public class AnimationDiag extends AbstractAnimation{
 
    /**
     * 
     */
    public AnimationDiag() {
        
    }

    @Override
    public void runAnimation() {
        showScreen(ecranDeb);
        ecranInt=copyScreen(ecranDeb);
        for(int k=0;k<26*2;k++) {
            System.out.println("startSend");
            this.showScreen(ecranInt);
            for(int j=0;j<=k;j++) {
                int i = k-j;
                        if (i<26 && j<26) {
                ecranInt.updateColorByXY(i, j, ecranFin.getColorByXY(i,j));
            }}
            this.wait(100);
            
        }
        this.showScreen(ecranInt);
        
    }

    

}
