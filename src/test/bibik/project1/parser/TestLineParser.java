package test.bibik.project1.parser;

import static org.junit.Assert.*;

import java.io.File;
import java.util.stream.Stream;

import org.junit.Test;

import com.bibik.project1.readfile.ReadFile;

public class TestLineParser {
	private static final String FILENAME = "resources" + File.separator + "inputData.txt";

	@Test
	public void testParseLine() {
		Stream<String> fileContent = ReadFile.readLinesFromFile(FILENAME);
		fileContent.forEach(System.out::println);
		fail("Not yet implemented");
	}

}
