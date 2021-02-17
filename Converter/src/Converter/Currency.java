package Converter;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Currency extends JFrame {

	private JPanel contentPane;
	private JTextField FirstCurrency;
	private JTextField SecondCurrency;
	private JFrame frame;

	private String[] CurrencyLeft = { "₦", "$", "£", "€" };
	private String[] CurrencyRight = { "$", "₦", "£", "€" };

	static double dollar;
	static double naira;
	static double pounds;
	static double euro;
	static double userInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Currency frame = new Currency();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public Currency() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {

		setBounds(100, 100, 450, 300);
		setTitle("Currency Converter-by Dinixweb");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

		FirstCurrency = new JTextField();
		FirstCurrency.setForeground(new Color(0, 0, 0));
		FirstCurrency.setBackground(new Color(245, 245, 245));
		FirstCurrency.setBounds(49, 106, 71, 45);
		contentPane.add(FirstCurrency);
		FirstCurrency.setColumns(10);

		JComboBox CurrencyF = new JComboBox(CurrencyLeft);
		CurrencyF.setBackground(new Color(255, 255, 255));
		CurrencyF.setBounds(119, 106, 66, 45);
		contentPane.add(CurrencyF);

		SecondCurrency = new JTextField();
		SecondCurrency.setEditable(false);
		SecondCurrency.setBackground(new Color(220, 220, 220));
		SecondCurrency.setColumns(10);
		SecondCurrency.setBounds(307, 106, 103, 45);
		contentPane.add(SecondCurrency);

		JComboBox CurrencyS = new JComboBox(CurrencyRight);
		CurrencyS.setBackground(new Color(255, 255, 255));
		CurrencyS.setBounds(229, 106, 66, 45);
		contentPane.add(CurrencyS);

		JButton convertButton = new JButton("Convert");
		convertButton.setBackground(new Color(255, 140, 0));
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userInput = FirstCurrency.getText();

				String currencyType = (String) CurrencyF.getSelectedItem();
				String currencyOut = (String) CurrencyS.getSelectedItem();
				String outPut = SecondCurrency.getText();
				String Display;

				// Condition for Naira to other currency
				if (currencyType.equals("₦") && currencyOut.equals("$")) {

					Double userInput2 = Double.parseDouble(FirstCurrency.getText());

					if (userInput2 % 395 == 0) {
						Double Results = userInput2 / 395;
						Display = String.format("%.1f", Results);
						SecondCurrency.setText(Display);

					} else {
						Double Results = userInput2 / 395;
						Display = String.format("%.3f", Results);
						SecondCurrency.setText(Display);

					}
				} else if (currencyType.equals("$") && currencyOut.equals("₦")) {

					Double userInput2 = Double.parseDouble(FirstCurrency.getText());
					Double Results = userInput2 * 395;
					Display = String.format("%.2f", Results);
					SecondCurrency.setText(Display);

				} else if (currencyType.equals("₦") && currencyOut.equals("£")) {

					Double userInput2 = Double.parseDouble(FirstCurrency.getText());

					if (userInput2 % 529.64 == 0) {
						Double Results = userInput2 / 529.64;
						Display = String.format("%.1f", Results);
						SecondCurrency.setText(Display);
					} else {
						Double Results = userInput2 / 529.64;
						Display = String.format("%.5f", Results);
						SecondCurrency.setText(Display);
					}

				} else if (currencyType.equals("£") && currencyOut.equals("₦")) {

					Double userInput2 = Double.parseDouble(FirstCurrency.getText());
					Double Results = userInput2 * 529.64;
					Display = String.format("%.2f", Results);
					SecondCurrency.setText(Display);

				} else if (currencyType.equals("₦") && currencyOut.equals("€")) {

					Double userInput2 = Double.parseDouble(FirstCurrency.getText());

					if (userInput2 % 460.21 == 0) {
						Double Results = userInput2 / 460.21;
						Display = String.format("%.1f", Results);
						SecondCurrency.setText(Display);
					} else {
						Double Results = userInput2 / 460.21;
						Display = String.format("%.5f", Results);
						SecondCurrency.setText(Display);
					}

				} else if (currencyType.equals("€") && currencyOut.equals("₦")) {

					Double userInput2 = Double.parseDouble(FirstCurrency.getText());
					Double Results = userInput2 * 460.21;
					Display = String.format("%.2f", Results);
					SecondCurrency.setText(Display);

				}

				// Condition for Dollar to other currency {"$", "₦", "£", "€"}

				if (currencyType.equals("$") && currencyOut.equals("€")) {

					Double userInput2 = Double.parseDouble(FirstCurrency.getText());
					
					if( userInput2 % 1.21==0) {
					Double Results = userInput2 / 1.21;
					Display = String.format("%.1f", Results);
					SecondCurrency.setText(Display);
					}
					else {
						Double Results = userInput2 / 1.21;
						Display = String.format("%.3f", Results);
						SecondCurrency.setText(Display);
					}

				} else if (currencyType.equals("€") && currencyOut.equals("$")) {

					Double userInput2 = Double.parseDouble(FirstCurrency.getText());
					Double Results = userInput2 * 1.21;
					Display = String.format("%.2f", Results);
					SecondCurrency.setText(Display);

				} else if (currencyType.equals("$") && currencyOut.equals("£")) {

					Double userInput2 = Double.parseDouble(FirstCurrency.getText());
					
					if (userInput2 % 1.39==0) {
					Double Results = userInput2 / 1.39;
					Display = String.format("%.1f", Results);
					SecondCurrency.setText(Display);
					}
					else {
						Double Results = userInput2 / 1.39;
						Display = String.format("%.3f", Results);
						SecondCurrency.setText(Display);
						}
					

				} else if (currencyType.equals("£") && currencyOut.equals("$")) {

					Double userInput2 = Double.parseDouble(FirstCurrency.getText());
					Double Results = userInput2 * 1.39;
					Display = String.format("%.2f", Results);
					SecondCurrency.setText(Display);

				}

				// Condition for Euro to Other Currency {"$", "₦", "£", "€"}

				if (currencyType.equals("€") && currencyOut.equals("£")) {

					Double userInput2 = Double.parseDouble(FirstCurrency.getText());
					
					if (userInput2 % 1.15==0) {
					Double Results = userInput2 / 1.15;
					Display = String.format("%.1f", Results);
					SecondCurrency.setText(Display);
					}
					else {
						Double Results = userInput2 / 1.15;
						Display = String.format("%.3f", Results);
						SecondCurrency.setText(Display);
						
					}

				} else if (currencyType.equals("£") && currencyOut.equals("€")) {

					Double userInput2 = Double.parseDouble(FirstCurrency.getText());
					Double Results = userInput2 * 1.15;
					Display = String.format("%.2f", Results);
					SecondCurrency.setText(Display);

				}

			}
		});
		convertButton.setBounds(158, 176, 103, 36);
		contentPane.add(convertButton);

		JLabel lblNewLabel = new JLabel("CURRENCY CONVERTER");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 17));
		lblNewLabel.setBounds(123, 55, 200, 26);
		contentPane.add(lblNewLabel);

		JLabel to = new JLabel("TO");
		to.setFont(new Font("SansSerif", Font.PLAIN, 17));
		to.setBounds(197, 120, 22, 16);
		contentPane.add(to);

	}

}
