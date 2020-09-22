package com.fish;

import java.lang.reflect.Field;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public void testApp() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		assertTrue(true);
		Class cache = Integer.class.getDeclaredClasses()[0];
		Field myCache = cache.getDeclaredField("cache");
		myCache.setAccessible(true);
		
		Integer[] newCache = (Integer[]) myCache.get(cache);
		newCache[132] = newCache[133];
		
		int a = 2;
		int b = a + a;
		System.out.printf("%d + %d = %d", a, a, b);
	}
}
