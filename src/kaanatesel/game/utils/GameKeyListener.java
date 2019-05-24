package kaanatesel.game.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

public class GameKeyListener implements KeyListener {

  private final java.util.Set<AvailableKey> pressedKeys = new HashSet<>();

  public GameKeyListener() {

  }

  public java.util.Set<AvailableKey> getPressedKeys() {

    return pressedKeys;
  }

  @Override
  public void keyPressed(KeyEvent e) {

    pressedKeys.add(AvailableKey.getKeyByValue(e.getKeyCode()));
  }

  @Override
  public void keyReleased(KeyEvent e) {

    pressedKeys.remove(AvailableKey.getKeyByValue(e.getKeyCode()));
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }
}
