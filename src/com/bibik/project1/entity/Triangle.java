package com.bibik.project1.entity;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bibik.project1.observer.base.Observable;
import com.bibik.project1.observer.base.Observer;

public class Triangle implements Observable {
	private List<Observer> observers;
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private TriangleParameters triangleParameters;
	
	public Triangle (Point pointA, Point pointB, Point pointC) {
		Logger logger = LogManager.getLogger(Triangle.class);
		observers = new LinkedList<>();
		if (!checkThreePointsLieOnStraightLine(pointA, pointB, pointC)) { 
			this.pointA = pointA;
			this.pointB = pointB;
			this.pointC = pointC;
			logger.info("New triangle has been created. " + this.toString());
		} else {
			logger.warn("Points lie on streight line! Triangle cannot be created.");
			//TROUGH EXCEPTION
		}
	}
	
	public double calculateSideLength(Point point1, Point point2) {
		return Math.hypot(point2.getX()-point1.getX(), point2.getY()-point1.getY());
	}
	
	public boolean checkThreePointsLieOnStraightLine(Point pointA, Point pointB, Point pointC) {
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

	public TriangleParameters getTriangleParameters() {
		return triangleParameters;
	}

	public void setTriangleParameters(TriangleParameters triangleParameters) {
		this.triangleParameters = triangleParameters;
	}

	public void updatePointA(Point pointA) {
		Logger logger = LogManager.getLogger(Triangle.class);
		if (!checkThreePointsLieOnStraightLine(pointA, pointB, pointC)) { //Update only if new point does not lie on straight line with two others.  
			this.pointA = pointA; 
			logger.info("The triangle has been updated. " + this.toString());
			notifyObservers();
		} else {
			logger.warn("Points lie on streight line! Triangle cannot be updated.");
			//TROUGH EXCEPTION
		}
	}

	public void updatePointB(Point pointB) {
			Logger logger = LogManager.getLogger(Triangle.class);
			if (!checkThreePointsLieOnStraightLine(pointA, pointB, pointC)) { //Update only if new point does not lie on straight line with two others.
				this.pointB = pointB;
				logger.info("The triangle has been updated. " + this.toString());
				notifyObservers();
			} else {
				logger.warn("Points lie on streight line! Triangle cannot be updated.");
				//TROUGH EXCEPTION
			}
	}

	public void updatePointC(Point pointC) {
		Logger logger = LogManager.getLogger(Triangle.class);
		if (!checkThreePointsLieOnStraightLine(pointA, pointB, pointC)) { //Update only if new point does not lie on straight line with two others.
			this.pointC = pointC;
			logger.info("The triangle has been updated. " + this.toString());
			notifyObservers();
		} else {
			logger.warn("Points lie on streight line! Triangle cannot be updated.");
			//TROUGH EXCEPTION
		}
	}

	@Override
	public String toString() {
		return "Triangle: PointA " + pointA.toString() + ", PointB " + pointB.toString() + ", PointC " + pointC.toString();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);		
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers)
            observer.update(this);
		
	}

}