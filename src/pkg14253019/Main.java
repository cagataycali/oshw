package pkg14253019;

import java.awt.Point;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cagataycali
 */
public class Main {
    
    public static Random getCoordinate = new Random();
      
    public static void main(String[] args) {        
        Semaphore sem = new Semaphore(1);
        
        Plane plane = new Plane();
        Bird bird = new Bird(1);
        Bird bird2 = new Bird(2);
        
        Controller _plane = new Controller(sem, "plane", null, plane); 
        Controller _bird = new Controller(sem, "bird", bird, null);
        Controller __bird = new Controller(sem, "bird", bird2, null);

        _plane.start();
        _bird.start();
        __bird.start();

        try {
            _plane.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        try { 
            _bird.join();
            __bird.join();

        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
