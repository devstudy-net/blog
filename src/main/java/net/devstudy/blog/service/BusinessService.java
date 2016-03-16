package net.devstudy.blog.service;

import java.util.Map;

import net.devstudy.blog.entity.Article;
import net.devstudy.blog.entity.Category;
import net.devstudy.blog.exception.RedirectToValidUrlException;
import net.devstudy.blog.model.Items;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 * @version 1.0
 */
public interface BusinessService {

	Map<Integer, Category> mapCategories();
	
	Items<Article> listArticles(int offset, int limit);
	
	Items<Article> listArticlesByCategory(String categoryUrl, int offset, int limit);
	
	Category findCategoryByUrl(String categoryUrl);
	
	Items<Article> listArticlesBySearchQuery(String searchQuery, int offset, int limit);
	
	Article viewArticle(Long idArticle, String requestUrl) throws RedirectToValidUrlException;
}
