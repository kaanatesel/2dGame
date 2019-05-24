package dev.codemore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	public static int width = 50, height = 50;
	public static BufferedImage player, water, tree, dust, rock;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/images/Assets.png"));
		player = sheet.crop(0, 0, width, height);
		water = sheet.crop(width, 0, width, height);
		dust = sheet.crop(width * 2, 0, width, height);
		tree = sheet.crop(width * 3, 0, width, height);
		rock = sheet.crop(0, height, width, height);
	}
}
