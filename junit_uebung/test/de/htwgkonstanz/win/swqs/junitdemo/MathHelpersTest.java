package de.htwgkonstanz.win.swqs.junitdemo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.htwgkonstanz.win.swqs.junitdemo.MathHelpers;

public class MathHelpersTest {

	@Test
	public void testGgT1() {
		// setup
		MathHelpers mathHelper = new MathHelpers();
		List<Integer> values = new ArrayList<Integer>();
		values.add(3);
		values.add(12);
		values.add(15);
		
		// execute
		int value = mathHelper.ggT(values);
		
		// verify
		assertEquals(3, value);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGgT2() {
		// setup
		MathHelpers mathHelper = new MathHelpers();
		List<Integer> values = new ArrayList<Integer>();
			
		// execute
		int value = mathHelper.ggT(values);
				
		// verify
		assertEquals(0, value);
	}

}
