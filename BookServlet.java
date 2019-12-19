/**
 * this class codes for the home page of the web front end and is the only web page availible to non admins 
 * the doGet method will present a login form and the books.sqlite database to users
 * the doPost method handles user login by matching their username and password to a database then redirecting the user to the admin webpage if the login details are correct 
 * @author Abrahim Djordjevic
 */
import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class BookServlet extends HttpServlet {
		protected void doGet( HttpServletRequest request, HttpServletResponse response )
		throws ServletException, IOException
		{
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().println("<html>");
			response.getWriter().println("<head>");
			response.getWriter().println("<title> Books </title>");
			response.getWriter().println("</head><body>");
			response.getWriter().println("<h1 style='text-align:center'> Book Inventory </h1>");
			response.getWriter().println("<h3> Log In </h1>");
			response.getWriter().println("<form method = \"post\" action = \"/\">");
			response.getWriter().println("Enter username: <input type=\"text\" name = \"username\"> <br>");
			response.getWriter().println("Enter password: <input type =\"password\" name=\"password\"> <br>");
			response.getWriter().println("<input type =\"submit\" value=\"Login\">");
			response.getWriter().println("</form>");
			try {
				Connection conn = htmlConnection();
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery("SELECT * FROM books;");
				response.getWriter().println("<table border = 1 width = 70% height=50%>");
				response.getWriter().println("<tr><th>Book ID</th><th>Title</th><th>Author</th><th>Year</th><th>Edition</th><th>Publisher</th><th>ISBN</th><th>Cover</th><th>Condition</th><th>Price</th><th>Notes</th>");
				while (rs.next()) {
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
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if(PasswordHash.validate(username, password)) {
				response.sendRedirect("/admin");
			}else {
				response.sendRedirect("/");
			}
		}
		public Connection htmlConnection(){
			Connection conn = null;
			final String DATABASE_NAME = "books.sqlite";
			String url = "jdbc:sqlite:" + DATABASE_NAME;
			try {
				Class.forName("sqlite-JDBC");
			} catch(ClassNotFoundException e) {
				System.out.println("Error Driver class not found");
			}
			
			try {
				conn = DriverManager.getConnection(url);
			}catch(SQLException e) {
				System.out.println("Connection Error, check the URL or DATABASE_NAME.");
			}
			return conn;
		}
	}