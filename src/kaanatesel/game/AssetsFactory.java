package kaanatesel.game;

import java.awt.image.BufferedImage;

import kaanatesel.game.display.ImageLoader;
import kaanatesel.game.display.SpriteSheet;

public class AssetsFactory {

  private BufferedImage dust;
  private final int height;
  private BufferedImage player;
  private BufferedImage rock;
  private final SpriteSheet sheet;
  private BufferedImage tree;
  private BufferedImage water;
  private final int width;

  public AssetsFactory() {

    this(50, 50);
  }

  protected AssetsFactory(int width, int height) {

    this.width = width;
    this.height = height;
    sheet = new SpriteSheet(ImageLoader.loadImage("/images/Assets.png"));

  }

  public BufferedImage getDust() {

    if (dust == null) {
      dust = sheet.crop(width * 2, 0, width, height);
    }
    return dust;
  }

  public BufferedImage getPlayer() {

    if (player == null) {
      player = sheet.crop(0, 0, width, height);
    }
    return player;
  }

  public BufferedImage getRock() {

    if (rock == null) {
      rock = sheet.crop(0, height, width, height);
    }
    return rock;
  }

  public BufferedImage getTree() {

    if (tree == null) {
      tree = sheet.crop(width * 3, 0, width, height);
    }
    return tree;
  }

  public BufferedImage getWater() {

    if (water == null) {
      water = sheet.crop(width, 0, width, height);
    }
    return water;
  }

}
