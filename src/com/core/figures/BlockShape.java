package com.core.figures;

import java.awt.Point;

import com.core.Const;

public class BlockShape extends Figure {

	public BlockShape() {
		super(1, Const.FACING_UP);
		
		facing[Const.FACING_UP][0] = new Point(Const.START_ID.x, Const.START_ID.y);;
		facing[Const.FACING_UP][1] = new Point(Const.START_ID.x + 1, Const.START_ID.y);
		facing[Const.FACING_UP][2] = new Point(Const.START_ID.x + 1, Const.START_ID.y + 1);
		facing[Const.FACING_UP][3] = new Point(Const.START_ID.x, Const.START_ID.y + 1);
		
		figure = facing[Const.FACING_UP];
	}
}
