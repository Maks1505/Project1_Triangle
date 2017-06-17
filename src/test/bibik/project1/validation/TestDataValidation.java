package test.bibik.project1.validation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bibik.project1.entity.Point;
import com.bibik.project1.validation.DataValidation;

public class TestDataValidation {

	@Test
	public void test() {
		Point pointA = new Point(2, 2);
		Point pointB = new Point(3, 3);
		Point pointC = new Point(4, 4);
		assertTrue(DataValidation.checkThreePointsLieOnStraightLine(pointA, pointB, pointC));
	}

}
