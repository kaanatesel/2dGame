package kaanatesel;

import kaanatesel.game.GameState;
import kaanatesel.game.display.Display;
import kaanatesel.game.entity.GameEntity;
import kaanatesel.game.entity.Movable;

public class Game implements Runnable {

  private GameState gameState;
  private boolean running = false;
  private Thread thread;

  @Override
  public void run() {

    Display display = new Display(gameState);

    int fps = 60;
    double timePerTick = 1000000000 / fps;
    double delta = 0;
    long now;
    long lastTime = System.nanoTime();
    long timer = 0;
    int ticks = 0;

    while (running) {
      now = System.nanoTime();
      delta += (now - lastTime) / timePerTick;
      timer += now - lastTime;
      lastTime = now;

      if (delta >= 1) {
        refreshGameState();
        display.render();
        ticks++;
        delta--;
      }

      if (timer >= 1000000000) {
        System.out.println("Tick and Frames: " + ticks);
        ticks = 0;
        timer = 0;
      }

    }
  }

  public synchronized void setGameState(GameState gameState) {

    this.gameState = gameState;
  }

  public synchronized void start() {

    if (running) {
      return;
    }
    running = true;
    thread = new Thread(this);
    thread.start();

  }

  private void refreshGameState() {

    for (GameEntity gameEntity : gameState.getGameEntities()) {
      if (gameEntity instanceof Movable) {
        ((Movable) gameEntity).move();
      }
    }
  }

}
