package com.core.grid;

import java.awt.Point;

import org.newdawn.slick.Graphics;

import com.core.Const;
import com.core.GameObject;
import com.core.enums.BlockType;

public class GridBlock extends GameObject {
	
	private final Point id;
	
	private int placedStatus;
	
	private BlockType type;	
	
	public GridBlock(float x, float y, Point id, BlockType type) {
		super(x, y);

		this.id = id;
		this.type = type;
		
		placedStatus = 0;
	}
	
	public void render(Graphics g) {
		type.getImage().draw(x, y, Const.SIZE, Const.SIZE);
	}
	
	public void placeFigure(boolean isPlaced) {
		if(isPlaced) {
			type = BlockType.PLACED;
			placedStatus = 1;
		}
		else {
			type = BlockType.BG;
			placedStatus = 0;
		}
	}
	
	public Point getID() {
		return id;
	}
	
	public BlockType getType() {
		return type;
	}
	
	public int getPlacedStatus() {
		return placedStatus;
	}
	
	public void setType(BlockType type) {
		this.type = type;
	}
	
	public void setPlacedStatus(int status) {
		this.placedStatus = status;
	}
}
