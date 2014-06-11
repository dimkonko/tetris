package com.core.grid;

import java.awt.Point;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.core.Const;
import com.core.enums.BlockType;
import com.core.figures.BasicBlock;
import com.core.figures.Figure;
import com.core.figures.Line;

public class Grid extends BasicGameState {
	
	public static final Color COLOR = new Color(0.2f, 0.7f, 1);
	
	private Block[][] grid;
	
	private final int[][] placedBlocks;
	
	private boolean isMovedLeft, isMovedRight;
	private boolean isAccelerated, isTurned;
	private boolean isPaused;
	
	private int timeCounter;
	
	private Input input;
	
	private Figure figure;
	
	public Grid(Input input) {
		this.input = input;
		
		grid = new Block[Const.COLUMNS][Const.LINES];
		placedBlocks = new int[Const.COLUMNS][Const.LINES];
		
		for(int y = 0; y < Const.LINES; y++) {
			for(int x = 0; x < Const.COLUMNS; x++) {
				grid[x][y] = new Block(x * Const.SIZE,  y * Const.SIZE,
						new Point(x, y), BlockType.BG);
			}
		}
		
		isMovedLeft = false;
		isMovedRight = false;
		
		isAccelerated = false;
		
		isPaused = false;
		
		figure = new Line(grid[Const.START_ID][0].getID());
		setFigure(figure.getFigure(), BlockType.MOVED);
		
		timeCounter = Const.MAX_TIME;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		gc.setSmoothDeltas(true);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		//g.setBackground(COLOR);
		
		for(int y = 0; y < Const.LINES; y++) {
			for(int x = 0; x < Const.COLUMNS; x++) {
				grid[x][y].render(g);
			}
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
		gc.setPaused(isPaused);
		
		if(timeCounter <= 0) {
			setFigure(figure.getFigure(), BlockType.BG);  // Cleaning figure
			
			if(isTurned && canTurn(figure.getNextFacing())) {
				figure.turn();
				isTurned = false;
			}
			
			if(isMovedLeft && canMoveLeft(figure.getFigure())) {
				figure.moveLeft();
			}
			else
				if(isMovedRight && canMoveRight(figure.getFigure())){
					figure.moveRight();
				}
			
			if(canMoveDown(figure.getFigure())) {				
				figure.update();
			}
			else {
				setNewFigure(figure.getFigure());
			}
			
			setFigure(figure.getFigure(), BlockType.MOVED);  // Draw new figure
			
			//System.out.println(timeCounter);
			if(isAccelerated) {
				timeCounter = Const.MAX_TIME_ACCELERATED;
			}
			else {
				timeCounter = Const.MAX_TIME;
			}
		}
		else {
			//System.out.println(delta + ", " + timeCounter);
			timeCounter -= delta;
		}
	}

	@Override
	public int getID() {
		return 0;
	}
	
	/*
	 * Events
	 */
	@Override
	public void keyPressed(int key, char c) {
		if(key == Input.KEY_LEFT) {
			isMovedLeft = true;
		}
		else {
			if(key == Input.KEY_RIGHT) {
				isMovedRight = true;
			}
		}
		
		if(key == Input.KEY_DOWN) {
			isAccelerated = true;
		}
		
		if(key == Input.KEY_UP) {
			isTurned = true;
		}
	}
	
	@Override
	public void keyReleased(int key, char c) {
		if(key == Input.KEY_LEFT) {
			isMovedLeft = false;
		}
		else {
			if(key == Input.KEY_RIGHT) {
				isMovedRight = false;;
			}
		}
		
		if(key == Input.KEY_DOWN) {
			isAccelerated = false;
		}
		
		if(key == Input.KEY_ESCAPE) {
			if(isPaused)
				isPaused = false;
			else
				isPaused = true;
		}
	}
	
	public boolean canMoveDown(Point[] figure) {
		for(int f = 0; f < figure.length; f++) {
			if(figure[f].y + 1 >= Const.LINES ||
					placedBlocks[figure[f].x][figure[f].y + 1] == 1) {
				System.out.println("can't move down");
				return false;
			}
		}
		return true;
	}
	
	public boolean canMoveLeft(Point[] figure) {
		for(int f = 0; f < figure.length; f++) {
			if(figure[f].x - 1 < 0 ||
					placedBlocks[figure[f].x - 1][figure[f].y] == 1) {
				System.out.println("can't move left");
				return false;
			}
		}
		return true;
	}
	
	public boolean canMoveRight(Point[] figure) {
		 for(int f = 0; f < figure.length; f++) {
			if(figure[f].x + 1 >= Const.COLUMNS ||
					placedBlocks[figure[f].x + 1][figure[f].y] == 1) {
				System.out.println("can't move right");
				return false;
			}
		}
		return true;
	}
	
	private boolean canTurn(Point[] figure) {
		for(int f = 0; f < figure.length; f++) {
			if(figure[f].y + 1 > Const.LINES ||
					placedBlocks[figure[f].x][figure[f].y] == 1) {
				System.out.println("can't turn");
				return false;
			}
		}
		return true;		
	}
	
	private void setFigure(Point[] figureID, BlockType type) {
		/*
		 * f - figure counter
		 */
		//System.out.println("=============================");
		for(int f = 0; f < figureID.length; f++) {
			//System.out.println(figureID[f].x + ", " + figureID[f].y);
			grid[figureID[f].x][figureID[f].y].setType(type);
		}
	}
	
	private void setNewFigure(Point[] figureID) {
		for(int f = 0; f < figureID.length; f++) {
			grid[figureID[f].x][figureID[f].y].setType(BlockType.PLACED);
			placedBlocks[figureID[f].x][figureID[f].y] = 1;
		}
		figure  = new Line(grid[Const.START_ID][0].getID());
	}
}
