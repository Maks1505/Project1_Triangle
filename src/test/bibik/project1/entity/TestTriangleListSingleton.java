package test.bibik.project1.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bibik.project1.action.TriangleParametersCalculation;
import com.bibik.project1.entity.Point;
import com.bibik.project1.entity.Triangle;
import com.bibik.project1.entity.TriangleListSingleton;
import com.bibik.project1.entity.TriangleParameters;
import com.bibik.project1.factory.TriangleFactory;

public class TestTriangleListSingleton {

	@Test
	public void test() {
		Point pointA = new Point(2, 2);
		Point pointB = new Point(3, 3);
		Point pointC = new Point(4, 5);
		Triangle tr = new TriangleFactory().createTriangle("SIMPLE", pointA, pointB, pointC);
		TriangleParameters trParam = new TriangleParameters();
		trParam.setArea(TriangleParametersCalculation.calculateTriangleArea(tr));
		trParam.setPerimeter(TriangleParametersCalculation.calculateTrianglePerimeter(tr));

		//Create Singleton and add triangle to the list
		TriangleListSingleton trListSngl = TriangleListSingleton.getInstance();
		trListSngl.triangleList.add(tr);
		
		//Retrieve Singleton instance and get Triangle from the list
		TriangleListSingleton trListSngl1 = TriangleListSingleton.getInstance();
		Triangle tr1 = trListSngl1.triangleList.get(0);

		//compare two triangle objects
		assertEquals(tr, tr1);
		
	}
	
}
