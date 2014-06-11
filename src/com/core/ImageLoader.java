package com.core;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class ImageLoader {
	
	public static Image loadImage(String path) {
		try {
			return new Image(path);
		} catch (SlickException e) {
			System.out.println("Can't load image");
			e.printStackTrace();
			return null;
		}
	}
}
