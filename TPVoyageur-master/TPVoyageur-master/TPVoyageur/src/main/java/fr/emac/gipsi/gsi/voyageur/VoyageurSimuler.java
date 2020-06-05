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
    		
    	}
    	else if (direction == "S") {
    		setPosTete(Position(getPosTete().getX()-2,getPosTete().getY()));

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX()-1);
    		nouvellePositionB.setX(getPosBody().getX()-1);
    		nouvellePositionT.setY(getPosTete().getY());
    		nouvellePositionB.setY(getPosBody().getY());
    		
    	}
    	else if (direction == "E") {
    		setPosTete(Position(getPosTete().getX()-1,getPosTete().getY()-1));

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX()-1);
    		nouvellePositionB.setX(getPosBody().getX()-1);
    		nouvellePositionT.setY(getPosTete().getY());
    		nouvellePositionB.setY(getPosBody().getY());
    	
   
    	}
    	else if (direction == "O") {
    		setPosTete(Position(getPosTete().getX()-1,getPosTete().getY()+1));

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX()-1);
    		nouvellePositionB.setX(getPosBody().getX()-1);
    		nouvellePositionT.setY(getPosTete().getY());
    		nouvellePositionB.setY(getPosBody().getY());
    	}
    	
        // TODO Auto-generated method stub
        setDirection("N");

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
    		
    		setPosTete(Position(getPosTete().getX()+2,getPosTete().getY()));

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX()+1);
    		nouvellePositionB.setX(getPosBody().getX()+1);
    		nouvellePositionT.setY(getPosTete().getY());
    		nouvellePositionB.setY(getPosBody().getY());
    	}
    	else if (direction == "S") {

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX()+1);
    		nouvellePositionB.setX(getPosBody().getX()+1);
    		nouvellePositionT.setY(getPosTete().getY());
    		nouvellePositionB.setY(getPosBody().getY());
    		
    	}
    	else if (direction == "E") {
    		setPosTete(Position(getPosTete().getX()+1,getPosTete().getY()-1));

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX()+1);
    		nouvellePositionB.setX(getPosBody().getX()+1);
    		nouvellePositionT.setY(getPosTete().getY());
    		nouvellePositionB.setY(getPosBody().getY());
    	
   
    	}
    	else if (direction == "O") {
    		setPosTete(Position(getPosTete().getX()+1,getPosTete().getY()+1));

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX()+1);
    		nouvellePositionB.setX(getPosBody().getX()+1);
    		nouvellePositionT.setY(getPosTete().getY());
    		nouvellePositionB.setY(getPosBody().getY());
    	}
        // TODO Auto-generated method stub
        setDirection("S");

    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#left()
     */
    @Override
    protected void left() {
    	String direction = getDirection();
    	
    	if (direction == "N") {
    		
    		setPosTete(Position(getPosTete().getX()+1,getPosTete().getY()-1));

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX());
    		nouvellePositionB.setX(getPosBody().getX());
    		nouvellePositionT.setY(getPosTete().getY()-1);
    		nouvellePositionB.setY(getPosBody().getY()-1);
    	}
    	else if (direction == "S") {
    
    	
    		setPosTete(Position(getPosTete().getX()-1,getPosTete().getY()-1));

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX());
    		nouvellePositionB.setX(getPosBody().getX());
    		nouvellePositionT.setY(getPosTete().getY()-1);
    		nouvellePositionB.setY(getPosBody().getY()-1);
    		
    	}
    	else if (direction == "E") {
    		setPosTete(Position(getPosTete().getX(),getPosTete().getY()-2));

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX());
    		nouvellePositionB.setX(getPosBody().getX());
    		nouvellePositionT.setY(getPosTete().getY()-1);
    		nouvellePositionB.setY(getPosBody().getY()-1);
    	
   
    	}
    	else if (direction == "O") {

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX());
    		nouvellePositionB.setX(getPosBody().getX());
    		nouvellePositionT.setY(getPosTete().getY()-1);
    		nouvellePositionB.setY(getPosBody().getY()-1);
        // TODO Auto-generated method stub
        
    	setDirection("O");

    }
    }
    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#right()
     */
    @Override
    
    protected void right() {
    	
    	String direction = getDirection();
    	
    	if (direction == "N") {
    		
    		setPosTete(Position(getPosTete().getX()+1,getPosTete().getY()+1));

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX());
    		nouvellePositionB.setX(getPosBody().getX());
    		nouvellePositionT.setY(getPosTete().getY()+1);
    		nouvellePositionB.setY(getPosBody().getY()+1);
    	}
    	else if (direction == "S") {
    
    	
    		setPosTete(Position(getPosTete().getX()-1,getPosTete().getY()+1));

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX());
    		nouvellePositionB.setX(getPosBody().getX());
    		nouvellePositionT.setY(getPosTete().getY()+1);
    		nouvellePositionB.setY(getPosBody().getY()+1);
    		
    	}
    	else if (direction == "E") {

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX());
    		nouvellePositionB.setX(getPosBody().getX());
    		nouvellePositionT.setY(getPosTete().getY()+1);
    		nouvellePositionB.setY(getPosBody().getY()+1);
    	
   
    	}
    	else if (direction == "O") {
    		
    	}
    		setPosTete(Position(getPosTete().getX(),getPosTete().getY()+2));

    		Position nouvellePositionT = new Position();
    		Position nouvellePositionB = new Position();

    		nouvellePositionT.setX(getPosTete().getX());
    		nouvellePositionB.setX(getPosBody().getX());
    		nouvellePositionT.setY(getPosTete().getY()-1);
    		nouvellePositionB.setY(getPosBody().getY()-1);
    	
        setDirection("E");

    }
        // TODO Auto-generated method stub*
    	
    	
    	

    }

