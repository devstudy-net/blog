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
 * @version 1.0
 */
@WebServlet("/error")
public class ErrorController extends AbstractController {
	private static final long serialVersionUID = 5370467887808025258L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forwardToPage("error.jsp", req, resp);
	}
}
