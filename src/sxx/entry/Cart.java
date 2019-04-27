package sxx.entry;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*���ﳵ*/
public class Cart {
	//k:bookId value:book
	private Map<String,CartItem> map = new LinkedHashMap<String, CartItem>();
	private Double totalPrice;//���ﳵ�ܼ�

	//��ӹ��ﳵ
	public void addCart(Book book){
		CartItem ct = this.map.get(book.getId());
		if(ct !=null){
			ct.setItem(ct.getItem()+1);//����+1
		}else{
			CartItem ct_ = new CartItem();
			ct_.setBook(book);
			ct_.setItem(1);
			map.put(book.getId(), ct_);
		}
	}
	public Map<String, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	//����ܼ۸�
	public Double getTotalPrice() {
		double total = 0D;
		if(this.getMap() !=null){
			Iterator<Entry<String, CartItem>> it = map.entrySet().iterator();
			if(it.hasNext()){
				Entry<String, CartItem> en = it.next();
				CartItem ct = en.getValue();
				total+=ct.getPrice();
			}
		}
		return total;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
