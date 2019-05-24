package kaanatesel.game.entity;

import java.awt.event.KeyListener;

public interface ManagedGameEntity extends GameEntity {

  KeyListener getKeyListener();

}
