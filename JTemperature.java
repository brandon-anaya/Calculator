// Name: Anaya, Brandon
// Project: Temperature Converter
// Due: 9/17/21
// Course: CS-  2450  -01-  F21 
// Description: 
// 				A Temperature Converter that takes input from user and converts to celsius 
//

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import java.text.DecimalFormat;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

class JTemperature {
	JPanel contentPane;
	JTextField textField2;
	JTextField textField;
	JLabel jTextField;

	JTemperature() {
		 
		 //create the frame
		 JFrame jfrm = new JFrame("Temperature Converter");
		 jfrm.setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			jfrm.setContentPane(contentPane);
			
			JPanel panel = new JPanel();
			contentPane.add(panel, BorderLayout.NORTH);
			
			JLayeredPane layeredPane = new JLayeredPane();
			contentPane.add(layeredPane, BorderLayout.CENTER);
			
			JLabel lblNewLabel = new JLabel("Enter");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(55, 85, 61, 16);
			layeredPane.add(lblNewLabel);
			
			JLabel lblDegreesF = new JLabel("Degrees F");
			lblDegreesF.setHorizontalAlignment(SwingConstants.CENTER);
			lblDegreesF.setBounds(301, 85, 90, 16);
			layeredPane.add(lblDegreesF);
			
			JLabel lblDegreesC = new JLabel("Degrees C");
			lblDegreesC.setHorizontalAlignment(SwingConstants.CENTER);
			lblDegreesC.setBounds(301, 113, 90, 16);
			layeredPane.add(lblDegreesC);
			
			JTextField textField2 = new JTextField();
			textField2.setEditable(false);
			
			textField2.setColumns(10);
			textField2.setBounds(259, 108, 52, 26);
			layeredPane.add(textField2);
			
			JLabel lblDegreesF_1_1 = new JLabel("=");
			lblDegreesF_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblDegreesF_1_1.setBounds(200, 113, 90, 16);
			layeredPane.add(lblDegreesF_1_1);
			
			JTextField textField = new JTextField();
			textField.addKeyListener(new KeyAdapter() {
			
				public void keyPressed(KeyEvent Enter) {
					 // To hold the temperatures
					double ftemp, ctemp; 

			         // Create a DecimalFormat object to format numbers.
			         DecimalFormat formatter = new DecimalFormat("0.0");

			         // Get the Fahrenheit temperature and convert it
			         // to a double.
			         ftemp = Double.parseDouble(textField.getText());

			         // Calculate the Celsius temperature.
			         ctemp = 5.0/9.0 * (ftemp - 32);

			         // Display the Celsius temperature.
			         textField2.setText(formatter.format(ctemp));
				}
			});
			
			textField.setBounds(110, 80, 201, 26);
			layeredPane.add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("by B. Anaya");
			lblNewLabel_1.setBounds(187, 6, 104, 16);
			layeredPane.add(lblNewLabel_1);
			
			jfrm.setVisible(true);
		}		 
		 
		 
	 // Launch the program
	 public static void main(String args[]) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new JTemperature();
				}
			});
		}
}