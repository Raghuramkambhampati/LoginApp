package package1;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validate
 */
@WebServlet("/Validate")
public class ValidateServlet extends HttpServlet 
{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher rd;
		System.out.println("This is Validation  Service");
		LoginAppDAO Dao=LoginAppDAO.getInstance();
		Dao.CreateConnection();
		if(Dao.validate(request.getParameter("name"),request.getParameter("password")))
		    rd=request.getRequestDispatcher("welcome.html");
		else
			rd=request.getRequestDispatcher("");
		rd.forward(request, response);
	}
}
