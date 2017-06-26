package test.bibik.project1.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.bibik.project1.action.TestTriangleParametersCalculation;
import test.bibik.project1.entity.TestTriangleListSingleton;
import test.bibik.project1.observer.TestObserver;
import test.bibik.project1.parser.TestLineParser;
import test.bibik.project1.readfile.TestReadFile;

@Suite.SuiteClasses( {TestTriangleParametersCalculation.class, TestTriangleListSingleton.class, TestObserver.class, TestLineParser.class, TestReadFile.class } )
@RunWith(Suite.class) 

public class MainTestSuite {

}
