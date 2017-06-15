package com.bibik.project1.action;

import com.bibik.project1.entity.Triangle;

public class TriangleParametersCalculation {

	public static double calculateTrianglePerimeter(Triangle tr) {
		double sideA = tr.calculateSideLength(tr.getPointA(), tr.getPointB());
		double sideB = tr.calculateSideLength(tr.getPointB(), tr.getPointC());
		double sideC = tr.calculateSideLength(tr.getPointC(), tr.getPointA());
		return sideA + sideB + sideC; 
	}

	public static double calculateTriangleArea(Triangle tr) {
		double sideA = tr.calculateSideLength(tr.getPointA(), tr.getPointB());
		double sideB = tr.calculateSideLength(tr.getPointB(), tr.getPointC());
		double sideC = tr.calculateSideLength(tr.getPointC(), tr.getPointA());
		//Calculate triangle's area using Heron's formula
		double s = (sideA + sideB + sideC)/2;
		return Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
	}

}
