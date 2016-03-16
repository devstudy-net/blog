package net.devstudy.blog.controller.page;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.devstudy.blog.Constants;
import net.devstudy.blog.controller.AbstractController;
import net.devstudy.blog.entity.Article;
import net.devstudy.blog.entity.Category;
import net.devstudy.blog.model.Items;
import net.devstudy.blog.model.Pagination;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 * @version 1.0
 */
@WebServlet({"/news", "/news/*"})
public class NewsController extends AbstractController {
	private static final long serialVersionUID = 216595477139640552L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int offset = getOffset(req, Constants.LIMIT_ARTICLES_PER_PAGE);
		String requestUrl = req.getRequestURI();
		Items<Article> items = null;
		if(requestUrl.endsWith("/news") || requestUrl.endsWith("/news/")){
			items = getBusinessService().listArticles(offset, Constants.LIMIT_ARTICLES_PER_PAGE);
			req.setAttribute("isNewsPage", Boolean.TRUE);
		}
		else{
			String categoryUrl = requestUrl.replace("/news", "");
			Category category = getBusinessService().findCategoryByUrl(categoryUrl);
			if (category == null) {
				resp.sendRedirect("/404?url="+requestUrl);
				return;
			}
			items = getBusinessService().listArticlesByCategory(categoryUrl, offset, Constants.LIMIT_ARTICLES_PER_PAGE);
			req.setAttribute("selectedCategory", category);
		}
		req.setAttribute("list", items.getItems());
		Pagination pagination = new Pagination.Builder(requestUrl+"?", offset, items.getCount()).withLimit(Constants.LIMIT_ARTICLES_PER_PAGE).build();
		req.setAttribute("pagination", pagination);
		forwardToPage("news.jsp", req, resp);
	}
}
