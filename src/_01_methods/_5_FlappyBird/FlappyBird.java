package _01_methods._5_FlappyBird;

import processing.core.PApplet;
import processing.core.PImage;

public class FlappyBird extends PApplet {
	static final int WIDTH = 800;
	static final int HEIGHT = 600;
	int x = 50;
	int y = 0;
	int birdYVelocity = -10; 
	int gravity = 1;
	int PipeX= 800;
	int pipeGap = 200;
	int upperPipeHeight = (int) random(100,400);
	int score = 0;
	
	PImage back;
	PImage pipeBottom;
	PImage pipeTop;
	PImage bird;


	boolean gameEnded = false;

	@Override
	public void settings() {
		size(WIDTH, HEIGHT);
	}

	@Override
	public void setup() {
		back = loadImage("flappyBackground.jpg");
		back.resize(WIDTH, HEIGHT);
		pipeBottom = loadImage("bottomPipe.png");
		pipeBottom.resize(150, HEIGHT-upperPipeHeight-pipeGap);
		pipeTop = loadImage("topPipe.png");
		pipeTop.resize(150,  upperPipeHeight);
		bird = loadImage("bird.png");
		bird.resize(50, 50);
		
		teleportPipes();
	}

	@Override
	public void draw() {
		if(gameEnded==false) {
		background(back);
		y+=birdYVelocity;
		birdYVelocity+=gravity;
		PipeX-=10;
		fill (255,0,0);
		stroke(255,0,0);
		image(bird, x,y);
		fill(0,255,0);
		image(pipeTop, PipeX,0);
		image(pipeBottom, PipeX, upperPipeHeight+pipeGap);
		teleportPipes();
		text("Score; " +score, 100, 50);
		if(intersectsPipes()) {
			gameEnded = true;
		}
		if(y>599) {
			gameEnded = true;
		}
		}
		else {
			background(0,0,0);
		text("Game Over, your score was " +score, 400, 300);
		}
	}

	public void mousePressed() {
		birdYVelocity=-10;
	}

	public void teleportPipes() {
		if (PipeX<0-150) {
			PipeX=800;
			upperPipeHeight = (int) random(100,400);
score+=100;
pipeBottom.resize(150, HEIGHT-upperPipeHeight-pipeGap);
pipeTop.resize(150,  upperPipeHeight);
		}
	}

	boolean intersectsPipes() {
		if (y < upperPipeHeight && x > PipeX && x < (PipeX+150)) {
			return true; }
		else if (y > upperPipeHeight+pipeGap && x > PipeX && x < (PipeX+150)) {
			return true;}
		else { return false; }
	}


	static public void main(String[] args) {
		PApplet.main(FlappyBird.class.getName());
	}
}


