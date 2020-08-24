package com.thanhnl4.unittest.calculation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.thanhnl4.unittest.service.DataService;

@RunWith(MockitoJUnitRunner.class)
public class CalculationMockTest {
	@InjectMocks
	private Calculate calculate;
	
	@Mock
	private DataService dataService;
	
	@Test
	public void calculate_normal() {
		when(dataService.sampleData()).thenReturn(new int[] {1, 2, 3});
		int actual = calculate.calculate(dataService.sampleData());
		int expected = 6;
		assertEquals(expected, actual);
	}
}
