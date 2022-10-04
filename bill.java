import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;

public class bill extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtunit;
	private JTextArea txtprint;
	String cid;
	double charge;
	double gramount;
	int count;
	public void print()
	{
		String cid=txtid.getText();
		String cname=txtname.getText();
		String unit=txtunit.getText();
		txtprint.setText(txtprint.getText() + "\n");
		txtprint.setText(txtprint.getText() + "Electricity billing system" +"\n");
		txtprint.setText(txtprint.getText() + "customer ID:=" + cid+"\n");
		txtprint.setText(txtprint.getText() + "customer name:= " + cname+"\n");
		txtprint.setText(txtprint.getText() + "customer ID:=" + cid+"\n");
		txtprint.setText(txtprint.getText() + "unit:=" + unit+"\n");
		txtprint.setText(txtprint.getText() + "Amount:=" + gramount+"\n");
		txtprint.setText(txtprint.getText() + "thankyou Come again");
		
		
		}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bill frame = new bill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public bill() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(194, 36, 701, 78);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ELECTRICITY BILLING SYSTEM");
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD, 21));
		lblNewLabel.setBounds(117, 11, 640, 56);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CUSTOMER ID");
		lblNewLabel_1.setBounds(127, 220, 136, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CUSTOMER NAME");
		lblNewLabel_2.setBounds(127, 269, 96, 17);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("UNIT");
		lblNewLabel_3.setBounds(127, 329, 96, 17);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("CALCULATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtprint.setText(" ");
				cid=txtid.getText();
				count=Integer.parseInt(txtunit.getText());
				if (count < 500) {
					charge=1.00;
				}
				else if (count >= 500 && count<600) {
					charge=1.80;
				}
				else if (count >= 600 && count<800) {
					charge=2.80;
				}
				else {
					
						charge=3.00;
				}
				gramount=charge *count;
				print();	
				
				
			}
		});
		btnNewButton.setBounds(127, 429, 117, 35);
		contentPane.add(btnNewButton);
		
		txtid = new JTextField();
		txtid.setBounds(298, 217, 198, 23);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtname = new JTextField();
		txtname.setBounds(298, 266, 198, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtunit = new JTextField();
		txtunit.setColumns(10);
		txtunit.setBounds(298, 326, 198, 20);
		contentPane.add(txtunit);
		
		txtprint = new JTextArea();
		txtprint.setBounds(663, 215, 245, 218);
		contentPane.add(txtprint);
		
		JButton btnNewButton_1 = new JButton("PRINT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txtprint.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(761, 478, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
