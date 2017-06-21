package com.bibik.project1.parser;

public class LineParser {

	public static /*ArrayList<String>*/ String[] parseLine(String line) {
		String[] str = line.split(";");
		return str ;
	}
}
