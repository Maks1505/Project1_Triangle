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
		this.area = TriangleParametersCalculation.calculateTriangleArea(triangle);
		this.perimeter = TriangleParametersCalculation.calculateTrianglePerimeter(triangle);
		Logger logger = LogManager.getLogger(TriangleParameters.class);
		logger.info("Area and Perimeter have been updated. " + this.toString());
	}

	public double getArea() {
		return area;
	}

	public double getPerimeter() {
		return perimeter;
	}

	public void setArea(double area) {
		this.area = area;
	}
	

	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}

	@Override
	public String toString() {
		return "Area=" + area + ", Perimeter=" + perimeter;
	}
	
	
}
