package test.bibik.project1.validation;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.bibik.project1.entity.Point;
import com.bibik.project1.parser.LineParser;
import com.bibik.project1.validation.DataValidation;

@RunWith(Parameterized.class)
public class TestDataValidation {

	private String line;
	boolean res;

	public TestDataValidation(String line, boolean res) {
		this.line = line;
		this.res = res;
	}
	

	@Parameters public static List<Object[]> parsedLinesList() {
		return Arrays.asList(new Object[][] {
			{"2; 2; 6; 10; 10; 2;", true}, 
			{"2; 3; 6; x; 7; 2;", true}
		} 
		);
	}
	
	@Test
	public void testThreePointsLieOnStraightLine() {
		Point pointA = new Point(2, 2);
		Point pointB = new Point(3, 3);
		Point pointC = new Point(4, 4);
		assertTrue(DataValidation.checkThreePointsLieOnStraightLine(pointA, pointB, pointC));
	}

	@Test
	public void testSixElementsInRow() {
		String[] parsedLine = LineParser.parseLine(this.line);
		assertTrue(DataValidation.checkSixElementsInRow(parsedLine));  
	}
}
