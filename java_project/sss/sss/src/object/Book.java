package object;

public class Book {
	private int		bookid;		 //	å ������ȣ
	private String  bookName;	 // å �̸�
	private int 	price;		 // å ����
	private String  writer;		 // å ����
	private String  category;	 // å ī�װ�
	private String  publisher;	 // å ����
	private int		stock;		 // å ���
	
	public Book(int bookid, String bookName, int price, String writer, String category, String publisher, int stock) {
		super();
		this.bookid = bookid;
		this.bookName = bookName;
		this.price = price;
		this.writer = writer;
		this.category = category;
		this.publisher = publisher;
		this.stock = stock;
	}
	
	
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookName=" + bookName + ", price=" + price + ", writer=" + writer
				+ ", category=" + category + ", publisher=" + publisher + ", stock=" + stock + "]";
	}


	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}	
