package com.bibik.project1.readfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFile {
	
	public static Stream<String> readLinesFromFile(String fileName) {
		Stream<String> fileContent = null;
		try {
			fileContent = Files.lines(Paths.get(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileContent;
	}
}
