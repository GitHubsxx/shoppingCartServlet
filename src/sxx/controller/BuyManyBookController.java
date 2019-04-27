package sxx.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sxx.entry.Cart;
import sxx.exception.CartNotFoundException;
import sxx.service.BookService;

/*购买多本*/
public class BuyManyBookController extends HttpServlet{
	private BookService service = new BookService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("访问开始");
		//获取得到用户想要修改哪一本书的id和相对应的数量
		String id = request.getParameter("bookid");
		String quantity = request.getParameter("quantity");

		//得到当前用户的购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");


		try {

		  //调用BusinessService的方法去修改对应的数据
		  service.updateQuantity(id, cart, quantity);

		  //修改完再跳转回去购物车的页面中
		  request.getRequestDispatcher("/WEB-INF/listCart.jsp").forward(request, response);

		} catch (CartNotFoundException e) {
		  e.printStackTrace();
		  request.setAttribute("message", "购物车是空的！");
		  //转发到页面
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
