package Ksiegarnia.projekt.manager;

import java.util.List;

import Ksiegarnia.projekt.obiekty.Book;

public class BookManager {
	private Database db = new Database();

	public boolean addBook(Book book) {
		return db.addBook(book);

	}
	public boolean removeBook(Book book) {
		return db.removeBook(book);

	}
	public List<Book> getAll(){
		return db.getBooks();
		
	}
}