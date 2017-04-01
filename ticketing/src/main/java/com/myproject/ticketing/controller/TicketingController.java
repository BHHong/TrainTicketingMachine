package com.myproject.ticketing.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import com.myproject.ticketing.model.Train;

public class TicketingController {

	private Map<String, Train> trainData;
	private BufferedReader br;
	private String fileLocation;
	private DecimalFormat df = new DecimalFormat("#0.00");
	private StringBuilder screenMessage;

	public TicketingController(String fileLocation) {
		this.fileLocation = fileLocation;
		this.trainData = new HashMap<String, Train>();
		this.getDataFromFile();
	}

	private void getDataFromFile() {
		String line;
		String separator = ",";
		String[] sLine;
		try {
			br = new BufferedReader(new FileReader(fileLocation));

			while ((line = br.readLine()) != null) {
				sLine = line.split(separator);
				if (sLine[4].matches("\\d+")) {
					trainData.put(sLine[0], new Train(sLine[0], Double.valueOf(sLine[1]), sLine[2], sLine[3],
							Integer.valueOf(sLine[4])));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		} finally {
			br = null;
		}
	}

	public boolean hasSeat(String destination) {
		if (trainData.get(destination).getTotalSeat() != 0) {
			return true;
		}
		this.screenMessage.append("Sold out.\n");
		return false;
	}

	public boolean hasFund(String destination, double fund) {
		if (trainData.get(destination).getPrice() <= fund) {
			return true;
		}
		this.screenMessage.append("Insufficient fund.\n");
		return false;
	}

	public boolean validDestination(String destination) {
		if (destination != "" && trainData.get(destination) != null) {
			return true;
		}
		this.screenMessage.append("Invalid destination.\n");
		return false;
	}

	public void tryPurchase(String destination, double fund) {
		screenMessage = new StringBuilder();
		if (validDestination(destination)) {
			this.screenMessage.append(trainData.get(destination).toString() + "\n");
			if (hasSeat(destination) && hasFund(destination, fund)) {
				Train t = trainData.get(destination);
				this.screenMessage.append("Purchase successful.\n");
				giveChange(t.getPrice(), fund);
				t.setTotalSeat(t.getTotalSeat() - 1);
				trainData.put(destination, t);
			}
		} else {
			this.screenMessage.append("Purchase not successful. Please try again.\n");
		}
	}

	public void giveChange(double price, double fund) {
		double change = fund - price;
		this.screenMessage.append("Please find total change of £" + df.format(change) + "\n");
		while (change >= 0.05) {
			if (change >= 10) {
				change -= 10;
				this.screenMessage.append(" [£10] ");
			} else if (change >= 5) {
				change -= 5;
				this.screenMessage.append(" [£5] ");
			} else if (change >= 2) {
				change -= 2;
				this.screenMessage.append(" (£2) ");
			} else if (change >= 1) {
				change -= 1;
				this.screenMessage.append(" (£1) ");
			} else if (change >= 0.5) {
				change -= 0.5;
				this.screenMessage.append(" (50p) ");
			} else if (change >= 0.2) {
				change -= 0.2;
				this.screenMessage.append(" (20p) ");
			} else if (change >= 0.1) {
				change -= 0.1;
				this.screenMessage.append(" (10p) ");
			} else if (change >= 0.05) {
				change -= 0.05;
				this.screenMessage.append(" (5p) ");
			}
		}
	}

	public String printScreen() {
		return this.screenMessage.toString();
	}
}
