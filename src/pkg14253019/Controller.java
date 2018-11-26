package pkg14253019;

import java.util.concurrent.*;
/**
 *
 * @author cagataycali
 */
public class Controller extends Thread {
    Semaphore semaphore;
    String threadType;
    Bird b;
    Plane p;
    
    Controller (Semaphore semaphore, String threadType, Bird b, Plane p) {
        super(threadType);
        this.semaphore = semaphore;
        this.threadType = threadType; // bird or plane
        this.b = b;
        this.p = p;
    }
    
    @Override
    public void run () {
        for (int i = 0; i < 10; i++) {
                if (this.getName().equals("bird")) {
                System.out.println("bird came");
                try {
                    semaphore.acquire();
                    System.out.println("acquired " + this.threadType);
                    System.out.println("5 sn uyu sonra müsade et");
                    b.move();
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                semaphore.release();
            } else if (this.getName().equals("plane")) {
                System.out.println("plane came");
                try {
                    semaphore.acquire();
                    System.out.println("acquired " + this.threadType);
                    System.out.println("5 sn uyu sonra müsade et");
                    p.move();
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                semaphore.release();
            }
        }
    }
}
