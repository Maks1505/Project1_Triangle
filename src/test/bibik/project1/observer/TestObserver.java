package test.bibik.project1.observer;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.bibik.project1.entity.Point;
import com.bibik.project1.entity.Triangle;
import com.bibik.project1.entity.TriangleParameters;

public class TestObserver {
	private static Logger LOGGER = LogManager.getLogger(TestObserver.class);
	
	@Test
	public void testObserver() {
		LOGGER.info("Test observer");
		Point pointA = new Point(2, 2);
		Point pointB = new Point(3, 3);
		Point pointC = new Point(4, 5);
		
		Triangle tr = new Triangle(pointA, pointB, pointC);
		
		//Как записать Площадь и Периметр в TriangleParameters? Вызвать расчёт из класса или из внешнего кода через Set запушить рассчитанные значения?
		TriangleParameters trParam = new TriangleParameters();
		tr.registerObserver(trParam);
		//LOGGER.info("TriangleID: " + tr.getTRIANGLEID().toString());
		/*
		TriangleParametersCalculation trParamCalc = new TriangleParametersCalculation();
		trParam.setArea(trParamCalc.calculateTriangleArea(tr));
		trParam.setPerimeter(trParamCalc.calculateTrianglePerimeter(tr));
		*/
		LOGGER.info("New triangle has: " + trParam.toString());
		tr.updatePointA(new Point(1,1));
		LOGGER.info("Updated triangle has: " + trParam.toString());
		fail("not implemented yet");
	}
	
}
