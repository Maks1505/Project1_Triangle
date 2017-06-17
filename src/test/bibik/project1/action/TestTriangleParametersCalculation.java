package test.bibik.project1.action;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bibik.project1.action.TriangleParametersCalculation;
import com.bibik.project1.entity.Point;
import com.bibik.project1.entity.Triangle;

public class TestTriangleParametersCalculation {

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

}


