package sxx.dao;

import java.util.Map;

import sxx.data.BookData;
import sxx.entry.Book;

public class BookDAO {
	//��ȡ���е���
	public Map getAll(){
		return BookData.getAll();
	}
	//����id��ȡ
	public Book getById(String id){
		return BookData.getAll().get(id);
	}
}
