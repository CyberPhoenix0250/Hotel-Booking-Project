package source;

import java.awt.event.*;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.*;
import source.Database;
import java.awt.Color;
import java.awt.Font;
import java.util.Date;

class CustomerDetails extends Database
{
	private static JFrame window;
	private JTextField NameField;
	private JTextField AgeField;
	private JTextField PhoneField;
	private Date CheckInDate;
	private Date CheckOutDate;
	private static String id;
	private static JComboBox RoomBox;
	private static JLabel Rate;
	private static JComboBox GenBox;
	private static JOptionPane jp = new JOptionPane();

	CustomerDetails(String HotelId, Date InDate, Date OutDate)
	{
		id = HotelId;
		CheckInDate = InDate;
		CheckOutDate = OutDate;
		window = new JFrame("Customer Details");
		window.setBounds(250, 200, 800, 600);
		window.getContentPane().setLayout(null);

		Rate = new JLabel("");
		Rate.setForeground(Color.WHITE);
		Rate.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		Rate.setBounds(253, 348, 100, 28);
		window.getContentPane().add(Rate);

		JLabel lblInclusiveOfAll = new JLabel("*Inclusive of all taxes");
		lblInclusiveOfAll.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInclusiveOfAll.setForeground(Color.WHITE);
		lblInclusiveOfAll.setBounds(10, 384, 167, 25);
		window.getContentPane().add(lblInclusiveOfAll);

		JLabel lblTotalAmountPayable = new JLabel("Total Payable Amount: $");
		lblTotalAmountPayable.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		lblTotalAmountPayable.setForeground(Color.WHITE);
		lblTotalAmountPayable.setBounds(10, 340, 248, 47);
		window.getContentPane().add(lblTotalAmountPayable);

		RoomBox = new JComboBox();
		RoomBox.setBounds(603, 183, 157, 28);
		window.getContentPane().add(RoomBox);
		RoomBox.addItem("SELECT");
		RoomBox.addItem("Single Room");
		RoomBox.addItem("Double Room");
		RoomBox.addItem("Family Room");
		RoomBox.addItemListener(new ItemHandler());

		JLabel lblRoomPreference = new JLabel("ROOM PREFERENCE : ");
		lblRoomPreference.setForeground(Color.WHITE);
		lblRoomPreference.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRoomPreference.setBounds(394, 188, 194, 25);
		window.getContentPane().add(lblRoomPreference);

		JLabel lblAllFieldsAre = new JLabel("All Fields are Mandatory");
		lblAllFieldsAre.setForeground(Color.WHITE);
		lblAllFieldsAre.setFont(new Font("Goudy Old Style", Font.PLAIN, 21));
		lblAllFieldsAre.setBounds(10, 526, 225, 25);
		window.getContentPane().add(lblAllFieldsAre);

		PhoneField = new JTextField();
		PhoneField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PhoneField.setColumns(10);
		PhoneField.setBounds(172, 298, 181, 31);
		window.getContentPane().add(PhoneField);

		AgeField = new JTextField();
		AgeField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AgeField.setColumns(10);
		AgeField.setBounds(79, 242, 140, 31);
		window.getContentPane().add(AgeField);

		GenBox = new JComboBox();
		GenBox.setBounds(113, 182, 145, 30);
		window.getContentPane().add(GenBox);
		GenBox.addItem("SELECT");
		GenBox.addItem("MALE");
		GenBox.addItem("FEMALE");

		NameField = new JTextField();
		NameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NameField.setBounds(79, 130, 278, 31);
		window.getContentPane().add(NameField);
		NameField.setColumns(10);

		JButton BookButton = new JButton("Book Now");
		BookButton.setForeground(Color.DARK_GRAY);
		BookButton.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		BookButton.setBounds(632, 504, 140, 47);
		window.getContentPane().add(BookButton);
		BookButton.addActionListener(new BookButtonHandler());

		JLabel CheckoutDate = new JLabel("CHECK-OUT DATE : " + getDate(CheckOutDate));
		CheckoutDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CheckoutDate.setForeground(Color.WHITE);
		CheckoutDate.setBounds(394, 296, 378, 31);
		window.getContentPane().add(CheckoutDate);

		JLabel CheckinDate = new JLabel("CHECK-IN DATE : " + getDate(CheckInDate));
		CheckinDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CheckinDate.setForeground(Color.WHITE);
		CheckinDate.setBounds(394, 240, 378, 31);
		window.getContentPane().add(CheckinDate);

		JLabel lblPhoneNumber = new JLabel("PHONE NUMBER : ");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setBounds(10, 304, 167, 25);
		window.getContentPane().add(lblPhoneNumber);

		JLabel lblAge = new JLabel("AGE : ");
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAge.setBounds(10, 248, 70, 25);
		window.getContentPane().add(lblAge);

		JLabel lblGender = new JLabel("GENDER : ");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGender.setBounds(10, 183, 93, 31);
		window.getContentPane().add(lblGender);

		JLabel lblName = new JLabel("NAME : ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(10, 130, 70, 31);
		window.getContentPane().add(lblName);

		JLabel ListImage = new JLabel("");
		ListImage.setBounds(620, 11, 140, 150);
		window.getContentPane().add(ListImage);
		ListImage.setIcon(new ImageIcon(CustomerDetails.class.getResource("/Resources/checklist.png")));

		JLabel lblPleaseFillIn = new JLabel("Please complete all the required fields in the form below");
		lblPleaseFillIn.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		lblPleaseFillIn.setForeground(Color.WHITE);
		lblPleaseFillIn.setBounds(10, 62, 509, 31);
		window.getContentPane().add(lblPleaseFillIn);

		JLabel lblCustomerDetails = new JLabel("Customer Details");
		lblCustomerDetails.setFont(new Font("Goudy Old Style", Font.PLAIN, 40));
		lblCustomerDetails.setForeground(Color.WHITE);
		lblCustomerDetails.setBounds(264, 11, 255, 37);
		window.getContentPane().add(lblCustomerDetails);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CustomerDetails.class.getResource("/Resources/Back800x600.jpg")));
		label.setBounds(0, 0, 784, 562);
		window.getContentPane().add(label);

		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
		ImageIcon img = new ImageIcon(CustomerDetails.class.getResource("/Resources/Icon.png"));
		window.setIconImage(img.getImage());
	}

	class ItemHandler implements ItemListener
	{
		public void itemStateChanged(ItemEvent arg0)
		{
			if (RoomBox.getSelectedIndex() == 0)
			{
				Rate.setText("");
			}
			if (RoomBox.getSelectedIndex() == 1)
			{
				double price = getPrice(getSRPrice(id));
				Rate.setText(Double.toString(price));
			}
			if (RoomBox.getSelectedIndex() == 2)
			{
				double price = getPrice(getDRPrice(id));
				Rate.setText(Double.toString(price));
			}
			if (RoomBox.getSelectedIndex() == 3)
			{
				double price = getPrice(getFRPrice(id));
				Rate.setText(Double.toString(price));
			}
		}

	}

	class BookButtonHandler implements ActionListener
	{
		String RoomId;
		String RoomType;
		String CustomerId;
		int Bookings;
		int total;
		String CheckIn;
		String CheckOut;
		double rate;
		long number;
		int age;
		String name;
		String Gender;
		public void actionPerformed(ActionEvent arg0)
		{
			if (isNameFieldEmpty() || isGenderFieldEmpty() || isAgeFieldEmpty() || isPhoneFieldEmpty()
					|| isPhoneFieldEmpty() || isRoomPrefEmpty())
			{
				jp.showMessageDialog(null, "All Fields are Mandatory", "Empty Field", 0);
			} else
			{
				if (isPhoneNumberValid(PhoneField.getText()))
				{
					RoomId = id + getRoomCode(RoomBox.getSelectedIndex());
					Bookings = getCountOfBooked(RoomId);
					if (RoomBox.getSelectedIndex() == 1)
					{
						total = getSRCount(id);
					}
					if (RoomBox.getSelectedIndex() == 2)
					{
						total = getDRCount(id);
					}
					if (RoomBox.getSelectedIndex() == 3)
					{
						total = getFRCount(id);
					}

					try
					{
						number = Long.parseLong(PhoneField.getText());
						age = Integer.parseInt(AgeField.getText());
					} catch (Exception ex)
					{
						jp.showMessageDialog(null, "Please Enter a Valid Number", "Number Format Exception", 0);
					}
					if (Bookings < total)
					{
						CustomerId = RoomId + (Bookings + 1);
						RoomType = getRoomType(RoomBox.getSelectedIndex());
						CheckIn = getDate(CheckInDate);
						CheckOut = getDate(CheckOutDate);
						rate = getSelectedRoomPrice(RoomBox.getSelectedIndex());
						insertBooking(RoomId, RoomType, CheckIn, CheckOut, rate, CustomerId);
						
						name = NameField.getText();
						Gender = String.valueOf(GenBox.getSelectedItem());
						insertCustomer(CustomerId,name,Gender,age,number);
						
						FinalProblem fp = new FinalProblem(CustomerId);

					} else
					{
						jp.showMessageDialog(null, "Sorry all rooms of this Category are Full", "Rooms Full", 1);
					}
				}
			}
		}
	}

	public double getSelectedRoomPrice(int index)
	{
		double rate = 0.0;
		if (index == 1)
		{
			rate = getPrice(getSRPrice(id));
		}
		if (index == 2)
		{
			rate = getPrice(getDRPrice(id));
		}
		if (index == 3)
		{
			rate = getPrice(getFRPrice(id));
		}
		return rate;
	}

	private int getSRPrice(String id)
	{
		int price = 0;
		try
		{
			result = statement.executeQuery("SELECT SPrice FROM Price WHERE HID = '" + id + "'");
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
		int price = 0;
		try
		{
			result = statement.executeQuery("SELECT DPrice FROM Price WHERE HID = '" + id + "'");
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
		int price = 0;
		try
		{
			result = statement.executeQuery("SELECT FPrice FROM Price WHERE HID = '" + id + "'");
			result.first();
			price = result.getInt(1);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return price;
	}

	public String getDate(Date rawDate)
	{
		String date = null;
		switch (rawDate.getMonth())
		{
		case 1:
			date = rawDate.getDate() + "-JAN-" + rawDate.getYear();
			break;
		case 2:
			date = rawDate.getDate() + "-FEB-" + rawDate.getYear();
			break;
		case 3:
			date = rawDate.getDate() + "-MAR-" + rawDate.getYear();
			break;
		case 4:
			date = rawDate.getDate() + "-APR-" + rawDate.getYear();
			break;
		case 5:
			date = rawDate.getDate() + "-MAY-" + rawDate.getYear();
			break;
		case 6:
			date = rawDate.getDate() + "-JUN-" + rawDate.getYear();
			break;
		case 7:
			date = rawDate.getDate() + "-JUL-" + rawDate.getYear();
			break;
		case 8:
			date = rawDate.getDate() + "-AUG-" + rawDate.getYear();
			break;
		case 9:
			date = rawDate.getDate() + "-SEP-" + rawDate.getYear();
			break;
		case 10:
			date = rawDate.getDate() + "-OCT-" + rawDate.getYear();
			break;
		case 11:
			date = rawDate.getDate() + "-NOV-" + rawDate.getYear();
			break;
		case 12:
			date = rawDate.getDate() + "-DEC-" + rawDate.getYear();
			break;
		}
		return date;
	}

	public String getRoomType(int index)
	{
		String type = "";
		if (index == 1)
		{
			type = "Single";
		}
		if (index == 2)
		{
			type = "Double";
		}
		if (index == 3)
		{
			type = "Family";
		}
		return type;
	}

	public double getPrice(int num)
	{
		return (num + (0.12 * num));
	}

	public boolean isNameFieldEmpty()
	{
		if (NameField.getText().equals(""))
		{
			return true;
		} else
		{
			return false;
		}
	}

	public boolean isGenderFieldEmpty()
	{
		if (GenBox.getSelectedIndex() == 0)
		{
			return true;
		} else
		{
			return false;
		}
	}

	public boolean isAgeFieldEmpty()
	{
		if (AgeField.getText().equals(""))
		{
			return true;
		} else
		{
			return false;
		}
	}

	public boolean isPhoneFieldEmpty()
	{
		if (PhoneField.getText().equals(""))
		{
			return true;
		} else
		{
			return false;
		}
	}

	public boolean isRoomPrefEmpty()
	{
		if (RoomBox.getSelectedIndex() == 0)
		{
			return true;
		} else
		{
			return false;
		}
	}

	public boolean isPhoneNumberValid(String Number)
	{
		if (Number.length() == 10)
		{
			return true;
		} else
		{
			jp.showMessageDialog(null, "Please Enter a Valid 10 digit Phone Number", "Invalid Number", 0);
			return false;
		}
	}

	public void insertBooking(String RoomId, String RoomType, String InDate, String OutDate, double price,
			String CustomerId)
	{
		try
		{
			result = statement.executeQuery("INSERT INTO Booking VALUES ('" + RoomId + "' , '" + RoomType + "' , '"
					+ InDate + "' , '" + OutDate + "' , " + price + " , '" + CustomerId + "' )");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void insertCustomer(String CID, String Name, String Gender, int Age, long number)
	{
		try
		{
			result = statement.executeQuery("INSERT INTO Customer VALUES ('"+CID+"' , '"+Name+"' , '"+Gender+"' , "+Age+" , "+number+")");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public int getSRCount(String id)
	{
		int count = 0;
		try
		{
			result = statement.executeQuery("SELECT SRoom FROM Hotel Where HotelId = '" + id + "'");
			result.first();
			count = result.getInt(1);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}

	public int getDRCount(String id)
	{
		int count = 0;
		try
		{
			result = statement.executeQuery("SELECT DRoom FROM Hotel Where HotelId = '" + id + "'");
			result.first();
			count = result.getInt(1);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}

	public int getFRCount(String id)
	{
		int count = 0;
		try
		{
			result = statement.executeQuery("SELECT FRoom FROM Hotel Where HotelId = '" + id + "'");
			result.first();
			count = result.getInt(1);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}

	public int getCountOfBooked(String RoomId)
	{
		int num = 0;
		try
		{
			result = statement.executeQuery("SELECT * FROM Booking WHERE RoomId = '" + RoomId + "'");
			if (!result.first())
			{
				num = 0;
			} else
			{
				result.first();
				do
				{
					num = num + 1;
				} while (result.next());
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return num;
	}

	public String getRoomCode(int index)
	{
		if (index == 1)
			return "SGL";
		if (index == 2)
			return "DBL";
		if (index == 3)
			return "FLY";

		return null;

	}
}