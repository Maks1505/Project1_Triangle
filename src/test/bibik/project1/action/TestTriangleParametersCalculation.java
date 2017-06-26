package test.bibik.project1.action;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.bibik.project1.action.TriangleParametersCalculation;
import com.bibik.project1.customexception.TriangleException;
import com.bibik.project1.entity.Point;
import com.bibik.project1.entity.AbstractTriangle;
import com.bibik.project1.factory.TriangleFactory;

import test.bibik.project1.observer.TestObserver;

public class TestTriangleParametersCalculation {
	private static Logger LOGGER = LogManager.getLogger(TestObserver.class);
	
	@Test
	public void testCalculateSideLength() {
		Point pointA = new Point(2, 2);
		Point pointB = new Point(3, 3);
		assertEquals(1.4142135623730951, TriangleParametersCalculation.calculateSideLength(pointB, pointA), 0.00000001);
	}
	
	
	@Test
	public void testCalculateTriangleArea() {
		Point pointA = new Point(1, 1);
		Point pointB = new Point(3, 3);
		Point pointC = new Point(4, 5);
		//Triangle tr = new Triangle(pointA, pointB, pointC);
		AbstractTriangle tr = null;
		try {
			tr = new TriangleFactory().createTriangle("SIMPLE", pointA, pointB, pointC);
		} catch(TriangleException e) {
			LOGGER.error(e.getMessage() + pointA.toString() + " " + pointB.toString() + " " + pointC.toString());
		}
		assertEquals(0.9999999999999988, TriangleParametersCalculation.calculateTriangleArea(tr), 0.00000001);
	}

	
	/*
	@Test
	public void testCalculateTriangleArea() {
		Point pointA = new Point(1, 1);
		Point pointB = new Point(3, 3);
		Point pointC = new Point(4, 5);
		Triangle tr = new Triangle(pointA, pointB, pointC);
		assertEquals(0.9999999999999988, TriangleParametersCalculation.calculateTriangleArea(tr), 0.00000001);
	}

	@Test
	public void testCalculateTrianglePerimeter() {
		Point pointA = new Point(1, 1);
		Point pointB = new Point(3, 3);
		Point pointC = new Point(4, 5);
		Triangle tr = new Triangle(pointA, pointB, pointC);
		assertEquals(10.06449510224598, TriangleParametersCalculation.calculateTrianglePerimeter(tr), 0.00000001);
	}
*/
}


