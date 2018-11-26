package pkg14253019;

import java.awt.Point;

public class Plane {

	public Integer life;

	public Point Coordinate = new Point();

	public Plane() {
		life = 2;
		Coordinate.x = 0;
		Coordinate.y = 0;
	}

	public void crash () {
		life--;
	}

	public boolean isAlive () {
		return life > 0;
	}

	public void move () {
		if (isAlive()) {
			Coordinate.setLocation(++Coordinate.x, ++Coordinate.y);
			System.out.println("Plane Coordinates  {x: " + Coordinate.x + ", y:" + Coordinate.y + "}");
		}
	}
}
