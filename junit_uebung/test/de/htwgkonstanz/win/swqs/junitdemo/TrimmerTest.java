package de.htwgkonstanz.win.swqs.junitdemo;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwgkonstanz.win.swqs.junitdemo.Trimmer;

public class TrimmerTest {

	@Test
	public void testTrimLeerVorne() {
		// setup
		Trimmer value = new Trimmer(" text");
		
		// execute
		String result = value.trim();
		
		// verify
		assertEquals("text", result);
	}
	
	@Test
	public void testTrimLeerHinten() {
		// setup
		Trimmer value = new Trimmer("text ");
		
		// execute
		String result = value.trim();
		
		// verify
		assertEquals("text", result);
	}
}
