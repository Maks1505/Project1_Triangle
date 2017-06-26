package test.bibik.project1.readfile;

import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bibik.project1.readfile.ReadFile;

public class TestReadFile {
	private static Logger LOGGER = LogManager.getLogger();
	private static final String FILENAME = "resources" + File.separator + "inputData.txt";
	
	@Test
	public void testReadLinesFromFile() {
		List<String> fileContent = null;
		try {
			fileContent = ReadFile.readLinesFromFile(FILENAME);
		} catch (IOException e) {
			LOGGER.error("File cannot be read!");
			e.printStackTrace();
		}
		fileContent.forEach(System.out::println);
		
		fail("Not yet implemented"); //change to use Assert methods
	}

}
