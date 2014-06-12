package com.core.figures;

import java.awt.Point;

public abstract class Figure {
	
	protected Point[] figure;
	
	protected Point[][] facing;
	
	private final int facingCount;
	private int curFacing;
	
	public Figure(int facingCount, int curFacing) {
		figure = new Point[4];
		
		facing = new Point[facingCount][figure.length];
		
		this.facingCount = facingCount - 1;
		this.curFacing = curFacing;
	}
	
	public void update() {		
		for(int y = 0; y <= facingCount; y++) {
			for(int x = 0; x < figure.length; x++) {
				facing[y][x].setLocation(facing[y][x].x, facing[y][x].y + 1);
			}
		}
	}
	
	public void moveLeft() {		
		for(int y = 0; y <= facingCount; y++) {
			for(int x = 0; x < figure.length; x++) {
				facing[y][x].setLocation(facing[y][x].x - 1, facing[y][x].y);
			}
		}
	}
	
	public void moveRight() {		
		for(int y = 0; y <= facingCount; y++) {
			for(int x = 0; x < figure.length; x++) {
				facing[y][x].setLocation(facing[y][x].x + 1, facing[y][x].y);
			}
		}
	}
	
	public void turn() {
		if(facingCount > 0) {
			
			if(curFacing >= facingCount) {
				curFacing = 0;
			}
			else {
				curFacing++;
			}
			figure = facing[curFacing];
			
			
		}
	}
	
	public Point[] getNextFacing() {
		if(curFacing >= facingCount) {
			return facing[0];
		}
		else {
			return facing[curFacing + 1];
		}
	}
	
	public Point[] getFigure() {
		return facing[curFacing];
	}
}
