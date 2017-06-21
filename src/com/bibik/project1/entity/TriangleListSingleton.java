package com.bibik.project1.entity;

import java.util.ArrayList;

public class TriangleListSingleton {
	private static volatile TriangleListSingleton instance;
	public ArrayList<Triangle> triangleList = new ArrayList<>();
	
	public static TriangleListSingleton getInstance() {
		TriangleListSingleton localInstance = instance;
		if (localInstance == null) {
			synchronized (TriangleListSingleton.class) {
				localInstance = instance;
				if (localInstance == null) {
					instance = localInstance = new TriangleListSingleton();
				}
			}
		}
		return localInstance;
	}
}
