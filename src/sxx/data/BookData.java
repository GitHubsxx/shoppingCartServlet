package sxx.data;

import java.util.LinkedHashMap;
import java.util.Map;

import sxx.entry.Book;

/*ģ�����ݿ�*/
public class BookData {
	private static Map<String, Book> map = new LinkedHashMap<>();

	static {
	  map.put("1",new Book("1", "java", "sxx", "����", 99D));
	  map.put("2",new Book("2", "javaweb", "zhangsan", "���õ���", 44D));
	  map.put("3",new Book("3", "ajax", "lisi", "һ���", 66D));
	  map.put("4",new Book("4", "spring", "wangwu", "����", 77D));
	}

	public static Map<String, Book> getAll() {


	  return map;
	}
}
