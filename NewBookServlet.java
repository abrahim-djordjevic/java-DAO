/**
 * this class produces a webpage for enetering new books into the books sqlite database
 *@author Abrahim Djordjevic
 */

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class NewBookServlet extends BookServlet{
	protected void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException{
				response.setContentType("text/html");
				response.setStatus(HttpServletResponse.SC_OK);
				response.getWriter().println("<a href = \"admin\"style=\"font-size:32px;\" >admin</a> <br>");
				response.getWriter().println("<a href = \"add\" style=\"font-size:32px;\"> add </a> <br>");
				response.getWriter().println("<a href = \"update\" style=\"font-size:32px;\"> update </a> <br>");
				response.getWriter().println("<a href = \"delete\" style=\"font-size:32px;\"> delete book </a> <br>");
				response.getWriter().println("<form method = \"post\" action = \"/add\"> <br>");
				response.getWriter().println("BookID: <input type =\"number\" name = \"ID\"> <br>");
				response.getWriter().println("Title: <input type = \"text\" name = \"Title\"> <br>");
				response.getWriter().println("Author: <input type = \"text\" name = \"Author\"> <br>");
				response.getWriter().println("Year: <input type = \"number\" name = \"Year\"> <br>");
				response.getWriter().println("Edition: <input type = \"number\" name = \"Edition\"> <br>");
				response.getWriter().println("Publisher: <input type = \"text\" name = \"Publisher\"> <br>");
				response.getWriter().println("ISBN: <input type = \"text\" name = \"ISBN\"> <br>");
				response.getWriter().println("Cover: <input type = \"text\" name = \"Cover\"> <br>");
				response.getWriter().println("Condition: <input type =\"text\" name =\"Condition\"> <br>");
				response.getWriter().println("Price: <input type =\"number\" name = \"Price\"> <br>");
				response.getWriter().println("Notes: <input type =\"text\" name = \"Notes\"> <br>");
				response.getWriter().println("<input type =\"submit\" value=\"Submit\"> <br>");
				response.getWriter().println("</form>");
			}
	
	protected void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException{
				try {
					Connection conn = htmlConnection();
					Statement statement = conn.createStatement();
					int ID = Integer.parseInt(request.getParameter("ID"));
					String Title = request.getParameter("Title");
					String Author = request.getParameter("Author");
					int Year = Integer.parseInt(request.getParameter("Year"));
					int Edition = Integer.parseInt(request.getParameter("Edition"));
					String Publisher = request.getParameter("Publisher");
					String ISBN = request.getParameter("ISBN");
					String Cover = request.getParameter("Cover");
					String Condition = request.getParameter("Condition");
					int Price = Integer.parseInt(request.getParameter("Price"));
					String Notes = request.getParameter("Notes");
					String query = "INSERT INTO BOOKS(ID, Title, Author, Year, Edition, Publisher, ISBN, Condition, Price, Notes)"
									+ " Values(" + ID + ", " + Title + ", " + Author + ", " + Year + ", " + Edition + ", " + Publisher +
									", " + ISBN + ", " + Cover + ", " + Condition + ", " + Price + ", " + Notes + ");";
					statement.executeUpdate(query);
				}catch(SQLException e) {
					System.out.println("Error SQLException");
				}
	}

}
