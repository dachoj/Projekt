package Ksiegarnia.projekt.manager;

import static org.junit.Assert.*;

import org.junit.Test;

import Ksiegarnia.projekt.obiekty.Book;

public class BookManagerTest {
	private BookManager manager = new BookManager();
    private static Book ksiazka1 = new Book(null, null, "0001", null, 0, false, 0);
    private static Book ksiazka2 = new Book(null, null, "0002", null, 0, false, 0);
	
	@Test
	public void testDodawaniaKsiazek() {
		manager.addBook(ksiazka2);
		int i = manager.getAll().size();
		manager.addBook(ksiazka2);
		assertEquals(i,manager.getAll().size()-1);
	}
	
	@Test
	public void testUsuwaniaKsiazek() {
		manager.addBook(ksiazka1);
		int i = manager.getAll().size();
		manager.removeBook(ksiazka1);
		assertEquals(i,manager.getAll().size()+1);
	}
	@Test
	public void testPokazywaniaKsiazek() {
		assertNotNull(manager.getAll());
		
	}
}
