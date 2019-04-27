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

/*删除书*/
public class DeleteBookController extends HttpServlet{
private BookService service = new BookService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.print("访问开始");
		//获取得到用户想要删除哪个书本的id
		String id = req.getParameter("bookid");

		//获取该用户相对应的购物车对象
		Cart cart = (Cart) req.getSession().getAttribute("cart");

		try {
		  //删除购物车的商品，也应该是在BusinessService中有的功能，于是乎又回到BusinessService中写代码
		  service.deleteBook(id, cart);

		  //删除购物车的商品后，也应该直接跳转回去购物车的显示页面中
		  req.getRequestDispatcher("/WEB-INF/listCart.jsp").forward(req, resp);


		} catch (CartNotFoundException e) {
			req.setAttribute("message", "购物车空了！");
			req.getRequestDispatcher("/message.jsp").forward(req, resp);

		} catch (Exception e) {
		  e.printStackTrace();
		  req.setAttribute("message", "删除中出现了异常～待会再试试呗！");
		  req.getRequestDispatcher("/message.jsp").forward(req, resp);
		}
		//转发到页面
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
