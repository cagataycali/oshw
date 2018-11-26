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
        Semaphore sem = new Semaphore(2);
        
        Bird[] bird = new Bird[1];
        
        Controller[] controller = new Controller[1];
        
        for (int i = 0; i < 1; i++) {
            bird[i] = new Bird(i);
        }
        Plane plane = new Plane();
        
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 1; i++) {
                controller[i] = new Controller(sem, "bird", bird[i], null);
                controller[i].start();
                try { 
                 controller[i].join();
                } catch (InterruptedException ex) {
                  Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
             
             Controller _plane = new Controller(sem, "plane", null, plane); 
             _plane.start();

             try {
                 _plane.join();
             } catch (InterruptedException ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
    }
}
