package com.bibik.project1.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bibik.project1.action.TriangleParametersCalculation;
import com.bibik.project1.observer.base.Observer;
import java.util.UUID;

public class TriangleParameters implements Observer{
	private double area;
	private double perimeter;
/*	private UUID triangleId;

	public TriangleParameters(UUID triangleId) {
		super();
		this.triangleId = triangleId;
	}
*/
	@Override
	public void update(Triangle triangle) {
		TriangleParametersCalculation paramCalc = new TriangleParametersCalculation();
		this.area = paramCalc.calculateTriangleArea(triangle);
		this.perimeter = paramCalc.calculateTrianglePerimeter(triangle);
		//Logger logger = LogManager.getLogger(TriangleParameters.class);
		//logger.info("Area and Perimeter have been updated. " + this.toString());
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
