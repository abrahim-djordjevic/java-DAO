/**
 * BookDAO for connecting to books.sqlite
 * @author Abrahim Djordjevic
 * methods in this class for connecting to the database, return all books,
 * return a single book, delete, insert or update a book
 */
// import library for sql database connectivity
import java.sql.*;
import java.util.ArrayList;

public class BookDAO{
	/**
	 * getDBConnection method for connecting to the database
	 */
	private static Connection getDBConnection() {
		//conn is a standard name for a connection
		//defining variables
		Connection conn = null;
		final String DATABASE_NAME = "books.sqlite";
		
		//create url for the database
		String url = "jdbc:sqlite:" + DATABASE_NAME;
		
		//intialise the JDBC driver class
		try {
			Class.forName("sqlite-JDBC");
		} catch(ClassNotFoundException e) {
			System.out.println("Error, driver class not found.");
		}
				
		//Connect to the database to the specified url 
		try {
			conn = DriverManager.getConnection(url);
		}catch(SQLException e) {
			System.out.println("Connection Error, check the URL or DATABASE_NAME.");
		}
		return conn;
		}
	/**
	 * getAllBooks method for returning all books in the database
	 */
	public ArrayList<Book> getAllBooks() throws SQLException{
		//print message
		System.out.println("Retrieving all data ..........");
		
		//declare variables
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		//SQL Query as a string
		String query = "SELECT * FROM books;";
		bookList = new ArrayList<Book>();
		try{
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println("SQLite Query is " + query);
			result = statement.executeQuery(query);//execute query 
			while(result.next()) {
				//add results to book list array list
				int bookID = result.getInt("ID");
				String title = result.getString("Title");
				String author = result.getString("Author");
				int year = result.getInt("Year");
				int edition = result.getInt("Edition");
				String publisher = result.getString("Publisher");
				String isbn = result.getString("ISBN");
				String cover = result.getString("Cover");
				String condition = result.getString("Condition");
				int price = result.getInt("Price");
				String notes = result.getString("Notes");
				bookList.add(new Book(bookID, title, author, year, edition, publisher, isbn, cover, condition, price, notes));
			}
		return bookList;
		}finally{
			if (result != null) { result.close();}
			if (statement != null) { statement.close(); }
			if (dbConnection != null) { dbConnection.close(); }
	}
	}
	/**
	 * getBook method for returning a single book in the database based on ID parameter
	 */
	public Book getBook(int ID) throws SQLException{
		//print message
		System.out.println("Retrieving data ............");
		//variable declaration
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;
		Book selection;
		//SQL Query as a string
		String query = "SELECT * FROM BOOKS WHERE ID = " + ID + ";";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println("SQLite Query is " + query);
			result = statement.executeQuery(query);//execute query 
			//add results to book list array list 
			int bookID = result.getInt("ID");
			String title = result.getString("Title");
			String author = result.getString("Author");
			int year = result.getInt("Year");
			int edition = result.getInt("Edition");
			String publisher = result.getString("Publisher");
			String isbn = result.getString("ISBN");
			String cover = result.getString("Cover");
			String condition = result.getString("Condition");
			int price = result.getInt("Price");
			String notes = result.getString("Notes");
			selection = new Book(bookID, title, author, year, edition, publisher, isbn, cover, condition, price, notes);
			return selection;
		}finally{
				if (result != null) { result.close();}
				if (statement != null) { statement.close(); }
				if (dbConnection != null) { dbConnection.close(); }
			}
		}
	/**
	 * insertBook method for inserting a book defined by the user in the bookMenu class 
	 */
	public boolean insertBook(Book Book) throws SQLException{
		//variable declaration
		Connection dbConnection = null;
		Statement statement = null;
		boolean Continue;
		//SQL query
		String query = "INSERT INTO BOOKS(ID, Title, Author, Year, Edition, Publisher, ISBN, Condition, Price, Notes )"
						+ " Values(" + Book.getBookID() + ", " + Book.getTitle() + ", " + Book.getAuthor() + ", " +
						Book.getYear() + ", " + Book.getEdition() + ", " + Book.getPublisher() + ", " + Book.getIsbn() + 
						", " + Book.getCover() + ", " + Book.getCondition() + ", " + Book.getPrice() + ", " + Book.getNotes() + ");";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println("SQLite Query is " + query);
			statement.executeUpdate(query);//execute query
			Continue = true;
			return Continue;
		}finally {
			if (statement != null) { statement.close(); }
			if (dbConnection != null) { dbConnection.close(); }
		}
	}
	/**
	 * UpdateBook method for updating a book
	 */
	public boolean updateBook(int ID, String[] Details) throws SQLException{
		//variable declaration
		Connection dbConnection = null;
		Statement statement = null;
		boolean Continue;
		//SQL Query as a string
		String query = "UPDATE Books" + "\n" + "SET " + Details[0] + " = " + Details[1] + "\n" + "WHERE ID = " + ID; 
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println("SQLite Query is " + query);
			statement.executeUpdate(query);//execute query
			Continue = true;
			return Continue;
		}finally {
			if (statement != null) { statement.close(); }
			if (dbConnection != null) { dbConnection.close(); }
		}
	}		
	
	/**
	 * deleteBook method for deleting a book (equivalent to a row in the table)
	 */
	public boolean deleteBook(int ID) throws SQLException{
		//variable declaration
		Connection dbConnection = null;
		Statement statement = null;
		boolean Continue;
		//SQL Query as a string
		String query = "DELETE FROM books WHERE ID = " + ID + ";";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println("SQLite Query is " + query);
			statement.executeUpdate(query);//execute query
			Continue = true;
			return Continue;
		}finally {
			if (statement != null) { statement.close(); }
			if (dbConnection != null) { dbConnection.close(); }
		}
	}
}

