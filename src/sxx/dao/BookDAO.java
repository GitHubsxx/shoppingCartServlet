package sxx.dao;

import java.util.Map;

import sxx.data.BookData;
import sxx.entry.Book;

public class BookDAO {
	//获取所有的书
	public Map getAll(){
		return BookData.getAll();
	}
	//根据id获取
	public Book getById(String id){
		return BookData.getAll().get(id);
	}
}
