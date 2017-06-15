package test.bibik.project1.entity;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bibik.project1.entity.Point;
import com.bibik.project1.entity.Triangle;

public class TestTriangle {
	private static Logger LOGGER = LogManager.getLogger(TestTriangle.class);
	private static Point POINTA;
	private static Point POINTB;
	private static Point POINTC;

	@BeforeClass 
	public static void testDataSet() {
		LOGGER.info("LET'S GIVE IT ANOTHER TRY!");
		POINTA = new Point(2, 2);
		POINTB = new Point(3, 3);
		POINTC = new Point(4, 5);
	}
	
	@Test
	public void testSideLengthCalculation() {
		Triangle tr = new Triangle(POINTA, POINTB, POINTC);
		assertEquals(1.4142135623730951, tr.calculateSideLength(POINTB, POINTA), 0.0000001);
	}
	

}
