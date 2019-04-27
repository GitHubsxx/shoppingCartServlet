package sxx.service;

import java.util.Map;

import sxx.dao.BookDAO;
import sxx.entry.Book;
import sxx.entry.Cart;
import sxx.exception.CartNotFoundException;

public class BookService {
	private BookDAO dao = new BookDAO();

	public Map getAll(){
		return dao.getAll();
	}
	public Book getById(String id){
		return dao.getById(id);
	}
	/*
	    * 在购买书籍的时候，我们发现需要将书籍添加到购物车上
	    * 如果我们直接在Servlet上使用Cart实体对象的addBook()和BookDao对象的find()方法，是可以完成功能的
	    * 
	    * 但是，这样web层的程序就跟Dao层的耦合了，为了代码性的健壮性和解耦，我们在BusinessService中对他俩进行封装
	    * 
	    * 于是有了buyBook()这个方法！
	    * */

	/*把用户想买的书籍添加到当前用户的购物车上*/
	public void buyBook(String id, Cart cart) {

	  Book book = dao.getById(id);
	  cart.addCart(book);

	}
	/*用户要在购物车中删除某个购物项*/
public void deleteBook(String id, Cart cart) throws CartNotFoundException {

  //如果用户是直接访问DeleteCartBook的Servlet的，在session中是没有cart这个属性的！
  //告诉用户购物车是空的
  if (cart == null) {
    throw new CartNotFoundException("购物车为空");
  }

  //把购物项移除出去集合就行了！
  cart.getMap().remove(id);
}
public void updateQuantity(String id, Cart cart, String quantity) throws CartNotFoundException {


	  //如果用户是直接访问DeleteCartBook的Servlet的，在session中是没有cart这个属性的！
	  //告诉用户购物车是空的
	  if (cart == null) {
	    throw new CartNotFoundException("购物车为空");
	  }


	  //通过书的id获取得到购物车的购物项，再修改购物项的数量即可！（因为书的id和获取购物项的关键字是一致的！）
	  cart.getMap().get(id).setItem(Integer.parseInt(quantity));

	}
public void clearCart(Cart cart) throws CartNotFoundException {

	  //如果用户是直接访问DeleteCartBook的Servlet的，在session中是没有cart这个属性的！
	  //告诉用户购物车是空的
	  if (cart == null) {
	    throw new CartNotFoundException("购物车为空");
	  }

	  //清空所有的购物项
	  cart.getMap().clear();


	}
}
