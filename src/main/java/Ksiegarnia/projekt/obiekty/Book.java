package Ksiegarnia.projekt.obiekty;


public class Book {
	
	private String title = "unknown";
	private String kind = "";
	private String serial = "";
	private String dateOfPrint = "";
	private int pages;
	private boolean own;
	private int quantity;
	
	
	public Book(String title, String kind, String serial, String dateOfPrint,
			int pages, boolean own, int quantity) {
		super();
		this.title = title;
		this.kind = kind;
		this.serial = serial;
		this.dateOfPrint = dateOfPrint;
		this.pages = pages;
		this.own = own;
		this.quantity = quantity;
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	public String getDateOfPrint() {
		return dateOfPrint;
	}
	public void setDateOfPrint(String dateOfPrint) {
		this.dateOfPrint = dateOfPrint;
	}
	
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	public boolean isOwn() {
		return own;
	}
	public void setOwn(boolean own) {
		this.own = own;
	}
	public String toString(){
		String s = String.format("%20s|%10s|%6s|%12s|%6s|%7s|%6s\n", title,kind,serial,dateOfPrint,pages,own,quantity);
		return s;
	}
	
	
}
