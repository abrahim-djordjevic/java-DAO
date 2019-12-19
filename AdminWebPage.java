/**
 * this class codes for the admin webpage and will present the  books.sqlite database to th euser as well as links to other webpages to create, update and delete records
 * this webpage serves as the centre of the web front end for admins 
 */

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AdminWebPage extends BookServlet{
	protected void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
			{
			try {
				Connection conn = htmlConnection();
				Statement statement = conn.createStatement();
				//Sql query for returning all data
				ResultSet rs = statement.executeQuery("SELECT * FROM books;");
				//links to admin homepage, add book, update book and delete books webpages
				response.getWriter().println("<a href = \"admin\" style=\"font-size:32px;\">admin</a> <br><br>");
				response.getWriter().println("<a href = \"add\" style=\"font-size:32px;\"> add book </a> <br><br>");
				response.getWriter().println("<a href = \"update\" style=\"font-size:32px;\"> update book </a> <br><br>");
				response.getWriter().println("<a href = \"delete\" style=\"font-size:32px;\"> delete book </a> <br><br>");
				//table to display records
				response.getWriter().println("<table border = 1 width = 70% height=50%>");
				response.getWriter().println("<tr><th>Book ID</th><th>Title</th><th>Author</th><th>Year</th><th>Edition</th>"
						+ "<th>Publisher</th><th>ISBN</th><th>Cover</th><th>Condition</th><th>Price</th><th>Notes</th>");
			while (rs.next()) {
				//returning data from the database
				int bookID = rs.getInt("ID");
				String title = rs.getString("Title");
				String author = rs.getString("Author");
				int year = rs.getInt("Year");
				int edition = rs.getInt("Edition");
				String publisher = rs.getString("Publisher");
				String isbn = rs.getString("ISBN");
				String cover = rs.getString("Cover");
				String condition = rs.getString("Condition");
				int price = rs.getInt("Price");
				String notes = rs.getString("Notes");
				response.getWriter().println("<tr><td>" + bookID + "</td><td>" + title + "</td><td>" + author + "</td><td>" + year + "</td><td>" +
				edition + "</td><td>" + publisher + "</td><td>" + isbn + "</td><td>" + cover + "</td><td>" + condition + "</td><td>" +
				price + "</td><td>" + notes + "</td></tr>");
			}
			}catch(SQLException e) {
				System.out.println("Error SQLException");
			}
			response.getWriter().println("</table>");
			response.getWriter().println("</body></html>");
	}
}
