package com.core.figures;

import java.awt.Point;

import com.core.Const;

public class LShape extends Figure {

	public LShape() {
		super(Const.FIGURE_LENGTH_COMPLEX, Const.FACING_UP);
		
		facing[Const.FACING_UP][0] = new Point(Const.START_ID.x, Const.START_ID.y);;
		facing[Const.FACING_UP][1] = new Point(Const.START_ID.x, Const.START_ID.y + 1);
		facing[Const.FACING_UP][2] = new Point(Const.START_ID.x, Const.START_ID.y + 2);
		facing[Const.FACING_UP][3] = new Point(Const.START_ID.x + 1, Const.START_ID.y + 2);
		
		facing[Const.FACING_RIGHT][0] = new Point(Const.START_ID.x - 1, Const.START_ID.y + 1);
		facing[Const.FACING_RIGHT][1] = new Point(Const.START_ID.x - 1, Const.START_ID.y);
		facing[Const.FACING_RIGHT][2] = new Point(Const.START_ID.x, Const.START_ID.y);
		facing[Const.FACING_RIGHT][3] = new Point(Const.START_ID.x + 1, Const.START_ID.y);
		
		facing[Const.FACING_DOWN][0] = new Point(Const.START_ID.x, Const.START_ID.y);
		facing[Const.FACING_DOWN][1] = new Point(Const.START_ID.x + 1, Const.START_ID.y);
		facing[Const.FACING_DOWN][2] = new Point(Const.START_ID.x + 1, Const.START_ID.y + 1);
		facing[Const.FACING_DOWN][3] = new Point(Const.START_ID.x + 1, Const.START_ID.y + 2);
		
		facing[Const.FACING_LEFT][0] = new Point(Const.START_ID.x + 1, Const.START_ID.y);
		facing[Const.FACING_LEFT][1] = new Point(Const.START_ID.x + 1, Const.START_ID.y + 1);
		facing[Const.FACING_LEFT][2] = new Point(Const.START_ID.x, Const.START_ID.y + 1);
		facing[Const.FACING_LEFT][3] = new Point(Const.START_ID.x - 1, Const.START_ID.y + 1);
		
		figure = facing[Const.FACING_UP];
	}

}
