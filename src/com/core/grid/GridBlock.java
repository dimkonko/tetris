package com.core.grid;

import java.awt.Point;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SpriteSheet;

import com.core.Const;
import com.core.GameObject;
import com.core.enums.BlockType;

public class GridBlock extends GameObject {
	
	private final Point id;
	
	private boolean isAnimPlaying;
	
	private int placedStatus;
	
	private BlockType type;	
	
	private Animation anim;
	
	public GridBlock(float x, float y, Point id, BlockType type) {
		super(x, y);

		this.id = id;
		this.type = type;
		
		isAnimPlaying = false;
		
		placedStatus = 0;
		
		anim = new Animation(new SpriteSheet(BlockType.Animation.getImage(),
				Const.SIZE, Const.SIZE), 30);
		anim.setLooping(false);
	}
	
	public void render(Graphics g) {
		if(isAnimPlaying) {
			anim.draw(x, y);
		}
		else {
			type.getImage().draw(x, y, Const.SIZE, Const.SIZE);
		}
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
	
	public void resetAnim() {
		anim.restart();
		isAnimPlaying = false;
	}
	
	public void startAnim() {
		anim.start();
	}
	
	public Point getID() {
		return id;
	}
	
	public BlockType getType() {
		return type;
	}
	
	public boolean isAnimStoped() {
		return anim.isStopped();
	}
	
	public int getPlacedStatus() {
		return placedStatus;
	}
	
	public void setAnimPlaying(boolean b) {
		this.isAnimPlaying = b;
	}
	
	public void setType(BlockType type) {
		this.type = type;
	}
	
	public void setPlacedStatus(int status) {
		this.placedStatus = status;
	}
}
