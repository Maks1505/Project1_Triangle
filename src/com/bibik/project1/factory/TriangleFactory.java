package com.bibik.project1.factory;

import com.bibik.project1.entity.Point;
import com.bibik.project1.entity.SimpleTriangle;
import com.bibik.project1.customexception.TriangleException;
import com.bibik.project1.entity.AbstractTriangle;

public class TriangleFactory {
	
	public AbstractTriangle createTriangle(String type, Point pointA, Point pointB, Point pointC) throws TriangleException {
		TriangleType figureType = TriangleType.valueOf(type.toUpperCase());
		switch(figureType) {
		case SIMPLE: return new SimpleTriangle(pointA, pointB, pointC);
		default: throw new EnumConstantNotPresentException(TriangleType.class, figureType.name());
		}
	}
}
