package com.bibik.project1.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import test.bibik.project1.entity.TestTriangle;

public class Triangle {

	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	public Triangle (Point pointA, Point pointB, Point pointC) {
		Logger logger = LogManager.getLogger(TestTriangle.class);
		if (!checkThreePointsLieOnStreightLine(pointA, pointB, pointC)) { 
			this.pointA = pointA;
			this.pointB = pointB;
			this.pointC = pointC;
			logger.info("New triangle has been created. " + this.toString());
		} else {
			logger.warn("Points lie on streight line! Triangle cannot be created.");
			//TROUGH EXCEPTION
		}
	}
	
	public double calculateLength(Point point1, Point point2) {
		return Math.hypot(point2.getX()-point1.getX(), point2.getY()-point1.getY());
	}
	
	private boolean checkThreePointsLieOnStreightLine(Point pointA, Point pointB, Point pointC) {
		if (((pointC.getX() - pointA.getX()) / (pointB.getX() - pointA.getX())) == ((pointC.getY() - pointA.getY()) / (pointB.getY() - pointA.getY())))
				return true;
		else return false;
	}
	
	public Point getPointA() {
		return pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public Point getPointC() {
		return pointC;
	}
		
	@Override
	public String toString() {
		return "Triangle: PointA " + pointA.toString() + ", PointB " + pointB.toString() + ", PointC " + pointC.toString();
	}


}