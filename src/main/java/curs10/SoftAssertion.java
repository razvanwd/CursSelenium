package curs10;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {

	
	@Test(priority = 1)
	public void softAssert() {
		System.out.println("soft asserstion -> incepe aici");

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(false);
		
		System.out.println("soft asserstion -> se termina aici");
		
		
		softAssert.assertAll();
	}
	
	@Test(priority = 2)
	public void hardAssert() {
		System.out.println("Hard asserstion -> incepe aici");
		assertTrue(false);
		
		System.out.println("Hard asserstion -> se termina aici");

	}
	
}
