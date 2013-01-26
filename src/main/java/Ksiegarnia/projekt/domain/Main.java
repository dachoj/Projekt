package Ksiegarnia.projekt.domain;

import java.util.List;

import Ksiegarnia.projekt.manager.BookManager;
import Ksiegarnia.projekt.obiekty.Book;

public class Main {


	public static void main(String[] args) {
		Book ksiazka = new Book ("Harry Potter","fantasy","0001","12.12.2012",300,true,10);
		BookManager manager = new BookManager ();
		manager.addBook(ksiazka);
		
		Book ksiazka2 = new Book ("Wiedzmin","fantasy","0002","11.11.2011",200,true,5);
		manager.addBook(ksiazka2);
		//manager.removeBook(ksiazka); 
		List<Book>lista= manager.getAll();	
		for (Book b: lista){
			System.out.println(b);
		}


	}

}
