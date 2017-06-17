package com.bibik.project1.entity;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bibik.project1.observer.base.Observable;
import com.bibik.project1.observer.base.Observer;
import com.bibik.project1.validation.DataValidation;

public class Triangle extends GeometricalFigure implements Observable {
	private Logger logger = LogManager.getLogger();
	private List<Observer> observers;
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private TriangleParameters triangleParameters;
	
	public Triangle (Point pointA, Point pointB, Point pointC) {
		observers = new LinkedList<>();
		if (!DataValidation.checkThreePointsLieOnStraightLine(pointA, pointB, pointC)) { 
			this.pointA = pointA;
			this.pointB = pointB;
			this.pointC = pointC;
			//logger.info("New triangle has been created. " + this.toString());
		} else {
			//logger.warn("Points lie on straight line! Triangle cannot be created.");
			//TROUGH EXCEPTION
		}
	}
	
	public Triangle() {
		// Used to create empty object via Factory. Use other methods to check data and set fields.  
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
		if (!DataValidation.checkThreePointsLieOnStraightLine(pointA, pointB, pointC)) { //Update only if new point does not lie on straight line with two others.  
			this.pointA = pointA; 
			logger.info("The triangle has been updated. " + this.toString());
			notifyObservers();
		} else {
			logger.warn("Points lie on streight line! Triangle cannot be updated.");
			//TROUGH EXCEPTION
		}
	}

	public void updatePointB(Point pointB) {
			if (!DataValidation.checkThreePointsLieOnStraightLine(pointA, pointB, pointC)) { //Update only if new point does not lie on straight line with two others.
				this.pointB = pointB;
				logger.info("The triangle has been updated. " + this.toString());
				notifyObservers();
			} else {
				logger.warn("Points lie on streight line! Triangle cannot be updated.");
				//TROUGH EXCEPTION
			}
	}

	public void updatePointC(Point pointC) {
		if (!DataValidation.checkThreePointsLieOnStraightLine(pointA, pointB, pointC)) { //Update only if new point does not lie on straight line with two others.
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