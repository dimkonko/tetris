package com.core.figures;

import java.awt.Point;

import com.core.Const;

public class BasicBlock extends Figure {

	public BasicBlock(Point id) {
		super(1, Const.FACING_RIGHT);
		
		facing[Const.FACING_RIGHT][0] = new Point(id.x, id.y);;
		facing[Const.FACING_RIGHT][1] = new Point(id.x + 1, id.y);
		facing[Const.FACING_RIGHT][2] = new Point(id.x + 1, id.y + 1);
		facing[Const.FACING_RIGHT][3] = new Point(id.x, id.y + 1);
		
		figure = facing[Const.FACING_RIGHT];
	}
}
