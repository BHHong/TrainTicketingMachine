package com.myproject.ticketing.model;

import java.text.DecimalFormat;

public class Train {

	private String destination;
	private double price;
	private String startTime;
	private String endTime;
	private int totalSeat;
	DecimalFormat df = new DecimalFormat("#0.00");

	public Train(String destination, double price, String startTime, String endTime, int totalSeat) {
		this.destination = destination;
		this.price = price;
		this.startTime = startTime;
		this.endTime = endTime;
		this.totalSeat = totalSeat;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	@Override
	public String toString() {
		return "Train [Destination=" + this.destination + ", Price=£" + df.format(this.price) + ", Start Time="
				+ this.startTime + ", End Time=" + this.endTime + ", Seat available=" + this.totalSeat + "]";
	}

}
