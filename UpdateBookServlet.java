/**
 * this class codes for a web page where users can update records in the book sqlite database
 * this web page is only accessible from the admin webpage 
 * @author Abrahim Djordjevic
 */

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateBookServlet extends BookServlet{
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().println("<a href = \"admin\"style=\"font-size:32px;\" >admin</a> <br>");
			response.getWriter().println("<a href = \"add\" style=\"font-size:32px;\"> add </a> <br>");
			response.getWriter().println("<a href = \"update\" style=\"font-size:32px;\"> update </a> <br>");
			response.getWriter().println("<a href = \"delete\" style=\"font-size:32px;\"> delete book </a> <br>");
			response.getWriter().println("<form method = \"post\" action = \"/update\"");
			response.getWriter().println("Book ID: <input type = \"number\" name = \"ID\"");
			response.getWriter().println("Column to be updated: <input type = \"text\" name = \"column\"> <br>");
			response.getWriter().println("Enter new value: <input type = \"text\" name = \"value\"");
			response.getWriter().println("</form>");
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			try {
				Connection conn = htmlConnection();
				Statement statement = conn.createStatement();
				int ID = Integer.parseInt(request.getParameter("ID"));
				String Column = request.getParameter("column");
				String Value = request.getParameter("value");
				String query = "UPDATE Books SET " + Column + " = " + Value + " WHERE ID + " + ID;
				statement.executeUpdate(query);
			}catch(SQLException e) {
				System.out.println("Error SQLException");
			}
		}
}
