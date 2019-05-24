package dev.codemore.tilegame.state;

import java.awt.Graphics;

import dev.codemore.tilegame.Game;

public abstract class State {

	public static State currentState = null;

	protected Game game;
	
	public State(Game game)
	{
		this.game = game;
	}
	
	public static void setState(State state) {
		currentState = state;
	}

	public static State getState() {
		return currentState;
	}

	public abstract void tick();

	public abstract void render(Graphics g);
}