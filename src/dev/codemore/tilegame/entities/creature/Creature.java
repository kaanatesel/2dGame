package dev.codemore.tilegame.entities.creature;

import dev.codemore.tilegame.entities.Entity;

public abstract class Creature extends Entity{

	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_WIDTH = 64,
							DEFAULT_HEIGHT = 64;
	
	protected int health;
	protected float speed;
	protected float xMove;
	protected float yMove;
	
	
	public Creature(float x, float y, int width, int height) {
		super(x, y,height,width);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
	}

	protected void move() {
		x += xMove;
		y += yMove;
	}
	
	//Getters and Setters
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	
}
