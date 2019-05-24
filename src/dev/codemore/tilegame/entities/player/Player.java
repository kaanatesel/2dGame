package dev.codemore.tilegame.entities.player;

import java.awt.Graphics;

import dev.codemore.tilegame.Game;
import dev.codemore.tilegame.entities.creature.Creature;
import dev.codemore.tilegame.gfx.Assets;

public class Player extends Creature {

	private Game game;
	
	public Player(Game game,float x, float y) {
		super(x, y, Creature.DEFAULT_WIDTH,Creature.DEFAULT_HEIGHT);
		this.game = game;
	}

	@Override
	public void tick() {
		getInput();
		move();
	}
	
	private void getInput() {
		
		yMove = 0;
		xMove = 0;
		
		if(game.getKeyManager().up)
			yMove = -speed;
		if(game.getKeyManager().down)
			yMove = speed;
		if(game.getKeyManager().left)
			xMove = -speed;
		if(game.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) x, (int) y, width, heigth, null);
	}

}
