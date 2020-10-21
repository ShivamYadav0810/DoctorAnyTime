package SIH;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Doctor_Login")
public class Doctor_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Doctor_Login() {
        super();
            }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
		
		PrintWriter out =response.getWriter();
		response.setContentType("login1.html");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String mob_no=request.getParameter("mob_no");
		LoginDao dao=new LoginDao();
		if(dao.check(email,password,mob_no))
		{
			HttpSession session=request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("User.jsp");
		}
		else
		{
			response.sendRedirect("login1.jsp");
			out.println("invalid info");
		}
	
		
	}

}


