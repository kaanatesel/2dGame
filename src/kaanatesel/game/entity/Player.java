package kaanatesel.game.entity;

import kaanatesel.game.AssetsFactory;
import kaanatesel.game.MoveBehaviour;
import kaanatesel.game.utils.AvailableKey;
import kaanatesel.game.utils.GameKeyListener;

public class Player implements ManagedGameEntity, Movable {

  private final EntityState entityState;
  private final GameKeyListener keyListener;
  private final MoveBehaviour moveBehaviour;

  public Player() {

    AssetsFactory assetsFactory = new AssetsFactory();

    entityState = new EntityState();
    entityState.setHeight(50);
    entityState.setWidth(50);
    entityState.setX(100);
    entityState.setY(100);
    entityState.setSpeed(0.3f);
    entityState.setImage(assetsFactory.getPlayer());

    moveBehaviour = new MoveBehaviour(entityState);
    keyListener = new GameKeyListener();

  }

  @Override
  public EntityState getEntityState() {

    return entityState;
  }

  @Override
  public GameKeyListener getKeyListener() {

    return keyListener;
  }

  @Override
  public void move() {

    if (keyListener.getPressedKeys().contains(AvailableKey.up)) {
      moveBehaviour.moveUp();
    }
    if (keyListener.getPressedKeys().contains(AvailableKey.down)) {
      moveBehaviour.moveDown();
    }
    if (keyListener.getPressedKeys().contains(AvailableKey.left)) {
      moveBehaviour.moveLeft();
    }
    if (keyListener.getPressedKeys().contains(AvailableKey.right)) {
      moveBehaviour.moveRight();;
    }

  }

}
