package pkg14253019;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static Random getCoordinate = new Random();

	public static void main(String[] args) {
		int birdCount = 50;
		Semaphore sem = new Semaphore(birdCount + 1);
		Bird[] bird = new Bird[birdCount];
		boolean flag = true;
		Controller[] controller = new Controller[birdCount];
		for (int i = 0; i < birdCount; i++) {
			bird[i] = new Bird(i);
		}
		Plane plane = new Plane();
		for (int j = 0; j < 10; j++) {

			for (int i = 0; i < birdCount; i++) {
				controller[i] = new Controller(sem, "bird", bird[i], null, null);
				controller[i].start();
				try {
					controller[i].join();
				} catch (InterruptedException ex) {
					Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
				}
			}

			Controller _plane = new Controller(sem, "plane", null, plane, bird);
			_plane.start();

			try {
				_plane.join();
			} catch (InterruptedException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
			
			System.out.println("---------------------------");
		}

	}
}
