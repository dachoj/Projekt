package Ksiegarnia.projekt.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Ksiegarnia.projekt.obiekty.Book;

public class Database {

	private Connection connection;
	private Statement statement;
	private String url = "jdbc:hsqldb:hsql://localhost/workdb";
	private ResultSet rs;
	private String createTable = "Create table Books (title varchar(40),kind varchar(20),serial varchar(4),dateOfPrint varchar(20),pages int,own boolean,quantity int);";
    PreparedStatement addBook;
    PreparedStatement removeBook;
    PreparedStatement getBooks;
	
	
	public Database() {
		try {
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();

			rs = connection.getMetaData().getTables(null, null, null, null);

			boolean tableExists = false;
			while (rs.next()) {
				if ("Books".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}

			if (!tableExists) {
				statement.executeUpdate(createTable);

			}
          addBook=connection.prepareStatement("insert into Books (title,kind,serial,dateOfPrint,pages,own,quantity) values (?,?,?,?,?,?,?);");
          removeBook=connection.prepareStatement("delete from Books where serial = ?");
          getBooks=connection.prepareStatement("select * from Books");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean addBook(Book b){
		try {
			addBook.setString(1, b.getTitle());
			addBook.setString(2, b.getKind());
			addBook.setString(3, b.getSerial());
			addBook.setString(4, b.getDateOfPrint());
			addBook.setInt(5, b.getPages());
			addBook.setBoolean(6, b.isOwn());
			addBook.setInt(7, b.getQuantity());
			return addBook.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}	
	public boolean removeBook(Book b){
		try {
			removeBook.setString(1, b.getSerial());				
			return removeBook.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
}
	public List<Book> getBooks(){
		ArrayList<Book> result=new ArrayList<Book>(); 
		
		try {
			ResultSet rs=getBooks.executeQuery();
			while (rs.next()){
				Book b = new Book(rs.getString("title"),rs.getString("kind"),rs.getString("serial"),rs.getString("dateOfPrint"),rs.getInt("pages"),rs.getBoolean("own"),rs.getInt("quantity"));
				result.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		return result;
	}
}
