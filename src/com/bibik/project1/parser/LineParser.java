package com.bibik.project1.parser;

public class LineParser {
	private static final String SEPARATOR = ";"; 
	
	public static /*ArrayList<String>*/ String[] parseLine(String line) {
		String[] str = line.split(SEPARATOR);
		return str ;
	}
}
