package com.core.grid;

import java.awt.Point;

import org.newdawn.slick.Graphics;

import com.core.Const;
import com.core.GameObject;
import com.core.enums.BlockType;

public class Block extends GameObject {
	
	private final Point id;
	private final String sID;
	
	private BlockType type;	
	
	public Block(float x, float y, Point id, BlockType type) {
		super(x, y);

		this.id = id;
		this.type = type;
		
		sID = id.x + "," + id.y;
	}
	
	public void render(Graphics g) {
		type.getImage().draw(x, y, Const.SIZE, Const.SIZE);
		g.drawString(sID, x, y);
	}
	
	public Point getID() {
		return id;
	}
	
	public void setType(BlockType type) {
		this.type = type;
	}
}
