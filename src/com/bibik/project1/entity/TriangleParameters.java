package com.bibik.project1.entity;

import com.bibik.project1.action.TriangleParametersCalculation;
import com.bibik.project1.observer.base.Observer;

public class TriangleParameters implements Observer{
	private double area;
	private double perimeter;

	@Override
	public void update(AbstractTriangle triangle) {
		this.area = TriangleParametersCalculation.calculateTriangleArea(triangle);
		this.perimeter = TriangleParametersCalculation.calculateTrianglePerimeter(triangle);
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
