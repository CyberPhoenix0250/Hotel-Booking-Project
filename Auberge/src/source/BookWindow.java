package source;

import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import source.Database;
import java.util.Date;

class BookWindow extends Database
{
	private static JFrame window;
	private static String HotelId;
	private int[] FacilityBit;
	private Date InDate,OutDate;
	BookWindow(String id,Date inDate,Date outDate)
	{
		InDate = inDate;
		OutDate = outDate;
		HotelId = id;
		window = new JFrame("BOOKING");
		window.setBounds(140, 100, 1000, 800);
		window.getContentPane().setLayout(null);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
		ImageIcon img = new ImageIcon(BookWindow.class.getResource("/Resources/Icon.png"));
		window.setIconImage(img.getImage());
		
		JLabel lblRestaurant = new JLabel("Restaurant");
		lblRestaurant.setForeground(Color.WHITE);
		lblRestaurant.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		lblRestaurant.setBounds(575, 595, 287, 50);
		window.getContentPane().add(lblRestaurant);
		
		JLabel label = new JLabel("Pet Friendly");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		label.setBounds(575, 522, 287, 50);
		window.getContentPane().add(label);
		
		JLabel lblPetFriendly = new JLabel("Spa");
		lblPetFriendly.setForeground(Color.WHITE);
		lblPetFriendly.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		lblPetFriendly.setBounds(575, 452, 287, 50);
		window.getContentPane().add(lblPetFriendly);
		
		JLabel lblPool = new JLabel("Pool");
		lblPool.setForeground(Color.WHITE);
		lblPool.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		lblPool.setBounds(575, 378, 287, 50);
		window.getContentPane().add(lblPool);
		
		JLabel lblCarPark = new JLabel("Car Park");
		lblCarPark.setForeground(Color.WHITE);
		lblCarPark.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		lblCarPark.setBounds(575, 301, 287, 50);
		window.getContentPane().add(lblCarPark);
		
		JLabel lblAirConditioning = new JLabel("Air Conditioning");
		lblAirConditioning.setForeground(Color.WHITE);
		lblAirConditioning.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		lblAirConditioning.setBounds(575, 228, 287, 50);
		window.getContentPane().add(lblAirConditioning);
		
		JLabel lblFreeWifi = new JLabel("Free WiFi");
		lblFreeWifi.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		lblFreeWifi.setForeground(Color.WHITE);
		lblFreeWifi.setBounds(575, 167, 287, 50);
		window.getContentPane().add(lblFreeWifi);
		
		JLabel FImg6 = new JLabel("");
		FImg6.setBounds(502, 522, 50, 50);
		window.getContentPane().add(FImg6);
		
		JLabel FImg5 = new JLabel("");
		FImg5.setBounds(502, 452, 50, 50);
		window.getContentPane().add(FImg5);
		
		JLabel FImg4 = new JLabel("");
		FImg4.setBounds(502, 378, 50, 50);
		window.getContentPane().add(FImg4);
		
		JLabel FImg3 = new JLabel("");
		FImg3.setBounds(502, 301, 50, 50);
		window.getContentPane().add(FImg3);
		
		JLabel FImg2 = new JLabel("");
		FImg2.setBounds(502, 228, 50, 50);
		window.getContentPane().add(FImg2);
		
		JLabel FImg7 = new JLabel("");
		FImg7.setBounds(502, 595, 50, 50);
		window.getContentPane().add(FImg7);
		
		JLabel FImg1 = new JLabel("");
		FImg1.setBounds(502, 167, 50, 50);
		window.getContentPane().add(FImg1);
		
		FacilityBit = getFacility(HotelId);
		if(FacilityBit[0] == 1)
		{
			FImg1.setIcon(new ImageIcon(BookWindow.class.getResource("/Resources/Right.png")));
		}else
		{
			FImg1.setIcon(new ImageIcon(BookWindow.class.getResource("/Resources/wrong.png")));
		}
		
		if(FacilityBit[1] == 1)
		{
			FImg2.setIcon(new ImageIcon(BookWindow.class.getResource("/Resources/Right.png")));
		}else
		{
			FImg2.setIcon(new ImageIcon(BookWindow.class.getResource("/Resources/wrong.png")));
		}
		
		if(FacilityBit[2] == 1)
		{
			FImg3.setIcon(new ImageIcon(BookWindow.class.getResource("/Resources/Right.png")));
		}else
		{
			FImg3.setIcon(new ImageIcon(BookWindow.class.getResource("/Resources/wrong.png")));
		}
		
		if(FacilityBit[3] == 1)
		{
			FImg4.setIcon(new ImageIcon(BookWindow.class.getResource("/Resources/Right.png")));
		}else
		{
			FImg4.setIcon(new ImageIcon(BookWindow.class.getResource("/Resources/wrong.png")));
		}
		
		if(FacilityBit[4] == 1)
		{
			FImg5.setIcon(new ImageIcon(BookWindow.class.getResource("/Resources/Right.png")));
		}else
		{
			FImg5.setIcon(new ImageIcon(BookWindow.class.getResource("/Resources/wrong.png")));
		}
		
		if(FacilityBit[5] == 1)
		{
			FImg6.setIcon(new ImageIcon(BookWindow.class.getResource("/Resources/Right.png")));
		}else
		{
			FImg6.setIcon(new ImageIcon(BookWindow.class.getResource("/Resources/wrong.png")));
		}
		
		if(FacilityBit[6] == 1)
		{
			FImg7.setIcon(new ImageIcon(BookWindow.class.getResource("/Resources/Right.png")));
		}else
		{
			FImg7.setIcon(new ImageIcon(BookWindow.class.getResource("/Resources/wrong.png")));
		}
		
		JLabel lblFamilyRoom = new JLabel("Family Room : $ "+getFRPrice(HotelId)+".00");
		lblFamilyRoom.setForeground(Color.WHITE);
		lblFamilyRoom.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		lblFamilyRoom.setBounds(20, 522, 458, 38);
		window.getContentPane().add(lblFamilyRoom);
		
		JLabel lblDoubleRoom = new JLabel("Double Room : $ "+getDRPrice(HotelId)+".00");
		lblDoubleRoom.setForeground(Color.WHITE);
		lblDoubleRoom.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		lblDoubleRoom.setBounds(20, 464, 458, 38);
		window.getContentPane().add(lblDoubleRoom);
		
		JLabel lblSingleRoom = new JLabel("Single Room : $ "+getSRPrice(HotelId)+".00");
		lblSingleRoom.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		lblSingleRoom.setForeground(Color.WHITE);
		lblSingleRoom.setBounds(20, 404, 458, 38);
		window.getContentPane().add(lblSingleRoom);
		
		JLabel lblPriceusd = new JLabel("PRICE (USD)");
		lblPriceusd.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		lblPriceusd.setForeground(Color.WHITE);
		lblPriceusd.setBounds(20, 343, 458, 38);
		window.getContentPane().add(lblPriceusd);
		
		JLabel HotelID = new JLabel("HOTEL ID : "+HotelId);
		HotelID.setForeground(Color.WHITE);
		HotelID.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		HotelID.setBounds(20, 261, 458, 38);
		window.getContentPane().add(HotelID);
		
		JLabel AddressField = new JLabel(getHotelAddress(HotelId));
		AddressField.setForeground(Color.WHITE);
		AddressField.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		AddressField.setBounds(165, 107, 809, 49);
		window.getContentPane().add(AddressField);
		
		JLabel lblAddress = new JLabel("ADDRESS :");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		lblAddress.setBounds(20, 106, 146, 49);
		window.getContentPane().add(lblAddress);
		
		JLabel lblState = new JLabel("STATE : "+getHotelState(HotelId));
		lblState.setForeground(Color.WHITE);
		lblState.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		lblState.setBounds(20, 185, 458, 38);
		window.getContentPane().add(lblState);
		
		JLabel StarImage = new JLabel("");
		StarImage.setBounds(624, 28, 350, 55);
		window.getContentPane().add(StarImage);
		StarImage.setHorizontalAlignment(JLabel.RIGHT);
		switch(getRating(HotelId))
		{
		case 1 : StarImage.setIcon(new ImageIcon(BookWindow.class.getResource("/Resources/1-star.png"))); break;
		case 2 : StarImage.setIcon(new ImageIcon(BookWindow.class.getResource("/Resources/2-star.png"))); break;
		case 3 : StarImage.setIcon(new ImageIcon(BookWindow.class.getResource("/Resources/3-star.png"))); break;
		case 4 : StarImage.setIcon(new ImageIcon(BookWindow.class.getResource("/Resources/4-star.png"))); break;
		case 5 : StarImage.setIcon(new ImageIcon(BookWindow.class.getResource("/Resources/5-star.png"))); break;
		}
		
		JLabel HotelName = new JLabel(getHotelName(HotelId));
		HotelName.setForeground(Color.WHITE);
		HotelName.setFont(new Font("Goudy Old Style", Font.PLAIN, 35));
		HotelName.setBounds(98, 39, 516, 38);
		window.getContentPane().add(HotelName);
		
		JLabel HotelImg = new JLabel("");
		HotelImg.setBounds(10, 11, 78, 74);
		window.getContentPane().add(HotelImg);
		HotelImg.setIcon(new ImageIcon(BookWindow.class.getResource("/Resources/HotelImg.png")));
		
		JSeparator VDivider = new JSeparator();
		VDivider.setForeground(Color.WHITE);
		VDivider.setOrientation(SwingConstants.VERTICAL);
		VDivider.setBounds(488, 167, 8, 517);
		window.getContentPane().add(VDivider);
		
		JButton BookButton = new JButton("BOOK");
		BookButton.setFont(new Font("Gabriola", Font.BOLD, 35));
		BookButton.setBounds(395, 695, 193, 49);
		window.getContentPane().add(BookButton);
		BookButton.addActionListener(new BookButtonHandler());
		
		JSeparator HDivider = new JSeparator();
		HDivider.setForeground(Color.WHITE);
		HDivider.setBounds(10, 94, 964, 10);
		window.getContentPane().add(HDivider);
		
		JLabel BackImage = new JLabel("");
		BackImage.setFont(new Font("Goudy Old Style", Font.PLAIN, 16));
		BackImage.setIcon(new ImageIcon(BookWindow.class.getResource("/Resources/backimage.jpg")));
		BackImage.setBounds(0, 0, 984, 762);
		window.getContentPane().add(BackImage);
		
	}
	class BookButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			new CustomerDetails(HotelId,InDate,OutDate);
			window.setVisible(false);
		}
		
	}
	private String getHotelName(String id)
	{
		String HotelName=null;
		try
		{
			result = statement.executeQuery("SELECT HotelName FROM Hotel WHERE HotelId = '"+id+"'");
			result.first();
			HotelName = result.getString(1);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return HotelName;
	}
	private String getHotelAddress(String id)
	{
		String HotelAddress=null;
		try
		{
			result = statement.executeQuery("SELECT Address FROM Hotel WHERE HotelId = '"+id+"'");
			result.first();
			HotelAddress = result.getString(1);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return HotelAddress;
	}
	private String getHotelState(String id)
	{
		String HotelState=null;
		try
		{
			result = statement.executeQuery("SELECT StateName FROM Hotel WHERE HotelId = '"+id+"'");
			result.first();
			HotelState = result.getString(1);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return HotelState;
	}
	private int getSRPrice(String id)
	{
		int price=0;
		try
		{
			result = statement.executeQuery("SELECT SPrice FROM Price WHERE HID = '"+id+"'");
			result.first();
			price = result.getInt(1);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return price;
	}
	private int getDRPrice(String id)
	{
		int price=0;
		try
		{
			result = statement.executeQuery("SELECT DPrice FROM Price WHERE HID = '"+id+"'");
			result.first();
			price = result.getInt(1);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return price;
	}
	private int getFRPrice(String id)
	{
		int price=0;
		try
		{
			result = statement.executeQuery("SELECT FPrice FROM Price WHERE HID = '"+id+"'");
			result.first();
			price = result.getInt(1);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return price;
	}
	private int getRating(String id)
	{
		int rating = 0;
		try
		{
			result = statement.executeQuery("SELECT StarRating FROM Hotel WHERE HotelId = '"+id+"'");
			result.first();
			rating = result.getInt(1);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return rating;
	}
	private int[] getFacility(String id)
	{
		int list[] = new int[7];
		try
		{
			result = statement.executeQuery("SELECT FreeWifi,AirConditioning,CarPark,Pool,Spa,PetFriendly,Restaurant FROM Facility WHERE HID = '"+id+"'");
			result.first();
			list[0] = result.getInt(1);
			list[1] = result.getInt(2);
			list[2] = result.getInt(3);
			list[3] = result.getInt(4);
			list[4] = result.getInt(5);
			list[5] = result.getInt(6);
			list[6] = result.getInt(7);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}
}