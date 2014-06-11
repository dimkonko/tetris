package com.core.figure;

import java.awt.Point;

public class BasicBlock extends Figure {

	public BasicBlock(Point id) {		
		figure[0] = new Point(id.x, id.y);;
		figure[1] = new Point(id.x + 1, id.y);
		figure[2] = new Point(id.x + 1, id.y + 1);
		figure[3] = new Point(id.x, id.y + 1);
	}
}
