package kaanatesel.game;

import java.util.ArrayList;
import java.util.List;

import kaanatesel.game.entity.GameEntity;

public class GameState {

  private final List<GameEntity> gameEntities = new ArrayList<>();
  private int height;
  private String title;
  private int width;

  public void addGameEntity(GameEntity gameEntity) {

    gameEntities.add(gameEntity);
  }

  public List<GameEntity> getGameEntities() {

    return gameEntities;
  }

  public int getHeight() {

    return height;
  }

  public String getTitle() {

    return title;
  }

  public int getWidth() {

    return width;
  }

  public void setHeight(int height) {

    this.height = height;
  }

  public void setTitle(String title) {

    this.title = title;
  }

  public void setWidth(int width) {

    this.width = width;
  }

}
