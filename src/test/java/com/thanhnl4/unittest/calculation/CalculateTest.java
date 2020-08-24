package com.thanhnl4.unittest.calculation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculateTest {
	@Test
	public void calculate_normal() {
		int actual = new Calculate().calculate(new int[] {1, 2, 3});
		int expected = 6;
		assertEquals(expected, actual);
	}
}
