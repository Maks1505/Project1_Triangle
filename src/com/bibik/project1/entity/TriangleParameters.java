package com.bibik.project1.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bibik.project1.action.TriangleParametersCalculation;
import com.bibik.project1.observer.base.Observer;

public class TriangleParameters implements Observer{
	private double area;
	private double perimeter;
	
	@Override
	public void update(Triangle triangle) {
		Logger logger = LogManager.getLogger(TriangleParameters.class);
		TriangleParametersCalculation paramCalc = new TriangleParametersCalculation();
		this.area = paramCalc.calculateTriangleArea(triangle);
		this.perimeter = paramCalc.calculateTrianglePerimeter(triangle);
		logger.info("Area and Perimeter have been updated. " + this.toString());
	}

	public double getArea() {
		return area;
	}

	public double getPerimeter() {
		return perimeter;
	}

	@Override
	public String toString() {
		return "Area=" + area + ", Perimeter=" + perimeter;
	}
	
	
}
