package sxx.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sxx.entry.Cart;
import sxx.exception.CartNotFoundException;
import sxx.service.BookService;

/*ɾ����*/
public class DeleteBookController extends HttpServlet{
private BookService service = new BookService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.print("���ʿ�ʼ");
		//��ȡ�õ��û���Ҫɾ���ĸ��鱾��id
		String id = req.getParameter("bookid");

		//��ȡ���û����Ӧ�Ĺ��ﳵ����
		Cart cart = (Cart) req.getSession().getAttribute("cart");

		try {
		  //ɾ�����ﳵ����Ʒ��ҲӦ������BusinessService���еĹ��ܣ����Ǻ��ֻص�BusinessService��д����
		  service.deleteBook(id, cart);

		  //ɾ�����ﳵ����Ʒ��ҲӦ��ֱ����ת��ȥ���ﳵ����ʾҳ����
		  req.getRequestDispatcher("/WEB-INF/listCart.jsp").forward(req, resp);


		} catch (CartNotFoundException e) {
			req.setAttribute("message", "���ﳵ���ˣ�");
			req.getRequestDispatcher("/message.jsp").forward(req, resp);

		} catch (Exception e) {
		  e.printStackTrace();
		  req.setAttribute("message", "ɾ���г������쳣�������������£�");
		  req.getRequestDispatcher("/message.jsp").forward(req, resp);
		}
		//ת����ҳ��
		req.getRequestDispatcher("/WEB-INF/listBook.jsp").forward(req, resp);
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
