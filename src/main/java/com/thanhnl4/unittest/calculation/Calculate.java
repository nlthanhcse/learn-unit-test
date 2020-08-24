package com.thanhnl4.unittest.calculation;

public class Calculate {
	public int calculate(int[] a) {
		int sum = 0;
		for(int i : a)
			sum += i;
		return sum;
	}
}
