package smartConverter;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SCSwing {

	private JFrame frame;
	private JTextField broj;
	private JTextField hexadecimal;
	private JTextField binary;
	private JTextField decimal;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SCSwing window = new SCSwing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SCSwing() {
		initialize();
	}

	private boolean checkHex(String hex) {
	    if (hex.length() == 0 || 
	         (hex.charAt(0) != '-' && Character.digit(hex.charAt(0), 16) == -1))
	        return false;
	    if ( hex.length() == 1 && hex.charAt(0) == '-' )
	        return false;
	    for ( int i = 1 ; i < hex.length() ; i++ )
	        if ( Character.digit(hex.charAt(i), 16) == -1 )
	            return false;
	    return true;
	}
	
	private boolean checkBinary(String binary) {
		
		boolean check = true;
		
		for(int i = 0; i< binary.length(); i++) {
			if(binary.charAt(i) == '0' || binary.charAt(i) == '1') {
				check = true;
			}else {
				check = false;
				break;
			}
		}
		return check;
	}
	
	private boolean checkDecimal(String decimal) {

		boolean check = true;
		
		for(int i = 0; i< decimal.length(); i++) {
			if(decimal.charAt(i) == '0' || decimal.charAt(i) == '1' || decimal.charAt(i) == '2' || decimal.charAt(i) == '3' || decimal.charAt(i) == '4' 
			|| decimal.charAt(i) == '5'|| decimal.charAt(i) == '6' || decimal.charAt(i) == '7' || decimal.charAt(i) == '8' || decimal.charAt(i) == '9') {
				check = true;
			}else {
				check = false;
				break;
			}
		}
		return check;
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox padMen = new JComboBox();
		padMen.setModel(new DefaultComboBoxModel(new String[] {"Hexadecimal", "Binary", "Decimal"}));
		padMen.setToolTipText("");
		padMen.setBounds(10, 11, 314, 29);
		frame.getContentPane().add(padMen);
		
		JLabel lblNewLabel = new JLabel("Enter number for conversion:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 54, 180, 14);
		frame.getContentPane().add(lblNewLabel);
		
		broj = new JTextField();
		broj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(padMen.getSelectedIndex() == 0) {
					
					if(checkHex(broj.getText()) == true) {
					
					hexadecimal.setText(broj.getText());
					
					String hexbr = broj.getText();
					int dec = Integer.parseInt(hexbr, 16);
					String decimalni = Integer.toString(dec);
					
					decimal.setText(decimalni);
					
					String binarni = Integer.toBinaryString(dec);
					
					binary.setText(binarni);
					
					}else{
						JOptionPane.showMessageDialog(null, "VREDNOST NIJE VALIDNA!", "GRESKA", JOptionPane.PLAIN_MESSAGE);
					}
					
				}else if (padMen.getSelectedIndex() == 1) {
					if(checkBinary(broj.getText()) == true) {
						
						binary.setText(broj.getText());
						
						String binarni = broj.getText();
						int dec = Integer.parseInt(binarni, 2);
						String decimalni = Integer.toString(dec);
						
						decimal.setText(decimalni);
						
						String heksadecimalni = Integer.toHexString(dec);
						hexadecimal.setText(heksadecimalni);	
					}else {
						JOptionPane.showMessageDialog(null, "VREDNOST NIJE VALIDNA!", "GRESKA", JOptionPane.PLAIN_MESSAGE);
					}
					
				}else if(padMen.getSelectedIndex() == 2) {
					if(checkDecimal(broj.getText()) == true) {
						
						String decimalni = broj.getText();
						decimal.setText(broj.getText());
						
						int bin = Integer.parseInt(decimalni,10);
						String binarni = Integer.toBinaryString(bin);
						binary.setText(binarni);
						
						String heksadecimalni = Integer.toHexString(bin);
						hexadecimal.setText(heksadecimalni);
						
					}else{
						JOptionPane.showMessageDialog(null, "VREDNOST NIJE VALIDNA!", "GRESKA", JOptionPane.PLAIN_MESSAGE);
					}
				}
				
			}
		});
		broj.setBounds(200, 52, 124, 20);
		frame.getContentPane().add(broj);
		broj.setColumns(10);
		
		hexadecimal = new JTextField();
		hexadecimal.setEditable(false);
		hexadecimal.setText("Hexadecimal");
		hexadecimal.setBounds(10, 97, 314, 20);
		frame.getContentPane().add(hexadecimal);
		hexadecimal.setColumns(10);
		
		binary = new JTextField();
		binary.setText("Binary");
		binary.setEditable(false);
		binary.setColumns(10);
		binary.setBounds(10, 128, 314, 20);
		frame.getContentPane().add(binary);
		
		decimal = new JTextField();
		decimal.setText("Decimal");
		decimal.setEditable(false);
		decimal.setColumns(10);
		decimal.setBounds(10, 159, 314, 20);
		frame.getContentPane().add(decimal);
		
		}
	}

