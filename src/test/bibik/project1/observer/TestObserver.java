package test.bibik.project1.observer;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.bibik.project1.entity.Point;
import com.bibik.project1.customexception.TriangleException;
import com.bibik.project1.entity.AbstractTriangle;
import com.bibik.project1.entity.TriangleParameters;
import com.bibik.project1.factory.TriangleFactory;

public class TestObserver {
	private static Logger LOGGER = LogManager.getLogger(TestObserver.class);
	
	@Test
	public void testObserver() {
		//LOGGER.info("Test observer");
		Point pointA = new Point(2, 2);
		Point pointB = new Point(3, 3);
		Point pointC = new Point(4, 5);
		AbstractTriangle tr = null;
		try {
			tr = new TriangleFactory().createTriangle("SIMPLE", pointA, pointB, pointC);
		} catch (TriangleException e) {
			LOGGER.error(e.getMessage() + pointA.toString() + " " + pointB.toString() + " " + pointC.toString());
		}
		TriangleParameters trParam = new TriangleParameters();
		tr.setTriangleParameters(trParam); //trParam is empty
		tr.registerObserver(trParam);
		tr.updatePointA(new Point(1,1)); //this should trigger update of trParam object
		assertEquals(0.9999999999999988, tr.getTriangleParameters().getArea(), 0.00000001);
	}
	
}
