package kaanatesel.game.entity;

import java.awt.Image;

public class EntityState {

  private int height;
  private Image image;
  private float speed;
  private int width;
  private float x;
  private float y;

  public int getHeight() {

    return height;
  }

  public Image getImage() {

    return image;
  }

  public float getSpeed() {

    return speed;
  }

  public int getWidth() {

    return width;
  }

  public float getX() {

    return x;
  }

  public float getY() {

    return y;
  }

  public void setHeight(int height) {

    this.height = height;
  }

  public void setImage(Image image) {

    this.image = image;
  }

  public void setSpeed(float speed) {

    this.speed = speed;
  }

  public void setWidth(int width) {

    this.width = width;
  }

  public void setX(float x) {

    this.x = x;
  }

  public void setY(float y) {

    this.y = y;
  }

}
