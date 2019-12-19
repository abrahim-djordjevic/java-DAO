/**
 * the Book class is used to define a book object for each book stocked, this object will contain all relevant information about the book 
 * @author Abrahim Djordjevic
 *
 */

public class Book {
	// declare variables
	private int bookID, year, edition, price;
	private String title, author, publisher, isbn, cover, condition, notes;
	//constructor
	public  Book(int bookID, String title, String author, int year, int edition, 
	String publisher, String isbn, String cover, String condition, int price, 
	String notes) {
		this.bookID = bookID; 
		this.title = title; 
		this.author = author;
		this.year = year; 
		this.edition = edition; 
		this.publisher = publisher;
		this.isbn = isbn; 
		this.cover = cover; 
		this.condition = condition;
		this.price = price; 
		this.notes = notes;
	}
	//setter methods
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setEdition(int edition) {
		this.edition = edition;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void setCover(String cover) {
		this.cover = cover;
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setNotes(String notes) {
		this.notes = notes; 
	}
	//getter methods
	public int getBookID() {
		return bookID;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getEdition() {
		return edition;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public String getCover() {
		return cover;
	}
	
	public String getCondition() {
		return condition;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getNotes() {
		return notes;
	}
	//toString method
	public String toString() {
		return "Book ID is " + bookID + "\n" +
				"Title is " + title + "\n" +
				"Author is " + author + "\n" +
				"Publishing year is " + year + "\n" +
				"Edition is " + edition + "\n" +
				"Publised by " + publisher + "\n" +
				"ISBN is " + isbn + "\n" +
				"The cover is " + cover + "\n" +
				"The book is in " + condition + " condition \n" +
				"Price is £" + price + "\n" +
				notes + "\n";
	}
}