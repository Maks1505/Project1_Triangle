package com.bibik.project1.readfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {
	
	public static List<String> readLinesFromFile(String fileName) throws IOException {
		List<String> fileContent = new ArrayList<>();
		Stream<String> fileStream = null;

		try {
			fileStream = Files.lines(Paths.get(fileName));
			fileContent = fileStream.collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		} finally {
			fileStream.close();
		}
		return fileContent;
	}
}
