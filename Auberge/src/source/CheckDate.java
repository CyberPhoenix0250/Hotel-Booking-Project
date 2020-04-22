package source;

import javax.swing.*;
import java.awt.event.*;

class CheckDate
{
	JOptionPane msg = new JOptionPane();

	boolean validity(int day, int month, int year)
	{
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
		{
			if(day <= 31)
			{
				return true;
			}else
			{
				return false;
			}
		}
		if(month == 4 || month == 6 || month == 9 || month == 11)
		{
			if(day <= 30)
			{
				return true;
			}else
			{
				msg.showMessageDialog(null, "April,June,September and November have only 30 days not 31", "Error", 0);
				return false;
			}
		}
		if(month == 2 && leapYear(year) == false)
		{
			if(day <= 28)
			{
				return true;
			}
			else
			{
				msg.showMessageDialog(null, "February can have only upto 28 days, Because "+year+" is not a Leap year", "Not a Leap Year", 0);
				return false;
			}
		}else if(month == 2 && leapYear(year) == true)
		{
			if(day <= 29)
			{
				return true;
			}
			else
			{
				msg.showMessageDialog(null, "February can have only upto 29 days, Because "+year+" is a Leap Year", "Leap Year", 0);
				return false;
			}
		}
		return false;
	}

	boolean leapYear(int year)
	{
		if (year % 400 == 0)
		{
			return true;
		}

		if (year % 100 == 0)
		{
			return false;
		}

		if (year % 4 == 0)
		{
			return true;
		}

		return false;
	}
}