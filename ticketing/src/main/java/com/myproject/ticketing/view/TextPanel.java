package com.myproject.ticketing.view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class TextPanel extends JPanel {
	private JTextArea textArea;

	public TextPanel() {

		this.setLayout(new BorderLayout());
		this.textArea = new JTextArea();
		this.add(textArea, BorderLayout.CENTER);
		this.setBorder(BorderFactory.createTitledBorder("Screen"));

		JScrollPane scroll = new JScrollPane(textArea);
		this.add(scroll, BorderLayout.CENTER);
		this.textArea.setEditable(false);
	}

	public void appendText(String text) {
		this.textArea.append(text);
	}

	public void clearText() {
		this.textArea.setText("");
	}
}
