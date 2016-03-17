package net.devstudy.blog.controller.page;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.devstudy.blog.controller.AbstractController;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@WebServlet({ "/error", "/404" })
public class ErrorController extends AbstractController {
	private static final long serialVersionUID = 5370467887808025258L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean is404 = "/404".equals(req.getRequestURI());
		req.setAttribute("is404", is404);
		req.setAttribute("url", req.getParameter("url"));
		forwardToPage("error.jsp", req, resp);
	}
}
