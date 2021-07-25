package todolist;
import java.sql.DriverManager;
import javax.swing.*;
import com.sun.jdi.connect.spi.Connection;

public class DB
{
	Connection con = null;
	java.sql.PreparedStatement pst;
	public static Connection dbconnect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist","root", "1234567");
			return conn;
		}
		catch(Exception e2)
		{
			System.out.println(e2);
			return null;
		}
	}
	
	

}
