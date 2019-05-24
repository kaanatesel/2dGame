package kaanatesel.game;

import kaanatesel.game.entity.EntityState;

public class MoveBehaviour {

  private final EntityState entityState;

  public MoveBehaviour(EntityState entityState) {

    this.entityState = entityState;
  }

  public void moveDown() {

    entityState.setY(entityState.getY() + entityState.getSpeed());
  }

  public void moveLeft() {

    entityState.setX(entityState.getX() - entityState.getSpeed());
  }

  public void moveRight() {

    entityState.setX(entityState.getX() + entityState.getSpeed());
  }

  public void moveUp() {

    entityState.setY(entityState.getY() - entityState.getSpeed());
  }

}
