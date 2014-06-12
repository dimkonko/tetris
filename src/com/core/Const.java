package com.core;

import java.awt.Point;

public class Const {
	
	public static final int MB = 1024 * 1024;
	
	// Sizes
	public static final int WIDTH = 320;
	public static final int HEIGHT = 480;
	
	public static final int SIZE = 32;
	public static final int SCALE = 1;

	public static final int COLUMNS = WIDTH / SIZE;
	public static final int LINES = HEIGHT / SIZE;
	
	// Coordinates
	public static final Point START_ID = new Point(COLUMNS / 2 - 1, 0);
	
	// Time
	public static final int MAX_TIME = 34 * 16;
	public static final int MAX_TIME_ACCELERATED = 10 * 16;
	
	// Figure
	public static final int FIGURE_LENGTH_SIMPLE = 2;
	public static final int FIGURE_LENGTH_COMPLEX = 4;
	
	public static final int FACING_UP = 0;
	public static final int FACING_RIGHT = 1;
	public static final int FACING_DOWN = 2;
	public static final int FACING_LEFT = 3;
}
