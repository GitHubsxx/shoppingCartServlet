package sxx.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sxx.entry.Cart;
import sxx.exception.CartNotFoundException;
import sxx.service.BookService;

/*����౾*/
public class BuyManyBookController extends HttpServlet{
	private BookService service = new BookService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("���ʿ�ʼ");
		//��ȡ�õ��û���Ҫ�޸���һ�����id�����Ӧ������
		String id = request.getParameter("bookid");
		String quantity = request.getParameter("quantity");

		//�õ���ǰ�û��Ĺ��ﳵ
		Cart cart = (Cart) request.getSession().getAttribute("cart");


		try {

		  //����BusinessService�ķ���ȥ�޸Ķ�Ӧ������
		  service.updateQuantity(id, cart, quantity);

		  //�޸�������ת��ȥ���ﳵ��ҳ����
		  request.getRequestDispatcher("/WEB-INF/listCart.jsp").forward(request, response);

		} catch (CartNotFoundException e) {
		  e.printStackTrace();
		  request.setAttribute("message", "���ﳵ�ǿյģ�");
		  //ת����ҳ��
		  request.getRequestDispatcher("/WEB-INF/buyManyBook.jsp").forward(request, response);
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
