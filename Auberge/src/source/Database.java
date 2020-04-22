package source;

import java.sql.*;
import javax.swing.*;

public class Database
{	
	private static JOptionPane pane = new JOptionPane();
	public static Connection connect = null;
	public static Statement statement = null;
	public static ResultSet result = null;
	public void Connect()
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e)
		{
			pane.showMessageDialog(null, "Error in Resolving Driver Class Name", "Class Not Found", 0);
			System.exit(0);
		}
		try
		{
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "admin", "admin");
		} catch (SQLException e)
		{
			pane.showMessageDialog(null, "Program was Unable to establish a connection with the Database. Please check whether the Database service is running or not.", "Connection could not be Established", 0);
			System.exit(0);
		}
		pane.showMessageDialog(null, "Connection Established Succesfully", "Connected", 1);
		try
		{
			statement = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e)
		{
			pane.showMessageDialog(null, "Failed to Initialize the Statement", "Initialization ERROR", 0);
		}
		StateSelect ss = new StateSelect();
	}
}