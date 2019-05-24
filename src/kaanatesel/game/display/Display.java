package kaanatesel.game.display;

import javax.swing.JFrame;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import kaanatesel.game.GameState;
import kaanatesel.game.entity.EntityState;
import kaanatesel.game.entity.GameEntity;
import kaanatesel.game.entity.ManagedGameEntity;

public class Display {

  private final Canvas canvas;
  private final JFrame frame;
  private GameState gameState;

  public Display(GameState gameState) {

    canvas = new Canvas();
    frame = new JFrame(gameState.getTitle());
    setGameState(gameState);

    canvas.setFocusable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setVisible(true);
    frame.add(canvas);
    frame.pack();

  }

  public Canvas getCanvas() {

    return canvas;
  }

  public GameState getGameState() {

    return gameState;
  }

  public JFrame getJFrame() {

    return frame;
  }

  public void render() {

    BufferStrategy bs = canvas.getBufferStrategy();
    if (bs == null) {
      canvas.createBufferStrategy(3);
      return;
    }
    Graphics graphics = bs.getDrawGraphics();
    // Clean
    graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

    // Draw here
    if (gameState != null) {
      renderGame(graphics);
    }

    // End drawing
    bs.show();
    graphics.dispose();
  }

  public void setGameState(GameState gameState) {

    setDisplaySize(gameState.getWidth(), gameState.getHeight());

    for (GameEntity gameEntity : gameState.getGameEntities()) {
      if (gameEntity instanceof ManagedGameEntity) {
        frame.addKeyListener(((ManagedGameEntity) gameEntity).getKeyListener());
      }
    }
    this.gameState = gameState;
  }

  private void renderGame(Graphics graphics) {

    for (GameEntity gameEntity : gameState.getGameEntities()) {
      EntityState s = gameEntity.getEntityState();
      graphics.drawImage(s.getImage(), (int) s.getX(), (int) s.getY(), s.getWidth(), s.getHeight(), null);
    }
  }

  private void setDisplaySize(int width, int height) {

    canvas.setPreferredSize(new Dimension(width, height));
    canvas.setMaximumSize(new Dimension(width, height));
    canvas.setMinimumSize(new Dimension(width, height));
    frame.setSize(width, height);
  }

}
