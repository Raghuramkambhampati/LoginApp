package package1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Retrieve
 */
@WebServlet("/Retrieve")
public class RetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd;
		System.out.println("This is Retrieve Service");
		LoginAppDAO Dao=LoginAppDAO.getInstance();
		Dao.CreateConnection();
		Employee tmpemp=Dao.retrivedata(Integer.parseInt(request.getParameter("id")));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>"+"Employee Id: "+tmpemp.id+"</html>");
		out.println("</br>");
		out.println("<html>"+"Employee Name: "+tmpemp.name+"</html>");
		out.println("</br>");
		out.println("<html>"+"Employee FirstName: "+tmpemp.firstname+"</html>");
		out.println("</br>");
		out.println("<html>"+"Employee LastName: "+tmpemp.lastname+"</html>");	
		out.println("</br>");
		out.println("<html>"+"Employee E-mail: "+tmpemp.email+"</html>");
		out.println("</br>");
		out.println("<html>"+"Employee Address: "+tmpemp.address+"</html>");
		out.println("</br>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
