package com.myproject.ticketing.controller;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.myproject.ticketing.model.Train;

public class TicketingControllerTest {

	private TicketingController ticketingController;
	private Train t;
	private Map<String, Train> trainData;
			
	@Before
	public void setUp() throws Exception {
		ticketingController = new TicketingController("src/main/resources/testDataset.csv");
	}
	
	@After
	public void tearDown() throws Exception {
		ticketingController = null;
		t = null;
		trainData = null;
	}
	
	@Test
	public void test_HasSeat_ReturnFalse_WhenSeatIsZero() {
		// Arrange
		// Act
		boolean result = ticketingController.hasSeat("A");
		// Assert
		assertEquals(false, result);
	}
		
	@Test
	public void test_HasSeat_ReturnTrue_WhenSeatAvailable() {
		// Arrange
		// Act
		boolean result = ticketingController.hasSeat("B");
		// Assert
		assertEquals(true, result);
	}
	
	@Test
	public void test_HasFund_ReturnFalse_WhenFundIsZero(){
		// Arrange
		// Act
		boolean result = ticketingController.hasFund("A", 0.00);
		// Assert
		assertEquals(false, result);
	}

	@Test
	public void test_HasFund_ReturnTrue_WhenFundIsOneHundred(){
		// Arrange
		// Act
		boolean result = ticketingController.hasFund("A", 100.00);
		// Assert
		assertEquals(true, result);
	}
	
	@Test
	public void test_ValidDestination_ReturnFalse_WhenDestinationIsInvalid(){
		// Arrange
		// Act
		boolean result = ticketingController.validDestination("unknown");
		// Assert
		assertEquals(false, result);
	}

	@Test
	public void test_ValidDestination_ReturnTrue_WhenDestinationIsValid(){
		// Arrange
		// Act
		boolean result = ticketingController.validDestination("A");
		// Assert
		assertEquals(true, result);
	}

	
	
}
