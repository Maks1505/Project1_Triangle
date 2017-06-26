package com.bibik.project1.validation;

import com.bibik.project1.customexception.DataValidationException;
import com.bibik.project1.entity.Point;

public class DataValidation {
	public static boolean checkThreePointsLieOnStraightLine(Point pointA, Point pointB, Point pointC) {
		return ((pointC.getX() - pointA.getX()) / (pointB.getX() - pointA.getX())) == ((pointC.getY() - pointA.getY()) / (pointB.getY() - pointA.getY()));
	}

	
	public static boolean checkInputData() {
		return false;
	}
	
	public static boolean checkSixElementsInRow(String[] parsedLine) {
		return parsedLine.length == 6 ? true : false;
	}
	
	public static void checkAllNumbersInt(String[] parsedLine) throws DataValidationException {
		for (String item : parsedLine) {
			try {
				Integer.parseInt(item.trim());
			} catch (NumberFormatException e) {
				throw new DataValidationException("Some elements in the line are not Integer ", e);
			}
		}
	}
}
