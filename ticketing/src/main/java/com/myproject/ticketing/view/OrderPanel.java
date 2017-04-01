package com.myproject.ticketing.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.myproject.ticketing.controller.TicketingController;

@SuppressWarnings("serial")
public class OrderPanel extends JPanel {
	private TicketingController tc;
	private JLabel destinationLabel;
	private JTextField destinationField;
	private JLabel fundLabel;
	private JTextField fundField;
	private JButton buyButton;
	private DetailsListener detailsListener;
	private TextPanelListener textPanelListener;
	private final String alphanumericSpace = "[a-zA-Z0-9\\s]*+";
	private final String digits = "\\d*\\.?\\d+";

	public OrderPanel(String fileLocation) {
		this.tc = new TicketingController(fileLocation);
		this.destinationLabel = new JLabel("Destination");
		this.destinationField = new JTextField(10);
		this.fundLabel = new JLabel("Fund (£)");
		this.fundField = new JTextField(10);
		this.fundField.setText("0.00");
		this.buyButton = new JButton("Buy ticket");

		this.buyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textPanelListener.clearText();
				if (destinationField.getText().isEmpty() || fundField.getText().isEmpty()){			
					if(destinationField.getText().isEmpty()){
						textPanelListener.appendText("Please enter your destination.\n");
					} 
					if (fundField.getText().isEmpty()){
						textPanelListener.appendText("Please enter the amount to pay.\n");
					}
				} else {
					if(destinationField.getText().matches(alphanumericSpace) && fundField.getText().matches(digits)){
						String destination = destinationField.getText();
						double fund = Double.parseDouble(fundField.getText());
						if (detailsListener != null) {
							tc.tryPurchase(destination, fund);
						}
						
						if (textPanelListener != null) {
							textPanelListener.clearText();
							textPanelListener.appendText(tc.printScreen());
						}
					} else {
						textPanelListener.appendText("Invalid inputs. Please try again.\n");
					}
				}	
			}
		});

		this.setBorder(BorderFactory.createTitledBorder("Buy Train Ticket"));

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		// destination
		gc.insets = new Insets(0, 0, 5, 15); // create spaces between grid
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 0;
		gc.gridy = 0;
		add(destinationLabel, gc);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		gc.gridy = 0;
		add(destinationField, gc);

		// fund
		gc.insets = new Insets(0, 0, 50, 15); // create spaces between grid
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 0;
		gc.gridy = 1;
		add(fundLabel, gc);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		gc.gridy = 1;
		add(fundField, gc);
		
		// buy button
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		gc.gridy = 2;
		add(buyButton, gc);
	}

	public DetailsListener getDetailsListener() {
		return detailsListener;
	}
	
	public void setDetailsListener(DetailsListener detailsListener) {
		this.detailsListener = detailsListener;
	}
	
	public TextPanelListener getTextPanelListener() {
		return textPanelListener;
	}
	
	public void setTextPanelListener(TextPanelListener textPanelListener) {
		this.textPanelListener = textPanelListener;
	}
}
