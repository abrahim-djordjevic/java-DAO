/**
 * 
 * @author Abrahim Djordjevic
 * the BookMenu object is derived from the console menu class and will inherit methods from it
 */

import java.sql.SQLException;
import java.util.ArrayList;

public class BookMenu extends ConsoleMenu {
	//super constructor
	public BookMenu(String[] options) {
		super(options);
	}
	
	//the string input method is used to obtain string input from users 
	public String StringInput() {
		String result = In.nextLine();
		return result;
	}
	
	//the int input method is used to obtain integer input from users
	public int IntInput() {
		int result = In.nextInt();
		return result;
	}
	
	//NewBook is a method for obtaining the variables needed for adding a new book to the database
	public Book NewBook() {
		System.out.println("Please enter the books ID");
		int bookID = IntInput();
		
		System.out.println("Please enter the books title");
		String title = StringInput();
		
		System.out.println("Please enter the books author");
		String author = StringInput();
		
		System.out.println("Please enter the year the book was published");
		int year = IntInput();
		
		System.out.println("Please enter the books edition");
		int edition = IntInput();
		
		System.out.println("Please enter the books publisher");
		String publisher = StringInput();
		
		System.out.println("Please enter the books isbn");
		String isbn = StringInput();
		
		System.out.println("Please enter the type of cover this book has");
		String cover = StringInput();
		
		System.out.println("Please enter the condition the book is in");
		String condition = StringInput();
		
		System.out.println("Please enter the books price");
		int price = IntInput();
		
		System.out.println("Please enter any notes about the book");
		String notes = StringInput();
		
		Book Book = new Book(bookID, title, author, year, edition, publisher, isbn, cover, condition, price, notes);
		return Book;
	}
	
	//NewDetails is a method for updating an existing book
	public String[] NewDetails() {
		String[] newDetails = new String[2];
		System.out.println("Please enter the column that needs to be updated");
		newDetails[0] = In.nextLine();
		System.out.println("Please enter the new value");
		newDetails[1] = In.nextLine();
		return newDetails;
	}
	
	//the main method presents the options for the menu as well as the code for linking the console menu to the data access object
	public static void main(String[] args) throws SQLException{ 
		int ID = 0;
		int choice = 0;
		BookDAO dao = new BookDAO();
		String[] options = {"Retrieve all books", "Search for book", "Insert new book into database", 
							"Update existing book details", "Delete book from database"};
		BookMenu bookMenu = new BookMenu(options);
		bookMenu.setFinalOption("Exit");
		bookMenu.setTitle("Book Inventory");
		while(choice != 6) {
			bookMenu.displayMenu();
			choice = bookMenu.userSelection("Enter choice >");
			switch(choice) {
				case 1:
					ArrayList<Book> allBooks = dao.getAllBooks();
					for (Book b : allBooks) {
						System.out.println("------------------");
						System.out.println(b);
					}
					break;
				
				case 2:
					System.out.println("Please enter the Books ID:");
					ID = bookMenu.itemSelection();
					Book book = dao.getBook(ID);
					System.out.println("------------------");
					System.out.println(book);
					break;
				
				case 3:
					Book newBook = bookMenu.NewBook();
					boolean inTest = dao.insertBook(newBook);
					if(inTest){
						System.out.println("Record inserted successfully");
					} else {
						System.out.println("Error");
				    }
					break;
				
				case 4:
					System.out.println("Please enter the ID of the book that needs updating");
					ID = In.nextInt();
					String[] Details = bookMenu.NewDetails();
					boolean upTest = dao.updateBook(ID, Details);
					if(upTest){
						System.out.println("Record updated successfully");
					} else {
						System.out.println("Error");
					}
					break;
						
				case 5:
					System.out.println("Please enter the Books ID:");
					ID = bookMenu.itemSelection();
					boolean delTest = dao.deleteBook(ID);
					if(delTest){
						System.out.println("Record deleted successfully");
					} else {
						System.out.println("Error");
					}
					break;
					
				case 6:
					System.out.println("You have chosen to quit");
					break;
			}
		}
	}
}