/**
 *
 */
package fr.emac.gipsi.gsi.voyageur;

import fr.emac.gipsi.gsi.voyage.Position;

/**
 * @author Truptil Sebastien - sebastien.truptil@gmail.com
 *
 */
public class VoyageurSimuler extends AbstractVoyageur {
	
			
    /**
     *
     */
    public VoyageurSimuler() {
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#forward()
     */
    @Override
    protected void forward() {
    	
    	String direction = getDirection();
    	
    	if (direction == "N") {
    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX()-1);
    		nouvellePositionB.setX(getPosBody().getX()-1);
    		nouvellePositionT.setY(getPosTete().getY());
    		nouvellePositionB.setY(getPosBody().getY());
    		setPosBody(nouvellePositionB);
    		setPosTete(nouvellePositionT);
    		
    		setDirection("N");
    		
    	}
    	else if (direction == "S") {

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX()+1);
    		nouvellePositionB.setX(getPosBody().getX()+1);
    		nouvellePositionT.setY(getPosTete().getY());
    		nouvellePositionB.setY(getPosBody().getY());
    		setPosBody(nouvellePositionB);
    		setPosTete(nouvellePositionT);
    		
    		setDirection("S");
    		
    	}
    	else if (direction == "E") {

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX());
    		nouvellePositionB.setX(getPosBody().getX());
    		nouvellePositionT.setY(getPosTete().getY()+1);
    		nouvellePositionB.setY(getPosBody().getY()+1);
    		setPosBody(nouvellePositionB);
    		setPosTete(nouvellePositionT);
    	
   
    	}
    	else if (direction == "O") {

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX());
    		nouvellePositionB.setX(getPosBody().getX());
    		nouvellePositionT.setY(getPosTete().getY()-1);
    		nouvellePositionB.setY(getPosBody().getY()-1);
    		setPosBody(nouvellePositionB);
    		setPosTete(nouvellePositionT);
    	}
    	
        // TODO Auto-generated method stub
        

    }
    private Position Position(int i, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#backward()
     */
    @Override
    protected void backward() {
    	
    	String direction = getDirection();
    	
    	if (direction == "N") {
    		
    		

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX()+1);
    		nouvellePositionB.setX(getPosBody().getX()+1);
    		nouvellePositionT.setY(getPosTete().getY());
    		nouvellePositionB.setY(getPosBody().getY());
    		setPosBody(nouvellePositionB);
    		setPosTete(nouvellePositionT);
    		
    		setDirection("S");
    	}
    	else if (direction == "S") {
    		
    		

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX()-1);
    		nouvellePositionB.setX(getPosBody().getX()-1);
    		nouvellePositionT.setY(getPosTete().getY());
    		nouvellePositionB.setY(getPosBody().getY());
    		setPosBody(nouvellePositionB);
    		setPosTete(nouvellePositionT);
    		
    		setDirection("N");
    		
    	}
    	else if (direction == "E") {
    		

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX());
    		nouvellePositionB.setX(getPosBody().getX());
    		nouvellePositionT.setY(getPosTete().getY()-1);
    		nouvellePositionB.setY(getPosBody().getY()-1);
    		setPosBody(nouvellePositionB);
    		setPosTete(nouvellePositionT);
    		setDirection("O");
   
    	}
    	else if (direction == "O") {
    		

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX());
    		nouvellePositionB.setX(getPosBody().getX());
    		nouvellePositionT.setY(getPosTete().getY()+1);
    		nouvellePositionB.setY(getPosBody().getY()+1);
    		setPosBody(nouvellePositionB);
    		setPosTete(nouvellePositionT);
    		
    		setDirection("E");
    	}
        // TODO Auto-generated method stub
        ;

    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#left()
     */
    @Override
    protected void left() {
    	String direction = getDirection();
    	
    	if (direction == "N") {
    		
    		setPosTete(new Position(getPosTete().getX()+1,getPosTete().getY()-1));

    		

    		
    		
    		setDirection("O");
    	}
    	else if (direction == "S") {
    
    	
    		setPosTete(new Position(getPosTete().getX()-1,getPosTete().getY()+1));

    		
    		
    		setDirection("E");
    		
    	}
    	else if (direction == "E") {
    		setPosTete(new Position(getPosTete().getX()-1,getPosTete().getY()-1));

    		
    		
    		setDirection("N");
    	
   
    	}
    	else if (direction == "O") {
    		
    		setPosTete(new Position(getPosTete().getX()+1,getPosTete().getY()+1));

    		P
    		setDirection("S");
        // TODO Auto-generated method stub
        
    	

    }
    }
    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#right()
     */
    @Override
    
    protected void right() {
    	
    	String direction = getDirection();
    	
    	if (direction == "N") {
    		
    		setPosTete(new Position(getPosTete().getX()+1,getPosTete().getY()+1));

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		
    		setDirection("E");
    	}
    	else if (direction == "S") {
    
    		setPosTete(new Position(getPosTete().getX()-1,getPosTete().getY()-1));

    		
    		setDirection("O");
    	}
    	else if (direction == "E") {
    		
    		setPosTete(new Position(getPosTete().getX()+1,getPosTete().getY()-1));

    		
    		setDirection("S");
   
    	}
    	else if (direction == "O") {
    		
    		setPosTete(new Position(getPosTete().getX()-1,getPosTete().getY()+1));

    		
    	
        setDirection("N");
    	}

    }
        // TODO Auto-generated method stub*
    	
    	
    	

    }

