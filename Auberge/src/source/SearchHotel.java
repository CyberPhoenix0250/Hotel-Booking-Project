package source;

import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.sql.*;
import source.Database;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.util.Date;

class SearchHotel extends Database
{
	private JFrame window = new JFrame("AUBERGE Online Hotel Booking");
	private JLabel BackImage = new JLabel();
	private JTextField SearchField;
	private JTextField LowRange;
	private JTextField HighRange;
	private JTable table;
	private static Scanner input = new Scanner(System.in);
	private static JComboBox StarRating = new JComboBox();
	private static JOptionPane jp = new JOptionPane();
	private static String StateName;
	private JComboBox OutDateYear = new JComboBox();
	private JComboBox OutDateDay = new JComboBox();
	private JComboBox OutDateMonth = new JComboBox();
	private JComboBox InDateYear = new JComboBox();
	private JComboBox InDateMonth = new JComboBox();
	private JComboBox InDateDay = new JComboBox();
	private JCheckBox checkRestaurant = new JCheckBox("Restaurant");
	private JCheckBox checkPetFriendly = new JCheckBox("Pet Friendly");
	private JCheckBox checkSpa = new JCheckBox("Spa");
	private JCheckBox checkPool = new JCheckBox("Pool");
	private JCheckBox checkCarPark = new JCheckBox("Car Park");
	private JCheckBox checkAirConditioning = new JCheckBox("Air Conditioning");
	private JCheckBox checkFreeWifi = new JCheckBox("Free WiFi");
	private static CheckDate cd = new CheckDate();
	private Date inDate;
	private Date outDate;

