package com.thanhnl4.unittest.calculation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculationGenericTest {
	@Mock
	List mock = new ArrayList<>();
	
	@Spy
	List spy = new ArrayList<>();
	
	@Test
	public void test() {
		mock.add(1);
		mock.add(2);
		
		verify(mock, times(1)).add(1);
		verify(mock, never()).add(3);
	}
	
	@Test
	public void capture() {
		ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
		mock.add(1);
		verify(mock, atLeast(1)).add(captor.capture());
		assertEquals(1, captor.getValue());
	}
	
	@Test
	public void captureForMultiValues() {
		ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
		mock.add(1);
		mock.add(2);
		System.out.println(mock.size());
		verify(mock, atLeast(1)).add(captor.capture());
		List<Integer> items = captor.getAllValues();
		for(Integer i : items)
				System.out.println(i);
	}
	
	@Test
	public void captureForMultiValuesWithSpy() {
		ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
		spy.add(1);
		spy.add(2);
		System.out.println(spy.size());
		verify(spy, atLeast(1)).add(captor.capture());
		List<Integer> items = captor.getAllValues();
		for(Integer i : items)
				System.out.println(i);
	}
}
