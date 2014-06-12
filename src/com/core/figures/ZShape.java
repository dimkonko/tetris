package com.core.figures;

import java.awt.Point;

import com.core.Const;

public class ZShape extends Figure {

	public ZShape() {
		super(Const.FIGURE_LENGTH_SIMPLE, Const.FACING_RIGHT);
		
		facing[Const.FACING_RIGHT][0] = new Point(Const.START_ID.x - 1, Const.START_ID.y + 1);;
		facing[Const.FACING_RIGHT][1] = new Point(Const.START_ID.x, Const.START_ID.y + 1);
		facing[Const.FACING_RIGHT][2] = new Point(Const.START_ID.x, Const.START_ID.y);
		facing[Const.FACING_RIGHT][3] = new Point(Const.START_ID.x + 1, Const.START_ID.y);
		
		facing[Const.FACING_UP][0] = new Point(Const.START_ID.x - 1, Const.START_ID.y);
		facing[Const.FACING_UP][1] = new Point(Const.START_ID.x - 1, Const.START_ID.y + 1);
		facing[Const.FACING_UP][2] = new Point(Const.START_ID.x, Const.START_ID.y + 1);
		facing[Const.FACING_UP][3] = new Point(Const.START_ID.x, Const.START_ID.y + 2);
		
		figure = facing[Const.FACING_RIGHT];
	}	
}
