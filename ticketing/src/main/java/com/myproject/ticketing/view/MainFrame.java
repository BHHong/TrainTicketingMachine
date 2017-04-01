package com.myproject.ticketing.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.myproject.ticketing.controller.TicketingController;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private String fileLocation;
	private TicketingController tc;
	private TextPanel textPanel;
	private OrderPanel orderPanel;

	public MainFrame() {

		this.fileLocation = "src/main/resources/trainDataset.csv";
		this.tc = new TicketingController(fileLocation);
		this.orderPanel = new OrderPanel(fileLocation);
		this.textPanel = new TextPanel();
		
		// setup main frame layout
		this.setLayout(new BorderLayout());
		this.setTitle("Train Ticketing Machine");
		this.setBounds(10,10,800,300);
		this.setVisible(true);
		this.add(orderPanel, BorderLayout.WEST);
		this.add(textPanel,BorderLayout.CENTER);
		
		// exit when close window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set listener for button
		this.orderPanel.setDetailsListener(new DetailsListener(){
			@Override
			public void passDetails(String destination, double fund){
				tc.tryPurchase(destination, fund);
			}
		});
		
		this.orderPanel.setTextPanelListener(new TextPanelListener(){
			@Override
			public void appendText(String text){
				textPanel.appendText(text);
			}

			@Override
			public void clearText() {
				textPanel.clearText();
			}
		});
		
	}
}
