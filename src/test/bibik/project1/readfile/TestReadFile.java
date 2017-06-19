package test.bibik.project1.readfile;

import static org.junit.Assert.*;

import java.io.File;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.bibik.project1.readfile.ReadFile;

import test.bibik.project1.observer.TestObserver;

public class TestReadFile {
	private static Logger LOGGER = LogManager.getLogger(TestObserver.class);
	private static final String FILENAME = "resources" + File.separator + "inputData.txt";
	
	@Test
	public void testReadLinesFromFile() {
		Stream<String> fileContent = ReadFile.readLinesFromFile(FILENAME);
		fileContent.forEach(System.out::println);
	}

}
