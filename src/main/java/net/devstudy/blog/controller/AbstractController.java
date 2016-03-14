package net.devstudy.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.devstudy.blog.service.BusinessService;
import net.devstudy.blog.service.impl.ServiceManager;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 * @version 1.0
 */
public abstract class AbstractController extends HttpServlet {
	private static final long serialVersionUID = 53415732680855255L;
	protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
	private BusinessService businessService;
	public final BusinessService getBusinessService() {
		return businessService;
	}
	@Override
	public void init() throws ServletException {
		businessService = ServiceManager.getInstance(getServletContext()).getBusinessService();
	}
	public final void forwardToPage (String jspPage, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("currentPage", "page/"+jspPage);
		req.getRequestDispatcher("/WEB-INF/JSP/page-template.jsp").forward(req, resp);
	}
	
	public final void forwardToFragment (String jspPage, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/JSP/fragment/"+jspPage).forward(req, resp);
	}
}
