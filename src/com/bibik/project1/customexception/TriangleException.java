package com.bibik.project1.customexception;

public class TriangleException extends Exception {
	
	public TriangleException() {
	}

	public TriangleException(String message, Throwable cause) {
		super(message, cause);
	}

	public TriangleException(String message) {
		super(message);
	}

	public TriangleException(Throwable cause) {
		super(cause);
	}

	
}
