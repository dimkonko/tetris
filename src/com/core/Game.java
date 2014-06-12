package com.core;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.core.grid.Grid;

public class Game extends StateBasedGame {
	
	private Grid grid;
	
	public Game() {
		super("Game");
	}
	
	public static void main(String[] args) {
		try {
			AppGameContainer app = new AppGameContainer(new Game());
			app.setDisplayMode(Const.WIDTH, Const.HEIGHT, false);
			app.setShowFPS(true);
			app.setVSync(true);
			app.setSmoothDeltas(true);
			app.setUpdateOnlyWhenVisible(true);
			
			app.start();
		} catch (SlickException e) {
			System.out.println("Can't create a game");
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		
		grid = new Grid();
		
		addState(grid);
	}
 }
