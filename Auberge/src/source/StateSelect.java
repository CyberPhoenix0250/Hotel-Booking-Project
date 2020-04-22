package source;

import java.awt.SystemColor;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
import java.sql.*;

class StateSelect
{
	private static JFrame window = new JFrame("AUBERGE Online Hotel Booking");
	private static JLabel BackImage = new JLabel();
	public static JComboBox combo1 = new JComboBox();
	StateSelect()
	{
		window.setSize(1000, 800);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(140, 100);
		window.getContentPane().setLayout(null);
		
		JButton NextButton = new JButton("NEXT");
		NextButton.setFont(new Font("Microsoft JhengHei", Font.BOLD, 15));
		NextButton.setBounds(442, 490, 98, 38);
		window.getContentPane().add(NextButton);
		NextButton.addActionListener(new NextHandler());
		
		combo1.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		combo1.setBounds(409, 353, 165, 32);
		window.getContentPane().add(combo1);
		combo1.addItem("Arizona");
		combo1.addItem("California");
		combo1.addItem("Texas");
		combo1.addItem("New York");
		combo1.addItem("Washington");
		
		JLabel statelabel = new JLabel("Select Your State");
		statelabel.setFont(new Font("Lucida Calligraphy", Font.BOLD, 38));
		statelabel.setBounds(302, 220, 389, 92);
		window.getContentPane().add(statelabel);
		
		BackImage.setBounds(0, 0, 984, 762);
		BackImage.setIcon(new ImageIcon(StateSelect.class.getResource("/Resources/backimage.jpg")));
		window.getContentPane().add(BackImage);
		ImageIcon img = new ImageIcon(StateSelect.class.getResource("/Resources/Icon.png"));
		window.setIconImage(img.getImage());
		window.setVisible(true);
	}
	class NextHandler implements ActionListener
	{
		String name;
		public void actionPerformed(ActionEvent ae)
		{
			switch(combo1.getSelectedIndex())
			{
			case 0 : name = "Arizona";break;
			case 1 : name = "California";break;
			case 2 : name = "Texas"; break;
			case 3 : name = "New York"; break;
			case 4 : name = "Washington"; break;
			}
			window.setVisible(false);
			SearchHotel sh = new SearchHotel(name);
		}
	}
}