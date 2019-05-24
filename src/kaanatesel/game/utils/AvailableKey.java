package kaanatesel.game.utils;

import java.awt.event.KeyEvent;

public enum AvailableKey {
  down(KeyEvent.VK_S),
  left(KeyEvent.VK_A),
  other(-1),
  right(KeyEvent.VK_D),
  up(KeyEvent.VK_W);

  public static final AvailableKey getKeyByValue(int value) {

    for (AvailableKey key : AvailableKey.values()) {
      if (key.getKeyEvent() == value) {
        return key;
      }
    }
    return AvailableKey.other;
  }

  private final int keyEvent;

  AvailableKey(int keyEvent) {

    this.keyEvent = keyEvent;
  }

  public int getKeyEvent() {

    return keyEvent;
  }

}
