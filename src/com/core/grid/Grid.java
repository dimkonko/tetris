package com.core.grid;

import java.awt.Point;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.core.Const;
import com.core.enums.BlockType;
import com.core.figures.BlockShape;
import com.core.figures.Figure;
import com.core.figures.LShape;
import com.core.figures.LineShape;
import com.core.figures.ZShape;

public class Grid extends BasicGameState {
	
	private final int figures_count;
	
	private GridBlock[][] grid;
	
	private boolean isMovedLeft, isMovedRight;
	private boolean isAccelerated, isTurned;
	private boolean isPaused;
	
	private int timeCounter;
	
	private Random rand;
	
	private Figure figure;
	
	public Grid() {
		
		figures_count = 4 - 1;
		
		grid = new GridBlock[Const.COLUMNS][Const.LINES];
		
		for(int y = 0; y < Const.LINES; y++) {
			for(int x = 0; x < Const.COLUMNS; x++) {
				grid[x][y] = new GridBlock(x * Const.SIZE,  y * Const.SIZE,
						new Point(x, y), BlockType.BG);
			}
		}
		
		isMovedLeft = false;
		isMovedRight = false;
		
		isAccelerated = false;
		
		isPaused = false;
		
		rand = new Random();
		
		initFigure();
		
		timeCounter = Const.MAX_TIME;
		
		for(int x = 0; x < Const.COLUMNS - 1; x++) {
			grid[x][Const.LINES - 1].placeFigure(true);
			grid[x][Const.LINES - 2].placeFigure(true);
		}
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		/*
		 * This method is render all bloks
		 */
		
		for(int y = 0; y < Const.LINES; y++) {
			for(int x = 0; x < Const.COLUMNS; x++) {
				grid[x][y].render(g);
			}
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
		// Check if pause button pressed
		gc.setPaused(isPaused);
		
		if(timeCounter <= 0) {
			// Cleaning figure
			setFigureType(figure.getFigure(), BlockType.BG);
			
			// Check if can move left or right
			if(isMovedLeft && canMoveLeft(figure.getFigure())) {
				figure.moveLeft();
			}
			else
				if(isMovedRight && canMoveRight(figure.getFigure())){
					figure.moveRight();
				}
			
			// Check if figure can move down
			if(canMoveDown(figure.getFigure())) {				
				figure.update();
			}
			else {
				if(isGameOver(figure.getFigure())) {
					gc.exit();
				}
				// If can't - init new figure and exit from the method
				initNewFigure(figure.getFigure());
				return;
			}
			
			// Draw figure again;
			setFigureType(figure.getFigure(), BlockType.MOVED);  // Draw new figure
			
			if(isAccelerated) {
				timeCounter = Const.MAX_TIME_ACCELERATED;
			}
			else {
				timeCounter = Const.MAX_TIME;
			}
		}
		else {
			timeCounter -= delta;
		}
		
		// Check if figure can turn
		if(isTurned && canMoveDown(figure.getNextFacing())) {
			setFigureType(figure.getFigure(), BlockType.BG);  // Cleaning figure
			figure.turn();
			isTurned = false;
			setFigureType(figure.getFigure(), BlockType.MOVED);  // Draw new figure
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
		else
			if(key == Input.KEY_RIGHT) {
				isMovedRight = false;;
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
		/*
		 * This method check next move down
		 * if there is not last line underneath
		 * if there is not placed block underneath
		 */
		for(int f = 0; f < figure.length; f++) {
			if(figure[f].y + 1 >= Const.LINES ||
					grid[figure[f].x][figure[f].y + 1].getPlacedStatus() == 1) {
				return false;
			}
		}
		return true;
	}
	
	public boolean canMoveLeft(Point[] figure) {
		/*
		 * This method check next move left
		 * if there is not last column on the left
		 * if there is not placed block on the left
		 */
		for(int f = 0; f < figure.length; f++) {
			if(figure[f].x - 1 < 0 ||
					grid[figure[f].x - 1][figure[f].y].getPlacedStatus() == 1) {
				return false;
			}
		}
		return true;
	}
	
	public boolean canMoveRight(Point[] figure) {
		/*
		 * This method check next move right
		 * if there is not last column on the right
		 * if there is not placed block on the right
		 */
		 for(int f = 0; f < figure.length; f++) {
			if(figure[f].x + 1 >= Const.COLUMNS ||
					grid[figure[f].x + 1][figure[f].y].getPlacedStatus() == 1) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isGameOver(Point[] figure) {
		for(int f = 0; f < figure.length; f++) {
			if(figure[f].y <= 0) {
				return true;
			}
		}
		return false;
	}
	
//	private boolean canTurn(Point[] figure) {
//		/*
//		 * This method check next move down
//		 * if there is not last column on the left
//		 * if there is not placed block on the left
//		 */
//		for(int f = 0; f < figure.length; f++) {
//			if(figure[f].y + 1 > Const.LINES ||
//					grid[figure[f].x][figure[f].y].getPlacedStatus() == 1) {
//				return false;
//			}
//		}
//		return true;		
//	}
	
	private void initFigure() {
		/*
		 * This method inits new figure and set status to 'moved'
		 */
		switch (rand.nextInt(figures_count)) {
		case 0:
			figure = new BlockShape();
			break;
		case 1:
			figure = new LineShape();
			break;
		case 2:
			figure = new LShape();
			break;
		case 3:
			figure = new ZShape();
			break;
		}
		setFigureType(figure.getFigure(), BlockType.MOVED);
	}
	
	private void setFigureType(Point[] figureID, BlockType type) {
		/*
		 * This method set specific block type (image)
		 * for each block in figure
		 * f - figure counter
		 */
		for(int f = 0; f < figureID.length; f++) {
			grid[figureID[f].x][figureID[f].y].setType(type);
		}
	}
	
	private void checkFullLine() {
		/*
		 * This method is checking if line is full
		 * and if it full - count score and move down other 
		 * placed blocks
		 */
		
		// Check if line is full
		int counter = 0;
		
		for(int y = Const.LINES - 1; y > 0; y--) {
			for(int x = 0; x < Const.COLUMNS; x++) {
				counter += grid[x][y].getPlacedStatus();
			}
			
			/* If counter == COLUMNS it's means, that all
			 *  blocks at this line is 'placed'
			 */
			if(counter == Const.COLUMNS) {				
				for(int bx = 0; bx < counter; bx++) {
					grid[bx][y].setType(BlockType.BG);
					grid[bx][y].setPlacedStatus(0);
	
					for(int by = Const.LINES - 1; by > 0; by--) {
						grid[bx][by].setType(grid[bx][by - 1].getType());						
						grid[bx][by].setPlacedStatus((grid[bx][by - 1].getPlacedStatus()));
					}
				}
				
				/*	And make it loop again,
				 *  because its can be one more full line
				 */
				y++;
			}
			counter = 0;
		}
	}
	
	private void initNewFigure(Point[] figureID) {
		/* 
		 * This method place block, check if line is full,
		 * init new figure
		 */
		for(int f = 0; f < figureID.length; f++) {
			grid[figureID[f].x][figureID[f].y].placeFigure(true);
		}
		
		// Check if line is full
		checkFullLine();
		
		// Init new Figure
		initFigure();
	}
	
}
