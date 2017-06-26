package com.bibik.project1.action;

import com.bibik.project1.entity.Point;

import java.util.Arrays;

import com.bibik.project1.entity.AbstractTriangle;

public class TriangleParametersCalculation {

	public static double calculateTrianglePerimeter(AbstractTriangle tr) {
		double sideA = calculateSideLength(tr.getPointA(), tr.getPointB());
		double sideB = calculateSideLength(tr.getPointB(), tr.getPointC());
		double sideC = calculateSideLength(tr.getPointC(), tr.getPointA());
		return sideA + sideB + sideC; 
	}

	public static double calculateTriangleArea(AbstractTriangle tr) {
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
	
	public static boolean checkRightAngledTriangle(AbstractTriangle tr) {
		double sideA = calculateSideLength(tr.getPointA(), tr.getPointB());
		double sideB = calculateSideLength(tr.getPointB(), tr.getPointC());
		double sideC = calculateSideLength(tr.getPointC(), tr.getPointA());
		double sideArray[] = {sideA, sideB, sideC};
		Arrays.sort(sideArray); //sort array in ascending order.
		return (Math.pow(sideArray[2], 2) == Math.pow(sideArray[0], 2) + Math.pow(sideArray[1], 2)) ? true : false;  
	}

}
