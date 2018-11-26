package pkg14253019;

import java.awt.Point;
import java.util.Random;

public class Bird {
    public int id;
    public int life;
    public Random getCoordinate;
    public Point Coordinate;
    
    public Bird (int id) {
        this.id = id;
        life = 1;
        getCoordinate = new Random();
        Coordinate = new Point(getCoordinate.nextInt(11), getCoordinate.nextInt(11));
    }
    
    public void kill () {
        --this.life;
        System.out.println("Bird " + this.id + " is dead.");
    }
	public boolean isAlive () {
		return life >0;
	}
    public void move () {
		if(isAlive()){
        Coordinate.x += (getCoordinate.nextInt(5) - 2);
        Coordinate.y += (getCoordinate.nextInt(5) - 2);
        Coordinate.x = Coordinate.x < 0 ? 0 : Coordinate.x%10;
        Coordinate.y = Coordinate.y < 0 ? 0 : Coordinate.y%10;
        System.out.println(this.id+".Bird Coordinates {x " + Coordinate.x + ", y: " + Coordinate.y + "}");
    }
	}
}
