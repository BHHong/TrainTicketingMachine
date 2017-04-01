package com.myproject.ticketing.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TrainTest {

	private Train train;
	
	@Before
	public void setUp() throws Exception {
		train = new Train("destination", 123.0, "01:00", "02:00", 10);
	}
	
	@After
	public void tearDown() throws Exception {
		train = null;
	}
	
	@Test
	public void test_GetDestination_WhenCalled_ReturnDestination(){
		// Arrange
		
		// Act
		String result = train.getDestination();
		// Assert
		assertEquals("destination",result);
	}
	
	@Test
	public void test_GetPrice_WhenCalled_Return123(){
		// Arrange
		
		// Act
		double result = train.getPrice();
		// Assert
		assertEquals(123,result,0.0);
	}

	@Test
	public void test_GetStartTime_WhenCalled_Return0100(){
		// Arrange
		
		// Act
		String result = train.getStartTime();
		// Assert
		assertEquals("01:00",result);	
	}
	
	@Test
	public void test_GetEndTime_WhenCalled_Return0200(){
		// Arrange
		
		// Act
		String result = train.getEndTime();
		// Assert
		assertEquals("02:00",result);
	}

	@Test
	public void test_GetTotalSeat_WhenCalled_Return10(){
		// Arrange
		
		// Act
		int result = train.getTotalSeat();
		// Assert
		assertEquals(10,result);
	}

	@Test
	public void test_SetDestination_SetDestinationToABC_ReturnABCWhenGetDestinationIsCalled(){
		// Arrange
		
		// Act
		train.setDestination("ABC");
		// Assert
		assertEquals("ABC",train.getDestination());
	}

	@Test
	public void test_SetPrice_SetPriceTo456_Return456WhenGetPriceIsCalled(){
		// Arrange
		
		// Act
		train.setPrice(456);
		// Assert
		assertEquals(456,train.getPrice(),0.0);
	}

	@Test
	public void test_SetStartTime_SetStartTimeTo0000_Return0000WhenGetStartTimeIsCalled(){
		// Arrange
		
		// Act
		train.setStartTime("00:00");
		// Assert
		assertEquals("00:00",train.getStartTime());
	}

	@Test
	public void test_SetEndTime_SetEndTimeTo1111_Return1111WhenGetEndTimeIsCalled(){
		// Arrange
		
		// Act
		train.setEndTime("11:11");
		// Assert
		assertEquals("11:11",train.getEndTime());
	}
	
	@Test
	public void test_SetTotalSeat_SetTotalSeatTo100_Return100WhenGetTotalSeatIsCalled(){
		// Arrange
		
		// Act
		train.setTotalSeat(100);
		// Assert
		assertEquals(100,train.getTotalSeat());
	}
	
	@Test
	public void test_ToString_ReturnNotNull_WhenCalled(){
		// Arrange
		
		// Act
		String result = train.toString();
		// Assert
		assertNotNull(result);
	}
}
