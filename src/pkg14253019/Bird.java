package pkg14253019;

import java.awt.Point;
import java.util.Random;

/**
 * Shared resource Bird.
 * @author cagataycali
 */
public class Bird {
    public int id;
    public int life;
    public Random getCoordinate = null;
    public Point Coordinate = new Point();
    
    public Bird(int id) {
        this.id = id;
        life = 1;
        getCoordinate = new Random();
        Coordinate = new Point(getCoordinate.nextInt(11), getCoordinate.nextInt(11));
    }
    
    public void die () {
        --this.life;
        System.out.println("Die." + this.id);
    }
    
    public void move () {
        Coordinate.x += (getCoordinate.nextInt(5) - 2);
        Coordinate.y += (getCoordinate.nextInt(5) - 2);
        Coordinate.x = Coordinate.x < 0 ? 0 : Coordinate.x;
        Coordinate.y = Coordinate.y < 0 ? 0 : Coordinate.y;
        System.out.println("x " + Coordinate.x + " y " + Coordinate.y + " id " + this.id);
    }    
}
