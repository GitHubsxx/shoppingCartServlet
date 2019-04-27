package sxx.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sxx.entry.Cart;
import sxx.exception.CartNotFoundException;
import sxx.service.BookService;

/*清空购物车*/
public class ClearCartController extends HttpServlet{
	private BookService service = new BookService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("访问开始");
		//得到用户相对应的购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");

		//调用相对应BusinessService的方法

		try {

		  //清空购物车【实际上就是清空购物车的Map集合中的元素】
		  service.clearCart(cart);

		  //返回给购物车显示页面
		  request.getRequestDispatcher("/WEB-INF/listCart.jsp").forward(request, response);

		} catch (CartNotFoundException e) {
		  e.printStackTrace();
		  request.setAttribute("message", "购物车是空的！");
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
