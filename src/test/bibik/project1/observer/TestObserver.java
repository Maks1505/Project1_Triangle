package test.bibik.project1.observer;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bibik.project1.entity.Point;
import com.bibik.project1.entity.Triangle;
import com.bibik.project1.entity.TriangleParameters;
import com.bibik.project1.factory.TriangleFactory;

public class TestObserver {
	//private static Logger LOGGER = LogManager.getLogger(TestObserver.class);
	
	@Test
	public void testObserver() {
		//LOGGER.info("Test observer");
		Point pointA = new Point(2, 2);
		Point pointB = new Point(3, 3);
		Point pointC = new Point(4, 5);
		
		Triangle tr = new TriangleFactory().createTriangle("SIMPLE", pointA, pointB, pointC);
		TriangleParameters trParam = new TriangleParameters();
		tr.setTriangleParameters(trParam); //trParam is empty
		tr.registerObserver(trParam);
		tr.updatePointA(new Point(1,1)); //this should trigger update of trParam object
		assertEquals(0.9999999999999988, tr.getTriangleParameters().getArea(), 0.00000001);
	}
	
}
