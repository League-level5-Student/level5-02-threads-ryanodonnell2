package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	//1. make a main method
	public static void main(String[] args) {
		new AdvancedRobotRace().run();
	}
	
		Random r = new Random();
    	Thread[] threads = new Thread[5];
		Robot[] robots = new Robot[5];
	public void run() {
		  
		for (int i = 0; i < 5; i++) {
			robots[i] = new Robot();
			robots[i].setX(100);
			robots[i].moveTo((150*(i+1)), 500);
			robots[i].setSpeed(10);
			robots[i].show();
		}
		System.out.println(robots.length);
		System.out.println(robots);
    	for (int i = 0; i < threads.length; i++) {
    		Robot robot = robots[i];
			threads[i] = new Thread(()->{
				race(robot);
			});
			threads[i].start();
		}
	}
	
	public static int maxRobotY(Robot[] list) {
		int maxY = list[0].getY();
		for (Robot robot : list) {
			if(robot.getY()<maxY) {
				maxY = robot.getY();
			}
		}
		return maxY;
	}

	
	public void race(Robot raceRobot) {
		Robot robot = raceRobot;
		while(robot.getY()>100&&!Thread.currentThread().isInterrupted()) {
			robot.move(r.nextInt(5));
		}
		if(!Thread.currentThread().isInterrupted()) {
			end();
		}
	}
	
	public void end() {
    	for (Thread thread : threads) {
			thread.interrupt();
		}
    	Robot farthestRobot = robots[0];
    	for (Robot robot : robots) {
    		if(robot.getY()>farthestRobot.getY()) {
    			farthestRobot = robot;
    		}
		}
    	farthestRobot.moveTo(600, 400);
	}
}

