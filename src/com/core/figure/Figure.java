package com.core.figure;

import java.awt.Point;

import com.core.Const;
import com.core.GameObject;
import com.core.enums.BlockType;

public abstract class Figure {
	
	protected Point[] figure;
	
	public Figure() {
		figure = new Point[4];
	}
	
	public void update() {
		for(int f = 0; f < figure.length; f++) {
			figure[f].setLocation(figure[f].x, figure[f].y + 1);
		}
	}
	
	public void moveLeft() {		
		for(int f = 0; f < figure.length; f++) {
			figure[f].setLocation(figure[f].x - 1, figure[f].y);
		}
	}
	
	public void moveRight() {		
		for(int f = 0; f < figure.length; f++) {
			figure[f].setLocation(figure[f].x + 1, figure[f].y);
		}
	}
	
	public Point[] getFigure() {
		return figure;
	}
}
