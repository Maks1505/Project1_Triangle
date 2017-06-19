package com.bibik.project1.entity;

import com.bibik.project1.observer.base.Observer;

public abstract class Triangle {
	public abstract TriangleParameters getTriangleParameters();
	public abstract void setTriangleParameters(TriangleParameters triangleParameters);
	public abstract void updatePointA(Point pointA);
	public abstract void updatePointB(Point pointB);
	public abstract void updatePointC(Point pointC);
	public abstract Point getPointA();
	public abstract Point getPointB();
	public abstract Point getPointC();
	public abstract void registerObserver(Observer o);
	public abstract void removeObserver(Observer o);
	public abstract void notifyObservers();
}
