package SIH;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PLogin")
public class PLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public PLogin() {
        super();
    
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String mob_no=request.getParameter("mob_no");
		PLoginDao dao=new PLoginDao();
		if(dao.check(email,password,mob_no))
		{
			HttpSession session=request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("PWelcome.jsp");
		}
		else
		{
			response.sendRedirect("PPogin.jsp");
			out.println("invalid info");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}


}
