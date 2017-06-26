package test.bibik.project1.maintest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.bibik.project1.action.TriangleParametersCalculation;
import com.bibik.project1.customexception.DataValidationException;
import com.bibik.project1.customexception.TriangleException;
import com.bibik.project1.entity.AbstractTriangle;
import com.bibik.project1.entity.Point;
import com.bibik.project1.entity.TriangleListSingleton;
import com.bibik.project1.entity.TriangleParameters;
import com.bibik.project1.factory.TriangleFactory;
import com.bibik.project1.parser.LineParser;
import com.bibik.project1.readfile.ReadFile;
import com.bibik.project1.validation.DataValidation;

public class TestMultipleTriangleCreation {

	private static final Logger LOGGER = LogManager.getLogger();
	private static final String FILENAME = "resources" + File.separator + "inputData.txt";
	
	@Test
	public void managingCode() { //read file, parse lines, validate data, create triangles, calculate parameters, add to singleton, log actions and errors
		LOGGER.info("PROGRAM IS RUNNING");

		List<String> fileContent = null;
		try {
			fileContent = ReadFile.readLinesFromFile(FILENAME);
		} catch (IOException e) {
			LOGGER.error("File does not exist or cannot be read!");
			e.printStackTrace();
		}
		
		LOGGER.info(fileContent.size() + " line/s were read from file");
		
		TriangleFactory trFac = new TriangleFactory();
		TriangleListSingleton trListSngl = TriangleListSingleton.getInstance();
		
		for (String line : fileContent) {
			LOGGER.info("Next Line: " + line);
			String[] parsedLine = LineParser.parseLine(line);
			if (DataValidation.checkSixElementsInRow(parsedLine)) {
				try {
					DataValidation.checkAllNumbersInt(parsedLine);
					Point pointA = new Point(Integer.parseInt(parsedLine[0].trim()), Integer.parseInt(parsedLine[1].trim()));
					Point pointB = new Point(Integer.parseInt(parsedLine[2].trim()), Integer.parseInt(parsedLine[3].trim()));
					Point pointC = new Point(Integer.parseInt(parsedLine[4].trim()), Integer.parseInt(parsedLine[5].trim()));
					AbstractTriangle tr = trFac.createTriangle("SIMPLE", pointA, pointB, pointC);
					LOGGER.info("Triangle has been created" + tr.toString());
					TriangleParameters trParam = new TriangleParameters();
					trParam.setArea(TriangleParametersCalculation.calculateTriangleArea(tr));
					trParam.setPerimeter(TriangleParametersCalculation.calculateTrianglePerimeter(tr));
					LOGGER.info("Triangle's parameters have been calculated " + trParam.toString());
					tr.setTriangleParameters(trParam);
					trListSngl.triangleList.add(tr);
					LOGGER.info("Triangle has been added to singleton.");
				} catch (DataValidationException e) {
					LOGGER.warn("The line has incorrect data: " + line);
					LOGGER.warn(e.getMessage() + " " + e.getCause());
				} catch (TriangleException e) {
					LOGGER.warn("Triangle cannot be created.");
					LOGGER.warn(e.getMessage() + " " + e.getCause());
				}
			} else {
				LOGGER.warn("Wrong number of parameters in line: " + line);
			}
		}
	}

}
