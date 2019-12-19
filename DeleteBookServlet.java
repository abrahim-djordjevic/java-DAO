/**
 * this webpage is used to delete a book from the database based upon its ID the webpage is only accesible after an admin logs in
 * @author Abrahim Djordjevic
 */
import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DeleteBookServlet extends BookServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().println("<a href = \"admin\"style=\"font-size:32px;\" >admin</a> <br>");
			response.getWriter().println("<a href = \"add\" style=\"font-size:32px;\"> add </a> <br>");
			response.getWriter().println("<a href = \"update\" style=\"font-size:32px;\"> update </a> <br>");
			response.getWriter().println("<a href = \"delete\" style=\"font-size:32px;\"> delete book </a> <br>");
			response.getWriter().println("<form method = \"post\" action = \"delete\" delete book </a> <br>");
			response.getWriter().println("BookID: <input type =\"number\" name = \"ID\"> <br>");
			response.getWriter().println("<input type =\"submit\" value=\"Submit\"> <br>");
			response.getWriter().println("</form>");
	}

protected void doPost( HttpServletRequest request, HttpServletResponse response )
		throws ServletException, IOException{
			try {
				Connection conn = htmlConnection();
				Statement statement = conn.createStatement();
				int ID = Integer.parseInt(request.getParameter("ID"));
				String query = "DELETE FROM books WHERE ID = " + ID + ";";
				statement.executeUpdate(query);
			}catch(SQLException e) {
				System.out.println("Error SQLException");
		}
	}
}