	SearchHotel(String Name)
	{
		inDate = new Date();
		outDate = new Date();
		StateName = Name;
		window.setSize(1000, 800);
		window.setLocation(140, 100);
		window.getContentPane().setLayout(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		ImageIcon img = new ImageIcon(MainPage.class.getResource("/Resources/Icon.png"));
		window.setIconImage(img.getImage());
		window.setVisible(true);

		JLabel lblMin = new JLabel("Min : 100 $                        Max : 700 $");
		lblMin.setForeground(Color.WHITE);
		lblMin.setBounds(29, 296, 210, 23);
		window.getContentPane().add(lblMin);

		JButton ViewButton = new JButton("View Selected Hotel");
		ViewButton.setFont(new Font("Californian FB", Font.BOLD, 18));
		ViewButton.setBounds(750, 119, 210, 33);
		window.getContentPane().add(ViewButton);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(275, 171, 685, 567);
		window.getContentPane().add(scrollPane);

		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setFont(new Font("Calibri", Font.PLAIN, 15));
		table.setForeground(Color.BLACK);
		table.setBackground(Color.WHITE);
		table.setBorder(null);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(table);

		result = DisplayAllFromHotel(StateChooser());
		displayOnTable(result);

		checkRestaurant.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkRestaurant.setForeground(Color.WHITE);
		checkRestaurant.setBounds(29, 572, 210, 23);
		window.getContentPane().add(checkRestaurant);
		checkRestaurant.setOpaque(false);

		checkPetFriendly.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkPetFriendly.setForeground(Color.WHITE);
		checkPetFriendly.setBounds(29, 534, 210, 23);
		window.getContentPane().add(checkPetFriendly);
		checkPetFriendly.setOpaque(false);

		checkSpa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkSpa.setForeground(Color.WHITE);
		checkSpa.setBounds(29, 497, 210, 23);
		window.getContentPane().add(checkSpa);
		checkSpa.setOpaque(false);

		checkPool.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkPool.setForeground(Color.WHITE);
		checkPool.setBounds(29, 460, 210, 23);
		window.getContentPane().add(checkPool);
		checkPool.setOpaque(false);

		checkCarPark.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkCarPark.setForeground(Color.WHITE);
		checkCarPark.setBounds(29, 423, 210, 23);
		window.getContentPane().add(checkCarPark);
		checkCarPark.setOpaque(false);

		checkAirConditioning.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkAirConditioning.setForeground(Color.WHITE);
		checkAirConditioning.setBounds(29, 388, 210, 23);
		window.getContentPane().add(checkAirConditioning);
		checkAirConditioning.setOpaque(false);

		checkFreeWifi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkFreeWifi.setForeground(Color.WHITE);
		checkFreeWifi.setBounds(29, 352, 210, 23);
		window.getContentPane().add(checkFreeWifi);
		checkFreeWifi.setOpaque(false);

		JLabel lblFacilitiesAndAmenities = new JLabel("Facilities and Amenities");
		lblFacilitiesAndAmenities.setForeground(Color.WHITE);
		lblFacilitiesAndAmenities.setFont(new Font("Goudy Old Style", Font.PLAIN, 22));
		lblFacilitiesAndAmenities.setBounds(29, 321, 210, 24);
		window.getContentPane().add(lblFacilitiesAndAmenities);

		JLabel lblTo = new JLabel("to");
		lblTo.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lblTo.setForeground(Color.WHITE);
		lblTo.setBounds(125, 269, 21, 24);
		window.getContentPane().add(lblTo);

		HighRange = new JTextField();
		HighRange.setColumns(10);
		HighRange.setBounds(153, 272, 86, 24);
		window.getContentPane().add(HighRange);

		LowRange = new JTextField();
		LowRange.setBounds(29, 272, 86, 24);
		window.getContentPane().add(LowRange);
		LowRange.setColumns(10);

		JLabel lblPriceRange = new JLabel("Price Range");
		lblPriceRange.setForeground(Color.WHITE);
		lblPriceRange.setFont(new Font("Goudy Old Style", Font.PLAIN, 22));
		lblPriceRange.setBounds(29, 241, 150, 24);
		window.getContentPane().add(lblPriceRange);

		StarRating.setBounds(29, 208, 210, 22);
		window.getContentPane().add(StarRating);
		StarRating.addItem("");
		for (int i = 1; i <= 5; i++)
		{
			StarRating.addItem(new Integer(i));
		}

		JLabel lblStarRating = new JLabel("STAR Rating");
		lblStarRating.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lblStarRating.setForeground(Color.WHITE);
		lblStarRating.setBounds(29, 173, 127, 24);
		window.getContentPane().add(lblStarRating);

		OutDateYear.setBounds(650, 128, 71, 24);
		window.getContentPane().add(OutDateYear);
		OutDateYear.addItem("Year");
		for (int i = 2018; i <= 2025; i++)
		{
			OutDateYear.addItem(new Integer(i));
		}
		JLabel lblCheckout = new JLabel("Check-OUT");
		lblCheckout.setForeground(Color.WHITE);
		lblCheckout.setFont(new Font("Consolas", Font.BOLD, 18));
		lblCheckout.setBounds(379, 128, 93, 24);
		window.getContentPane().add(lblCheckout);

		OutDateDay.setBounds(482, 128, 62, 24);
		window.getContentPane().add(OutDateDay);
		OutDateDay.addItem("Day");
		for (int i = 1; i <= 31; i++)
		{
			OutDateDay.addItem(new Integer(i));
		}

		OutDateMonth.setBounds(554, 128, 86, 24);
		window.getContentPane().add(OutDateMonth);
		OutDateMonth.addItem("Month");
		OutDateMonth.addItem("January");
		OutDateMonth.addItem("February");
		OutDateMonth.addItem("March");
		OutDateMonth.addItem("April");
		OutDateMonth.addItem("May");
		OutDateMonth.addItem("June");
		OutDateMonth.addItem("July");
		OutDateMonth.addItem("August");
		OutDateMonth.addItem("September");
		OutDateMonth.addItem("October");
		OutDateMonth.addItem("November");
		OutDateMonth.addItem("December");

		JSeparator CheckBarrier = new JSeparator();
		CheckBarrier.setOrientation(SwingConstants.VERTICAL);
		CheckBarrier.setBounds(372, 120, 8, 42);
		window.getContentPane().add(CheckBarrier);

		InDateYear.setBounds(291, 128, 71, 24);
		window.getContentPane().add(InDateYear);
		InDateYear.addItem("Year");
		for (int i = 2018; i <= 2025; i++)
		{
			InDateYear.addItem(new Integer(i));
		}

		InDateMonth.setBounds(195, 128, 86, 24);
		window.getContentPane().add(InDateMonth);
		InDateMonth.addItem("Month");
		InDateMonth.addItem("January");
		InDateMonth.addItem("February");
		InDateMonth.addItem("March");
		InDateMonth.addItem("April");
		InDateMonth.addItem("May");
		InDateMonth.addItem("June");
		InDateMonth.addItem("July");
		InDateMonth.addItem("August");
		InDateMonth.addItem("September");
		InDateMonth.addItem("October");
		InDateMonth.addItem("November");
		InDateMonth.addItem("December");

		InDateDay.setBounds(125, 128, 60, 24);
		window.getContentPane().add(InDateDay);
		InDateDay.addItem("Day");
		for (int i = 1; i <= 31; i++)
		{
			InDateDay.addItem(new Integer(i));
		}

		JLabel lblCheckin = new JLabel("Check-IN");
		lblCheckin.setForeground(Color.WHITE);
		lblCheckin.setFont(new Font("Consolas", Font.BOLD, 18));
		lblCheckin.setBounds(29, 128, 93, 24);
		window.getContentPane().add(lblCheckin);

		JSeparator separator = new JSeparator();
		separator.setBounds(29, 160, 931, 2);
		window.getContentPane().add(separator);

		JLabel lblEnterTheHotel = new JLabel("Enter the Hotel name or Hotel ID");
		lblEnterTheHotel.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblEnterTheHotel.setForeground(Color.WHITE);
		lblEnterTheHotel.setBounds(29, 84, 348, 33);
		window.getContentPane().add(lblEnterTheHotel);

		SearchField = new JTextField(null);
		SearchField.setFont(new Font("Tahoma", Font.PLAIN, 18));

		SearchField.setBounds(29, 43, 760, 42);
		window.getContentPane().add(SearchField);
		SearchField.setColumns(10);

		JButton SearchButton = new JButton("SEARCH HOTEL");
		SearchButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		SearchButton.setBounds(799, 43, 161, 42);
		window.getContentPane().add(SearchButton);

		JLabel BookYourHotelLabel = new JLabel("Book Your Hotel Now");
		BookYourHotelLabel.setForeground(Color.WHITE);
		BookYourHotelLabel.setFont(new Font("Goudy Old Style", Font.PLAIN, 24));
		BookYourHotelLabel.setBounds(29, 8, 210, 33);
		window.getContentPane().add(BookYourHotelLabel);
		BackImage.setBounds(0, 0, 984, 762);
		BackImage.setIcon(new ImageIcon(SearchHotel.class.getResource("/Resources/backimage.jpg")));
		window.getContentPane().add(BackImage);
		SearchButton.addActionListener(new SearchButtonHandler());
		ViewButton.addActionListener(new SelectButtonHandler());
	}

	boolean isDateCorrect()
	{
		if (InDateDay.getSelectedIndex() != 0 && InDateDay.getSelectedIndex() != 0 && InDateYear.getSelectedIndex() != 0
				&& OutDateDay.getSelectedIndex() != 0 && OutDateMonth.getSelectedIndex() != 0
				&& OutDateYear.getSelectedIndex() != 0)
		{
			boolean checkIN = cd.validity(InDateDay.getSelectedIndex(), InDateMonth.getSelectedIndex(),
					(InDateYear.getSelectedIndex() + 2017));
			boolean checkOUT = cd.validity(OutDateDay.getSelectedIndex(), OutDateMonth.getSelectedIndex(),
					(OutDateYear.getSelectedIndex() + 2017));
			if (checkIN == true && checkOUT == true)
			{
				inDate = new Date((InDateYear.getSelectedIndex() + 2017), InDateMonth.getSelectedIndex(),
						InDateDay.getSelectedIndex());
				outDate = new Date((OutDateYear.getSelectedIndex() + 2017), OutDateMonth.getSelectedIndex(),
						OutDateDay.getSelectedIndex());
				if (inDate.before(outDate))
				{
					return true;
				} else
				{
					jp.showMessageDialog(null, "Check-IN date cannot be Same/Ahead of the Check-OUT date", "Error", 0);
					return false;
				}
			} else
			{
				return false;
			}
		} else
		{
			jp.showMessageDialog(null, "Check-IN and Check-OUT Fields cannot be Empty", "Empty Fields", 0);
			return false;
		}
	}

	public class MyTableModel extends DefaultTableModel
	{

		public MyTableModel(Object[][] tableData, Object[] colNames)
		{
			super(tableData, colNames);
		}

		public boolean isCellEditable(int row, int column)
		{
			return false;
		}
	}

	public void displayOnTable(ResultSet content)
	{
		String rows[][] = new String[100][100];
		int j = 0;
		try
		{
			result.first();
			do
			{
				rows[j][0] = result.getString(1);
				rows[j][1] = result.getString(2);
				rows[j][2] = result.getString(3);
				rows[j][3] = Integer.toString(result.getInt(4));
				j = j + 1;
			} while (result.next());
		} catch (SQLException e1)
		{
			e1.printStackTrace();
		}

		table.setModel(new MyTableModel(rows, new String[]
		{ "Hotel ID", "Hotel Name", "Address", "Stars" })
		{
			Class[] columnTypes = new Class[]
			{ String.class, String.class, String.class, Integer.class };

			public Class getColumnClass(int columnIndex)
			{
				return columnTypes[columnIndex];
			}
		});
	}

	public String StateChooser()
	{
		String state = "";
		switch (StateSelect.combo1.getSelectedIndex())
		{
		case 0:
			state = "Arizona";
			break;
		case 1:
			state = "California";
			break;
		case 2:
			state = "Texas";
			break;
		case 3:
			state = "New York";
			break;
		case 4:
			state = "Washington";
			break;
		}
		return state;
	}

	public ResultSet HIDBuilder(String list[])
	{
		String Query = "SELECT HotelId,HotelName,Address,StarRating FROM Hotel WHERE HotelId IN ('ABCDEF'";
		for (int i = 0; i < list.length; i++)
		{
			if (list[i] != null)
			{
				Query = Query + ",'" + list[i] + "'";
			}
		}
		Query = Query + ")";
		try
		{
			result = statement.executeQuery(Query);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;

	}

	public ResultSet DisplayAllFromHotel(String state)
	{
		try
		{
			result = statement.executeQuery("select HotelId,HotelName,Address,Starrating from Hotel where StateName = '"
					+ state + "' order by HotelId asc");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	class SelectButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			boolean anyRowSelected = (table.getSelectedRow() == -1 ? false : true);
			if (anyRowSelected)
			{

				if (isDateCorrect())
				{
					String text = String.valueOf(table.getValueAt(table.getSelectedRow(), 0));
					new BookWindow(text,inDate,outDate);
				}
			}
			else
			{
				jp.showMessageDialog(null, "You have not Selected any Hotel to View", "Please Select a Hotel", 1);
			}
		}

	}

	class SearchButtonHandler implements ActionListener
	{
		public String[] common;
		public String[] hid1;
		public String[] hid2;
		public String[] hid3;
		public String[] hid4;

		SearchButtonHandler()
		{
			common = new String[100];
			hid1 = new String[100];
			hid2 = new String[100];
			hid3 = new String[100];
			hid4 = new String[100];
		}

		public void actionPerformed(ActionEvent e)
		{

			if (isDateCorrect())
			{

				if (!isSearchBarEmpty())
				{
					hid1 = searchBarQuery(hid1);
				}
				if (!isRatingEmpty())
				{
					hid2 = starRatingQuery(hid2);
				}
				if (!isPriceRangeEmpty())
				{
					hid3 = priceRangeQuery(hid3);
				}
				if (!isFacilityEmpty())
				{
					hid4 = facilitiesQuery(hid4);
				}
				common = commonSeeker(commonSeeker(hid1, hid2), commonSeeker(hid3, hid4));

				if (isAllNull(common))
				{
					jp.showMessageDialog(null, "NO Result matching your search criteria", "No Results", 1);
				} else
				{
					result = HIDBuilder(common);
					displayOnTable(result);
					setAllNull(hid1);
					setAllNull(hid2);
					setAllNull(hid3);
					setAllNull(hid4);
				}
			}
		}

		public String[] setAllNull(String[] list)
		{
			for (int i = 0; i < list.length; i++)
			{
				list[i] = null;
			}
			return list;
		}

		public boolean isAllNull(String list[])
		{
			int count = 0;
			for (int i = 0; i < list.length; i++)
			{
				if (list[i] == null)
				{
					count = count + 1;
				}
			}
			if (list.length == count)
			{
				return true;
			} else
			{
				return false;
			}
		}

		public String[] commonSeeker(String a[], String b[])
		{
			String temp[] = new String[100];
			if (isAllNull(a))
			{
				return b;
			}
			if (isAllNull(b))
			{
				return a;
			}
			if (!isAllNull(a) && !isAllNull(b))
			{
				int k = 0;
				for (int i = 0; i < a.length; i++)
				{
					for (int j = 0; j < b.length; j++)
					{
						if (a[i] != null && b[j] != null)
						{
							if (a[i].equals(b[j]))
							{
								temp[k] = a[i];
								k = k + 1;
							}
						}
					}
				}
			}
			return temp;
		}

		public String[] searchBarQuery(String hid1[])
		{
			int i = 0;
			String SearchText = SearchField.getText();
			try
			{
				result = statement.executeQuery("SELECT * FROM Hotel WHERE StateName = '" + StateName
						+ "' AND HotelName LIKE '%" + SearchText + "%' OR HotelId LIKE '%" + SearchText + "%'");
				if (!result.next())
				{
					jp.showMessageDialog(null, "NO Result matching your search criteria", "No Results", 1);
				} else
				{
					result.first();
					do
					{
						hid1[i] = result.getString(1);
						i = i + 1;
					} while (result.next());
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			return hid1;
		}

		public String[] starRatingQuery(String hid2[])
		{
			int i = 0;
			int rating = StarRating.getSelectedIndex();
			try
			{
				result = statement.executeQuery(
						"SELECT * FROM Hotel WHERE StateName = '" + StateName + "' AND StarRating = " + rating);
				if (!result.next())
				{
					jp.showMessageDialog(null, "NO Result matching your search criteria", "No Results", 1);
				} else
				{
					result.first();
					do
					{
						hid2[i] = result.getString(1);
						i = i + 1;
					} while (result.next());
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			return hid2;
		}

		public String[] priceRangeQuery(String hid3[])
		{
			int i = 0;
			int low = Integer.parseInt(LowRange.getText());
			int high = Integer.parseInt(HighRange.getText());
			try
			{
				result = statement.executeQuery("SELECT * FROM Hotel WHERE StateName = '" + StateName
						+ "' AND Hotelid IN (SELECT HID FROM Price WHERE (SPrice BETWEEN " + low + " AND " + high
						+ " ) OR (DPrice BETWEEN " + low + " AND " + high + " ) OR (FPrice BETWEEN " + low + " AND "
						+ high + "))");
				if (!result.next())
				{
					jp.showMessageDialog(null, "NO Result matching your search criteria", "No Results", 1);
				} else
				{
					result.first();
					do
					{
						hid3[i] = result.getString(1);
						i = i + 1;
					} while (result.next());
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			return hid3;
		}

		public String[] facilitiesQuery(String hid4[])
		{
			int i = 0;
			String Query = "SELECT * FROM Hotel WHERE StateName ='" + StateName
					+ "' AND HotelId IN(SELECT HID FROM Facility WHERE ";
			String hid = "";
			switch (StateName)
			{
			case "Arizona":
				hid = "ARZA";
				break;
			case "California":
				hid = "CLFA";
				break;
			case "Texas":
				hid = "TXAS";
				break;
			case "New York":
				hid = "NWYK";
				break;
			case "Washington":
				hid = "WSGN";
				break;
			}
			try
			{
				if (checkFreeWifi.isSelected())
				{
					Query = Query + (" FreeWifi = 1 AND ");
				}
				if (checkAirConditioning.isSelected())
				{
					Query = Query + (" AirConditioning = 1 AND ");
				}
				if (checkCarPark.isSelected())
				{
					Query = Query + (" CarPark = 1 AND ");
				}
				if (checkPool.isSelected())
				{
					Query = Query + (" Pool = 1 AND ");
				}
				if (checkSpa.isSelected())
				{
					Query = Query + (" Spa = 1 AND ");
				}
				if (checkPetFriendly.isSelected())
				{
					Query = Query + (" PetFriendly = 1 AND ");
				}
				if (checkRestaurant.isSelected())
				{
					Query = Query + (" Restaurant = 1 AND ");
				}
				result = statement.executeQuery(Query + " HID LIKE '" + hid + "%' )");
				if (!result.next())
				{
					jp.showMessageDialog(null, "NO Result matching your search criteria", "No Results", 1);
				} else
				{
					result.first();
					do
					{
						hid4[i] = result.getString(1);
						i = i + 1;
					} while (result.next());
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			return hid4;
		}

		boolean isFacilityEmpty()
		{
			if (checkFreeWifi.isSelected() || checkAirConditioning.isSelected() || checkCarPark.isSelected()
					|| checkPool.isSelected() || checkPool.isSelected() || checkSpa.isSelected()
					|| checkPetFriendly.isSelected() || checkRestaurant.isSelected())
			{
				return false;
			} else
			{
				return true;
			}
		}

		boolean isRatingEmpty()
		{
			if (StarRating.getSelectedIndex() == 0)
			{

				return true;
			} else
			{

				return false;
			}
		}

		boolean isPriceRangeEmpty()
		{
			if (LowRange.getText().equals("") || HighRange.getText().equals(""))
			{
				return true;
			} else
			{
				return false;
			}
		}

		boolean isSearchBarEmpty()
		{
			if (SearchField.getText().equals(""))
			{
				return true;
			} else
			{
				return false;
			}
		}
	}
}