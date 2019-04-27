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
	    * �ڹ����鼮��ʱ�����Ƿ�����Ҫ���鼮��ӵ����ﳵ��
	    * �������ֱ����Servlet��ʹ��Cartʵ������addBook()��BookDao�����find()�������ǿ�����ɹ��ܵ�
	    * 
	    * ���ǣ�����web��ĳ���͸�Dao�������ˣ�Ϊ�˴����ԵĽ�׳�Ժͽ��������BusinessService�ж��������з�װ
	    * 
	    * ��������buyBook()���������
	    * */

	/*���û�������鼮��ӵ���ǰ�û��Ĺ��ﳵ��*/
	public void buyBook(String id, Cart cart) {

	  Book book = dao.getById(id);
	  cart.addCart(book);

	}
	/*�û�Ҫ�ڹ��ﳵ��ɾ��ĳ��������*/
public void deleteBook(String id, Cart cart) throws CartNotFoundException {

  //����û���ֱ�ӷ���DeleteCartBook��Servlet�ģ���session����û��cart������Եģ�
  //�����û����ﳵ�ǿյ�
  if (cart == null) {
    throw new CartNotFoundException("���ﳵΪ��");
  }

  //�ѹ������Ƴ���ȥ���Ͼ����ˣ�
  cart.getMap().remove(id);
}
public void updateQuantity(String id, Cart cart, String quantity) throws CartNotFoundException {


	  //����û���ֱ�ӷ���DeleteCartBook��Servlet�ģ���session����û��cart������Եģ�
	  //�����û����ﳵ�ǿյ�
	  if (cart == null) {
	    throw new CartNotFoundException("���ﳵΪ��");
	  }


	  //ͨ�����id��ȡ�õ����ﳵ�Ĺ�������޸Ĺ�������������ɣ�����Ϊ���id�ͻ�ȡ������Ĺؼ�����һ�µģ���
	  cart.getMap().get(id).setItem(Integer.parseInt(quantity));

	}
public void clearCart(Cart cart) throws CartNotFoundException {

	  //����û���ֱ�ӷ���DeleteCartBook��Servlet�ģ���session����û��cart������Եģ�
	  //�����û����ﳵ�ǿյ�
	  if (cart == null) {
	    throw new CartNotFoundException("���ﳵΪ��");
	  }

	  //������еĹ�����
	  cart.getMap().clear();


	}
}
