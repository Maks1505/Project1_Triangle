package test.bibik.project1.parser;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Test;

import com.bibik.project1.parser.LineParser;

public class TestLineParser {

	@Test
	public void testParseLine() {
		//List<String> fileContent = ReadFile.readLinesFromFile(FILENAME);
		String line = "2; 2; 6; b; 10; 2";
		String[] expectedParsedLine = {"2"," 2"," 6"," b"," 10"," 2"};
		String[] parsedLine = LineParser.parseLine(line);
		assertTrue(Arrays.equals(expectedParsedLine, parsedLine));
	}
}
