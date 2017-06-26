package test.bibik.project1.validation;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.bibik.project1.entity.Point;
import com.bibik.project1.validation.DataValidation;

@RunWith(Parameterized.class)
public class TestDataValidation {

	@Test
	public void testThreePointsLieOnStraightLine() {
		Point pointA = new Point(2, 2);
		Point pointB = new Point(3, 3);
		Point pointC = new Point(4, 4);
		assertTrue(DataValidation.checkThreePointsLieOnStraightLine(pointA, pointB, pointC));
	}

	@Test
	public void testSixElementsInRow() {
		String[] parsedLine = {"2"," 2"," 6"," b"," 10"," 2"};
		assertTrue(DataValidation.checkSixElementsInRow(parsedLine));

	}
}
