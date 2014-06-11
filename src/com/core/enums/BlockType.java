package com.core.enums;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.core.Strings;

public enum BlockType {
	BG(Strings.BLOCK_BG),
	MOVED(Strings.BLOCK_MOVED),
	PLACED(Strings.BLOCK_PLACED);
	
	private Image img;
	
	BlockType(String path) {
		try {
			img = new Image(path);
		} catch (SlickException e) {
			System.out.println("Can't load image");
			e.printStackTrace();
		}
	}
	
	public Image getImage() {
		return img;
	}
}
