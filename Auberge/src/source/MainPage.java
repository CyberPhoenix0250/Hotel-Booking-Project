//This part of the program is responsible for printing the first page of the application
//after this page there will be a redirection to the database connectivity.
package source;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

class MainPage
{
	private static JFrame window = new JFrame("AUBERGE  Online Hotel Booking");
	private static JButton bookhotel = new JButton("BOOK HOTEL");
	public MainPage()
	{
		window.setSize(1000, 800);
		window.getContentPane().setLayout(null);
		JLabel BackImage = new JLabel();
		
		JLabel lblOnlineHotelBooking = new JLabel("Online Hotel Booking");
		lblOnlineHotelBooking.setForeground(Color.WHITE);
		lblOnlineHotelBooking.setFont(new Font("Colonna MT", Font.PLAIN, 40));
		lblOnlineHotelBooking.setBounds(310, 103, 364, 53);
		window.getContentPane().add(lblOnlineHotelBooking);
		bookhotel.setBounds(388, 676, 207, 53);
		window.getContentPane().add(bookhotel);
		bookhotel.addActionListener(new BookButtonHandler());
		
		JLabel lblAuberge = new JLabel("AUBERGE");
		lblAuberge.setForeground(Color.WHITE);
		lblAuberge.setFont(new Font("Goudy Old Style", Font.PLAIN, 60));
		lblAuberge.setBounds(351, 11, 282, 69);
		window.getContentPane().add(lblAuberge);
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon(MainPage.class.getResource("/Resources/hotel.png")));
		logo.setBounds(236, 144, 512, 543);
		window.getContentPane().add(logo);
		BackImage.setForeground(SystemColor.activeCaption);
		ImageIcon img = new ImageIcon(MainPage.class.getResource("/Resources/Icon.png"));
		window.setIconImage(img.getImage());
		window.setResizable(false);
		BackImage.setIcon(new ImageIcon(MainPage.class.getResource("/Resources/backimage.jpg")));
		BackImage.setBounds(0, 0, 984, 762);
		window.getContentPane().add(BackImage);
		window.setLocation(140, 100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	class BookButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			window.setVisible(false);
			Database cd = new Database();
			cd.Connect();
		}
	}
	public static void main(String args[])
	{
		MainPage main = new MainPage();
	}
}