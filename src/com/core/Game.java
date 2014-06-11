package com.core;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.core.grid.Grid;

public class Game extends StateBasedGame {
	
	private Runtime runtime;
	private Input input;
	
	public Game() {
		super("Game");
		
		runtime = Runtime.getRuntime();
	}
	
	public static void main(String[] args) {
		try {
			AppGameContainer app = new AppGameContainer(new Game());
			app.setDisplayMode(Const.WIDTH, Const.HEIGHT, false);
			app.setShowFPS(true);
			app.setVSync(true);
			app.start();
		} catch (SlickException e) {
			System.out.println("can't create a game");
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		input = gc.getInput();
		addState(new Grid(input));
	}
 }
