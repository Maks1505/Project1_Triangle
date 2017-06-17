package com.bibik.project1.action;

import com.bibik.project1.entity.Point;
import com.bibik.project1.entity.Triangle;

public class TriangleParametersCalculation {

	public static double calculateTrianglePerimeter(Triangle tr) {
		double sideA = calculateSideLength(tr.getPointA(), tr.getPointB());
		double sideB = calculateSideLength(tr.getPointB(), tr.getPointC());
		double sideC = calculateSideLength(tr.getPointC(), tr.getPointA());
		return sideA + sideB + sideC; 
	}

	public static double calculateTriangleArea(Triangle tr) {
		double sideA = calculateSideLength(tr.getPointA(), tr.getPointB());
		double sideB = calculateSideLength(tr.getPointB(), tr.getPointC());
		double sideC = calculateSideLength(tr.getPointC(), tr.getPointA());
		//Calculate triangle's area using Heron's formula
		double s = (sideA + sideB + sideC)/2;
		return Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
	}
	
	public static double calculateSideLength(Point point1, Point point2) {
		return Math.hypot(point2.getX()-point1.getX(), point2.getY()-point1.getY());
	}

}
