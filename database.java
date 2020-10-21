package SIH;
import java.sql.*;
public class database {

	public static void main(String[] args) throws Exception{
		String url="jdbc:mysql://localhost:3306/testdb";
		String uname="tiger";
		String pass="goat";
		String query="select movies_name from movies;";
		Class.forName("com.sql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,pass);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		String name=rs.getString(1);
		System.out.println(name);
		st.close();
		con.close();
	}

}
