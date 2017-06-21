package test.bibik.project1.readfile;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;
import org.junit.Test;

import com.bibik.project1.readfile.ReadFile;

public class TestReadFile {
	//private static Logger LOGGER = LogManager.getLogger(TestObserver.class);
	private static final String FILENAME = "resources" + File.separator + "inputData.txt";
	
	@Test
	public void testReadLinesFromFile() {
		List<String> fileContent = ReadFile.readLinesFromFile(FILENAME);
		fileContent.forEach(System.out::println);
		
		fail("Not yet implemented"); //change to use Assert methods
	}

}
