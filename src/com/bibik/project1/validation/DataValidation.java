package com.bibik.project1.validation;

import com.bibik.project1.entity.Point;

public class DataValidation {
	public static boolean checkThreePointsLieOnStraightLine(Point pointA, Point pointB, Point pointC) {
		return ((pointC.getX() - pointA.getX()) / (pointB.getX() - pointA.getX())) == ((pointC.getY() - pointA.getY()) / (pointB.getY() - pointA.getY()));
	}

	
	public static boolean checkInputData() {
		return false;
	}
}
