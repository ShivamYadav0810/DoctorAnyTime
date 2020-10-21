package SIH;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Doctor_Reg")
public class Doctor_Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Doctor_Reg() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out =response.getWriter();
		response.setContentType("signup2.html");
		String First_Name,Last_Name,Qualification,Mobile_Number,Password,Email,Exp;
		First_Name=request.getParameter("first_name".toString());
		Last_Name=request.getParameter("last_name".toString());
		Qualification=request.getParameter("qualification".toString());
		Mobile_Number=request.getParameter("mob_no".toString());
		Password=request.getParameter("password".toString());
		Email=request.getParameter("email".toString());
		Exp=request.getParameter("G=expirience".toString());
		String sql="insert into tb_patient23 values("+"'"+First_Name+"'"+","+"'"+Last_Name+"'"+","+"'"+Qualification+"'"+","+"'"+Mobile_Number+"'"+","+"'"+Password+"'"+","+"'"+Email+"'"+","+"'"+Exp+"'"+")";
		try
		{
			String url="jdbc:mysql://localhost:3306/testdb?autoReconnect=true&use SSL=false&allowPublicKeyRetrieval=true";
			String Uname="root";
			String pass="goat";
				
			
			Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,Uname,pass);
				Statement st=con.createStatement();
				st.executeUpdate(sql);
		out.println("Registered Successfully");
		st.close();
		con.close();
	}catch(Exception e)
	{
		out.println("Opps! Something went Wrong");
		out.println("Contact Support Team");
		
	}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
