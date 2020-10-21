package SIH;
import java.sql.*;
public class PLoginDao
{
	String sql="select * from tb_doctor23 where Email=? and Password=? and Mobile_Number=?";
	String url="jdbc:mysql://localhost:3306/testdb?autoReconnect=true&verifyServerCertificate=false&useSSL=true&allowPublicKeyRetrieval=true";
	String username="root";
	String pass="goat";
	public boolean check(String email,String password,String mob_no)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pass);
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, password);
			st.setString(3, mob_no);
			ResultSet rs=st.executeQuery();
			if (rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

}
