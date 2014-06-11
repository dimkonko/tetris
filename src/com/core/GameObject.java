package com.core;

public abstract class GameObject {
	
	protected float x, y;

	public GameObject(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/*
	 * Gets
	 */
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
}
