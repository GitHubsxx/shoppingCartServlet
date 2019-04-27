package sxx.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sxx.entry.Cart;
import sxx.service.BookService;

/*添加书*/
public class BuyBookController extends HttpServlet{
private BookService service = new BookService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.print("访问开始");
		//获取得到传递过来的id
		String id = req.getParameter("bookid");

		//把用户想要买的书放到购物车上
		//用户不单单只有一个，要让购物车上只为当前的用户服务，就需要用到会话跟踪技术了
		Cart cart = (Cart) req.getSession().getAttribute("cart");

		//如果当前用户还没有点击过购买的商品，那么是用户的购物车是空的
		if (cart == null) {
		  cart = new Cart();
		  req.getSession().setAttribute("cart", cart);
		}

		//调用BussinessService的方法，实现购买功能！
		service.buyBook(id, cart);
		//转发到页面
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
