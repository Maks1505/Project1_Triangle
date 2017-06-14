package com.bibik.project1.entity;

public class Triangle {

	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	public Triangle(Point pointA, Point pointB, Point pointC) {
		super();
		//Define three points of new triangle 
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
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
	
	public double calculateLength(Point point1, Point point2) {
		return Math.hypot(point2.getX()-point1.getX(), point2.getY()-point1.getY());
	}
	
	@Override
	public String toString() {
		return "Triangle [pointA=" + pointA.toString() + ", pointB=" + pointB.toString() + ", pointC=" + pointC.toString() + "]";
	}


}