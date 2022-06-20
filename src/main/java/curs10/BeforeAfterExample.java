package curs10;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BeforeAfterExample {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
			
	}
	@Test
	public void test1() {
		System.out.println("Test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("Test 2");
	}
	
		
		@AfterSuite
		public void afterSuite() {
			System.out.println("AfterSuite");
		}
		
		@AfterClass
		public void afterClass() {
			System.out.println("After Class");
		}
		@AfterMethod
		public void afterMethod() {
			System.out.println("After Method");
				
		}
	}
