package sxx.entry;
/*购物项：同一本书可以买多本*/
public class CartItem {
	private Book book;
	private Integer item;
	private Double price;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getItem() {
		return item;
	}
	public void setItem(Integer item) {
		this.item = item;
	}
	public Double getPrice() {
		return book.getPrice()*item;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	

}
