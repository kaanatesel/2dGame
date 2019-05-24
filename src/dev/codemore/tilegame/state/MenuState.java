package dev.codemore.tilegame.state;

import java.awt.Graphics;

import dev.codemore.tilegame.Game;
import dev.codemore.tilegame.gfx.Assets;

public class MenuState extends State{

	
	public MenuState(Game game) {
		super(game);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, 0, 0, null);	
	}

}
