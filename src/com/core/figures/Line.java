package com.core.figures;

import java.awt.Point;

import com.core.Const;

public class Line extends Figure {
	
	public Line(Point id) {
		super(2, Const.FACING_RIGHT);
		
		facing[Const.FACING_RIGHT][0] = new Point(id.x - 1, id.y);;
		facing[Const.FACING_RIGHT][1] = new Point(id.x, id.y);
		facing[Const.FACING_RIGHT][2] = new Point(id.x + 1, id.y);
		facing[Const.FACING_RIGHT][3] = new Point(id.x + 2, id.y);
		
		facing[Const.FACING_LEFT][0] = new Point(id.x - 1, id.y + 1);
		facing[Const.FACING_LEFT][1] = new Point(id.x - 1, id.y + 2);
		facing[Const.FACING_LEFT][2] = new Point(id.x - 1, id.y + 3);
		facing[Const.FACING_LEFT][3] = new Point(id.x - 1, id.y + 4);
		
		figure = facing[Const.FACING_RIGHT];
		
	}
}
