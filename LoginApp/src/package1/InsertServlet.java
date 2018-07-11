package package1;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class InsertServlet extends HttpServlet 
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
		System.out.println("This is Insertion  Service");
		LoginAppDAO Dao=LoginAppDAO.getInstance();
		Dao.CreateConnection();
		Employee emp=new Employee(Integer.parseInt(request.getParameter("id")),request.getParameter("name"),request.getParameter("password"),request.getParameter("firstname"),request.getParameter("lastname"),request.getParameter("email"),request.getParameter("address"));
	    Dao.insertdata(emp);
	    System.out.println("Data Inserted Sucessfully");
	    RequestDispatcher rd=request.getRequestDispatcher("");
	    rd.forward(request, response);
	}
}
