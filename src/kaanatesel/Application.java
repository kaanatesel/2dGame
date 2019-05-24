package kaanatesel;

import kaanatesel.game.GameState;
import kaanatesel.game.entity.Player;

public class Application {

  public static void main(String args[]) {

    /* Game Loading Starts */
    GameState gameState = new GameState();
    gameState.setTitle("The Game");
    gameState.setHeight(1000);
    gameState.setWidth(1000);
    Player player = new Player();
    gameState.addGameEntity(player);
    /* Game Loading Ends */

    Game game = new Game();
    game.setGameState(gameState);
    game.start();
  }

}
