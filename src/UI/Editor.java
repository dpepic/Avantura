package UI;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Editor {

	private JFrame frame;
	private JTextField txtNaslov;
	private JTextField txtOpis;
	private String[][] opisi = new String[25][3];
	private int prosloDugme = 0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editor window = new Editor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Editor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 604, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 427, 361);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(5, 5, 5, 5));
		
		txtNaslov = new JTextField();
		txtNaslov.setBounds(450, 106, 128, 20);
		frame.getContentPane().add(txtNaslov);
		txtNaslov.setColumns(10);
		
		txtOpis = new JTextField();
		txtOpis.setBounds(447, 154, 131, 20);
		frame.getContentPane().add(txtOpis);
		txtOpis.setColumns(10);
		
		JLabel lblKoje = new JLabel("Editujemo sobu broj 0");
		lblKoje.setBounds(450, 66, 128, 14);
		frame.getContentPane().add(lblKoje);
		
		for (int i = 0; i < 25; i++)
		{
			JToggleButton but = new JToggleButton(String.valueOf(i));
			but.setActionCommand(String.valueOf(i));
			but.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					if (but.isSelected())
					{
						opisi[prosloDugme][0] = txtNaslov.getText();
						opisi[prosloDugme][1] = txtOpis.getText();
						prosloDugme = Integer.parseInt(but.getActionCommand());
						lblKoje.setText("Editujemo sobu broj " + but.getActionCommand());
						txtNaslov.setText(opisi[Integer.parseInt(but.getActionCommand())][0]);
						txtOpis.setText(opisi[Integer.parseInt(but.getActionCommand())][1]);
					}
				}
			});
			panel.add(but);
		}
		
		JButton btnUcitaj = new JButton("Ucitaj");
		btnUcitaj.setBounds(10, 395, 89, 23);
		frame.getContentPane().add(btnUcitaj);
		
		JButton btnSnimi = new JButton("Snimi");
		btnSnimi.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					BufferedWriter bw = new BufferedWriter(new FileWriter("sobe.txt"));
					for (Component comp: panel.getComponents())
					{
						JToggleButton dug = (JToggleButton)comp;
						if (dug.isSelected())
						{
							int broj = Integer.parseInt(dug.getActionCommand());
							bw.write(opisi[broj][0]);
							bw.newLine();
							bw.write(opisi[broj][1]);
							bw.newLine();
							String izlazi = "";
							if (broj - 5 >= 0)
							{
								if (((JToggleButton)panel.getComponent(broj - 5)).isSelected())
								{
									izlazi += "sever+" + (broj - 5) + "+";
								}
							}
							if (broj + 5 <= 25)
							{
								if (((JToggleButton)panel.getComponent(broj+5)).isSelected())
								{
									izlazi += "jug+" + (broj + 5) + "+";
								}
							}
							if (broj - 1 >= 0)
							{
								if (((JToggleButton)panel.getComponent(broj - 1)).isSelected())
								{
									izlazi += "zapad+" + (broj - 1) + "+";
								}
							}
							if (broj + 1 <= 25)
							{
								if (((JToggleButton)panel.getComponent(broj + 1)).isSelected())
								{
									izlazi += "istok+" + (broj + 1) + "+";
								}
							}
							bw.write(izlazi);
							bw.newLine();
						}
					}
					
					
					bw.close();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		});
		btnSnimi.setBounds(348, 395, 89, 23);
		frame.getContentPane().add(btnSnimi);
	}
}
