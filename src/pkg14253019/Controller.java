package pkg14253019;

import java.util.concurrent.*;

public class Controller extends Thread {

	Semaphore semaphore;
	String threadType;
	Bird b;
	Plane p;
	Bird[] birds;

	Controller(Semaphore semaphore, String threadType, Bird b, Plane p, Bird[] birds) {
		super(threadType);
		this.semaphore = semaphore;
		this.threadType = threadType; // bird or plane
		this.b = b;
		this.p = p;
		this.birds = birds;
	}

	@Override
	public void run() {
		if (this.getName().equals("bird")) {
			//System.out.println("bird came");
			try {
				semaphore.acquire();
				//System.out.println("acquired " + this.threadType);
				//System.out.println("5 sn uyu sonra müsade et");
				b.move();
				Thread.sleep(10);

			} catch (InterruptedException e) {
				System.out.println(e);
			}
			semaphore.release();
		} else if (this.getName().equals("plane")) {
			//System.out.println("plane came");
			try {
				semaphore.acquire();
				//System.out.println("acquired " + this.threadType);
				//System.out.println("5 sn uyu sonra müsade et");
				p.move();
				for (Bird b : birds) {
					if (b.Coordinate.equals(p.Coordinate)) {
						p.crash();
						b.kill();
						System.out.println("Plane And Bird {" + b.id + "} Crashed");
					}
				}
				if (!p.isAlive()) {
					System.out.println("Plane Crashed.");
					System.exit(0);
				}
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			semaphore.release();
		}
	}
}
