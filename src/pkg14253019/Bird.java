package pkg14253019;

import java.awt.Point;
import java.util.Random;

/**
 *
 * @author cagataycali
 */
public class Bird extends Thread {
    public Integer id;
    public Integer life;
    public Integer x;
    public Integer y;
    public Random getCoordinate;
    public final Point Coordinate;
    
    public Bird(Integer id) {
        this.id = id;
        life = 1;
        getCoordinate = new Random();
        x = getCoordinate.nextInt(10);
        y = getCoordinate.nextInt(10);
        Coordinate = new Point(x, y);
    }
    
    public void die () {
        --this.life;
        System.out.println("Die." + this.id);
    }
    
    public void move () {
        this.x += (getCoordinate.nextInt(5) - 2);
        this.y += (getCoordinate.nextInt(5) - 2);
        this.x = this.x % 9;
        this.y = this.y % 9;
        Coordinate.setLocation(x, y);
        System.out.println("x " + x +" y " + y);
    }
    
    @Override
    public void run() {
        int i = 0;
        while(life > 0 && i != 9){
            move();
            i++;
        }
    }
    
}
