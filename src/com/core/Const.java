package com.core;

public class Const {

	public static final int WIDTH = 320;
	public static final int HEIGHT = 480;
	
	public static final int SIZE = 32;
	public static final int SCALE = 1;

	public static final int COLUMNS = WIDTH / SIZE;
	public static final int LINES = HEIGHT / SIZE;
	
	public static final int START_ID = COLUMNS / 2 - 1;
	
	public static final int MB = 1024 * 1024;
	
	public static final int MAX_TIME = 40 * 16;
	public static final int MAX_TIME_ACCELERATED = 10 * 16;
}
