package com.bibik.project1.entity;

import java.util.LinkedList;
import java.util.List;

import com.bibik.project1.customexception.TriangleException;
import com.bibik.project1.observer.base.Observable;
import com.bibik.project1.observer.base.Observer;
import com.bibik.project1.validation.DataValidation;

public class SimpleTriangle extends AbstractTriangle implements Observable {
	private List<Observer> observers;
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private TriangleParameters triangleParameters;
	
	public SimpleTriangle (Point pointA, Point pointB, Point pointC) throws TriangleException {
		observers = new LinkedList<>();
		if (!DataValidation.checkThreePointsLieOnStraightLine(pointA, pointB, pointC)) { 
			this.pointA = pointA;
			this.pointB = pointB;
			this.pointC = pointC;
		} else {
			throw new TriangleException("All point lie on straight line. Triangle cannot be created.");
		}
	}
	
	@Override
	public Point getPointA() {
		return pointA;
	}

	@Override
	public Point getPointB() {
		return pointB;
	}

	@Override
	public Point getPointC() {
		return pointC;
	}

	@Override
	public TriangleParameters getTriangleParameters() {
		return triangleParameters;
	}

	@Override
	public void setTriangleParameters(TriangleParameters triangleParameters) {
		this.triangleParameters = triangleParameters;
	}

	@Override
	public void updatePointA(Point pointA) {
		if (!DataValidation.checkThreePointsLieOnStraightLine(pointA, pointB, pointC)) { //Update only if new point does not lie on straight line with two others.  
			this.pointA = pointA; 
			notifyObservers();
		} else {
			//TROUGH EXCEPTION
		}
	}

	@Override
	public void updatePointB(Point pointB) {
			if (!DataValidation.checkThreePointsLieOnStraightLine(pointA, pointB, pointC)) { //Update only if new point does not lie on straight line with two others.
				this.pointB = pointB;
				notifyObservers();
			} else {
				//TROUGH EXCEPTION
			}
	}

	@Override
	public void updatePointC(Point pointC) {
		if (!DataValidation.checkThreePointsLieOnStraightLine(pointA, pointB, pointC)) { //Update only if new point does not lie on straight line with two others.
			this.pointC = pointC;
			notifyObservers();
		} else {
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