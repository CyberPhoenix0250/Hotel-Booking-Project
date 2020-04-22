package source;

import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

class FinalProblem 
{
	private static JFrame window;
	FinalProblem(String id)
	{
		window = new JFrame("Booking Successful");
		window.getContentPane().setLayout(null);
		window.setVisible(true);
		window.setBounds(250, 200, 800, 600);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblThankYou = new JLabel("Thank You");
		lblThankYou.setFont(new Font("Kunstler Script", Font.PLAIN, 80));
		lblThankYou.setForeground(new Color(255, 255, 255));
		lblThankYou.setBounds(244, 371, 296, 107);
		window.getContentPane().add(lblThankYou);
		
		JLabel lblPleaseShowThis = new JLabel("Please Show this SMS on the Hotel Reception");
		lblPleaseShowThis.setForeground(Color.WHITE);
		lblPleaseShowThis.setFont(new Font("Gabriola", Font.PLAIN, 30));
		lblPleaseShowThis.setBounds(182, 318, 419, 42);
		window.getContentPane().add(lblPleaseShowThis);
		
		JLabel lblYouWillRecieve = new JLabel("You will Recieve a Confirmation SMS on Your Phone Number Shortly");
		lblYouWillRecieve.setFont(new Font("Gabriola", Font.PLAIN, 30));
		lblYouWillRecieve.setForeground(Color.WHITE);
		lblYouWillRecieve.setBounds(73, 247, 638, 52);
		window.getContentPane().add(lblYouWillRecieve);
		
		JLabel lblYourHotelHas = new JLabel("Your Hotel has been Booked Succesfully");
		lblYourHotelHas.setForeground(Color.WHITE);
		lblYourHotelHas.setFont(new Font("Gabriola", Font.PLAIN, 40));
		lblYourHotelHas.setBounds(145, 188, 493, 42);
		window.getContentPane().add(lblYourHotelHas);
		
		JLabel lblYourCustomerId = new JLabel("Your Customer ID :   "+id);
		lblYourCustomerId.setForeground(Color.WHITE);
		lblYourCustomerId.setFont(new Font("Californian FB", Font.PLAIN, 30));
		lblYourCustomerId.setBounds(131, 90, 470, 87);
		window.getContentPane().add(lblYourCustomerId);
		
		JLabel lblBooked = new JLabel("Your Booking is Done");
		lblBooked.setFont(new Font("Goudy Old Style", Font.PLAIN, 45));
		lblBooked.setForeground(Color.WHITE);
		lblBooked.setBounds(211, 11, 362, 68);
		window.getContentPane().add(lblBooked);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FinalProblem.class.getResource("/Resources/Back800x600.jpg")));
		label.setBounds(0, 0, 784, 562);
		window.getContentPane().add(label);
	}
}