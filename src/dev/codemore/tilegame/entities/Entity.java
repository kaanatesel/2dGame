package dev.codemore.tilegame.entities;

import java.awt.Graphics;

public abstract class Entity {
	
	 protected float x;
	 protected float y;
	 protected int width;
	 protected int heigth;
	 
	 public  Entity(float x, float y,int heigth, int width) {
		this.x = x;
		this.y = y;
		this.heigth = heigth;
		this.width = width;
	}
	 
	 public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public abstract void tick();
	 
	 public abstract void render(Graphics g);
}
