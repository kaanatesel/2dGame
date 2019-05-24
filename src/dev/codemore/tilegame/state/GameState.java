package dev.codemore.tilegame.state;

import java.awt.Graphics;

import dev.codemore.tilegame.Game;
import dev.codemore.tilegame.entities.player.Player;
import dev.codemore.tilegame.gfx.Assets;

public class GameState extends State{
	
	public GameState(Game game) {
		super(game);
		player = new Player(game, 100, 100);
	}

	private Player player;
	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
	}

}
