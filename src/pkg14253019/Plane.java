package pkg14253019;

import java.awt.Point;

/**
 * Shared resource Plane.
 * @author cagataycali
 */
public class Plane {
    
    public Integer life;
    public Integer x;
    public Integer y;
    public final Point Coordinate;
    
    public Plane () {
        life = 2;
        x = 0;
        y = 0;
        Coordinate = new Point(x, y);
    }
        
    public void move () {
        Coordinate.setLocation(++x, ++y);
        System.out.println("x " + x + " y " + y);
    }
}
