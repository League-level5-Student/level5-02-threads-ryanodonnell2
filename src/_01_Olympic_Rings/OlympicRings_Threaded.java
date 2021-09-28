package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		new OlympicRings_Threaded().start();
	}
	
	void start() {
		Robot blue = new Robot(200, 200);
		Robot yellow = new Robot(350, 300);
		Robot black = new Robot(500, 200);
		Robot green = new Robot(650, 300);
		Robot red = new Robot(800, 200);
		Robot r[] = {blue, yellow, black, green, red};
		Color colors[] = {Color.blue, Color.yellow, Color.black, Color.green, Color.red};
		Thread circles[] = new Thread [5];
		for (int i = 0; i < r.length; i++) {
			final int circleNum = i;
			circles[i] = new Thread(()->{
				drawCircle(r[circleNum], colors[circleNum]);
			});
			circles[i].start();
		}
	}
	
	void drawCircle(Robot r, Color c) {
		r.setSpeed(10);
		r.setPenColor(c);
		r.penDown();
		r.setPenWidth(10);
		for (int i = 0; i < 360; i++) {
			r.move(2);
			r.turn(1);
		}
		r.penUp();
		r.hide();
	}
}

