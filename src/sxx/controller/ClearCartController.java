package sxx.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sxx.entry.Cart;
import sxx.exception.CartNotFoundException;
import sxx.service.BookService;

/*��չ��ﳵ*/
public class ClearCartController extends HttpServlet{
	private BookService service = new BookService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("���ʿ�ʼ");
		//�õ��û����Ӧ�Ĺ��ﳵ
		Cart cart = (Cart) request.getSession().getAttribute("cart");

		//�������ӦBusinessService�ķ���

		try {

		  //��չ��ﳵ��ʵ���Ͼ�����չ��ﳵ��Map�����е�Ԫ�ء�
		  service.clearCart(cart);

		  //���ظ����ﳵ��ʾҳ��
		  request.getRequestDispatcher("/WEB-INF/listCart.jsp").forward(request, response);

		} catch (CartNotFoundException e) {
		  e.printStackTrace();
		  request.setAttribute("message", "���ﳵ�ǿյģ�");
		  request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	
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
