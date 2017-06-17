package com.bibik.project1.factory;

import com.bibik.project1.entity.GeometricalFigure;
import com.bibik.project1.entity.Triangle;

public class GeometricalFigureFactory {
	
	public static GeometricalFigure getGeometricalFigureFromFactory(String type) {
		GeometricalFigureType figureType = GeometricalFigureType.valueOf(type.toUpperCase());
		switch(figureType) {
		case TRIANGLE: return new Triangle();
		//default: throw new EnumConstantNotPresentException(FigureType.class, figureType.name());
		}
		return null;
	}
}
