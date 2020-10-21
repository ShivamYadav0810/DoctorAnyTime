package SIH;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.Statement;

public class LoginDao {
	String query="select * from tb_patient23 where Email=? and Passsword=? and Mobile_Number=?";
	String url="jdbc:mysql://localhost:3306/testdb?autoReconnect=true&verifyServerCertificate=false&useSSL=true&allowPublicKeyRetrieval=true";
	String Uname="root";
	String pass="goat";
	public boolean check(String email,String password,String mob_no)
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,Uname,pass);
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1,  email);
		st.setString(2, password);
		st.setString(3,mob_no);
		ResultSet rs=st.executeQuery();
		if(rs.next())
		{
			return true;
		}
		else {
			return false;
		}
		}
		catch(Exception e)
		
		{/*System.out.println("OPPS! SOMETHING WENT WRONG ");
		System.out.println("CONTACT DEVELOPER");*/
			System.out.println(e);
			return false;
		}
		
	}

}
