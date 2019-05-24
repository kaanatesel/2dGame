package dev.codemore.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.codemore.tilegame.display.Display;
import dev.codemore.tilegame.gfx.Assets;
import dev.codemore.tilegame.gfx.ImageLoader;
import dev.codemore.tilegame.gfx.SpriteSheet;
import dev.codemore.tilegame.input.KeyManager;
import dev.codemore.tilegame.state.GameState;
import dev.codemore.tilegame.state.State;

public class Game implements Runnable {
	private Display display;
	private Thread thread;

	private boolean running = false;
	private int width;
	private int height;

	private BufferStrategy bs;
	private Graphics g;

	public String title;
	//State
	private State gameState;
	private State menuState;
	
	//Keys
	private KeyManager keyManager;

	public Game(String title, int width, int height) {

		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}

	private void init() {
		display = new Display(title, width, height);
		display.getJFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameState = new GameState(this);
		menuState = new GameState(this);
		State.setState(gameState);
	}

	private void tick() {
		
		keyManager.tick();
		
		if(State.getState() != null)
		{
			State.getState().tick();
		}
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clean
		g.clearRect(0, 0, width, height);
		// Draw here
		if(State.getState() != null)
		{
			State.getState().render(g);
		}
		
		// End drawing
		bs.show();
		g.dispose();
	}

	public void run() {
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while (running) {
			now = System.nanoTime();
			delta += (now -lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1)
			{
				tick();
				render();	
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000)
			{
				System.out.println("Tick and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}

		}
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();

	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
