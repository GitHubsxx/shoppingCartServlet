package sxx.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sxx.entry.Cart;
import sxx.service.BookService;

/*�����*/
public class BuyBookController extends HttpServlet{
private BookService service = new BookService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.print("���ʿ�ʼ");
		//��ȡ�õ����ݹ�����id
		String id = req.getParameter("bookid");

		//���û���Ҫ�����ŵ����ﳵ��
		//�û�������ֻ��һ����Ҫ�ù��ﳵ��ֻΪ��ǰ���û����񣬾���Ҫ�õ��Ự���ټ�����
		Cart cart = (Cart) req.getSession().getAttribute("cart");

		//�����ǰ�û���û�е�����������Ʒ����ô���û��Ĺ��ﳵ�ǿյ�
		if (cart == null) {
		  cart = new Cart();
		  req.getSession().setAttribute("cart", cart);
		}

		//����BussinessService�ķ�����ʵ�ֹ����ܣ�
		service.buyBook(id, cart);
		//ת����ҳ��
		req.getRequestDispatcher("/WEB-INF/buyBook.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().write("haha");
		System.out.print("chushihua");
		//resp.sendRedirect("/index.jsp");
		super.doGet(req, resp);
	}

}
