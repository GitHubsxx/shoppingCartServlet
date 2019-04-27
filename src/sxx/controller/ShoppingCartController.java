package sxx.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sxx.service.BookService;
/**
 * 购物车servlet
 * author:sxx
 * */
public class ShoppingCartController extends HttpServlet{
	private BookService service = new BookService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.print("访问开始");
		Map books = service.getAll();
		//放到request域中
		req.setAttribute("books", books);
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
