package test.bibik.project1.entity;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bibik.project1.entity.GeometricalFigure;
import com.bibik.project1.entity.Point;
import com.bibik.project1.entity.Triangle;
import com.bibik.project1.factory.GeometricalFigureFactory;

public class TestTriangle {
	private static final Logger LOGGER = LogManager.getLogger();
	

	@BeforeClass 
	public static void testDataSet() {
		LOGGER.info("LET'S GIVE IT ANOTHER TRY!");
	}
	
	@Test
	public void testSideLengthCalculation() {
		Point pointA = new Point(2, 2);
		Point pointB = new Point(3, 3);
		Point pointC = new Point(4, 5);
		Triangle tr = new Triangle(pointA, pointB, pointC);
		assertEquals(1.4142135623730951, tr.calculateSideLength(pointB, pointA), 0.00000001);
	}

	// HOW TO TEST PRIVATE METHODS?
/*
	@Test
	public void test1() {
		GeometricalFigureFactory factory = new GeometricalFigureFactory();
		GeometricalFigure tr = factory.getGeometricalFigureFromFactory("TRIANGLE");
		tr.se
		Point pointA = new Point(2, 2);
		Point pointB = new Point(3, 3);
		Point pointC = new Point(4, 4);
;
		assertTrue(tr.checkThreePointsLieOnStraightLine(pointA, pointB, pointC));
	}
*/
	
}
