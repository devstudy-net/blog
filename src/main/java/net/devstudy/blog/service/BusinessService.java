package net.devstudy.blog.service;

import java.util.Map;

import net.devstudy.blog.entity.Category;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 * @version 1.0
 */
public interface BusinessService {

	Map<Integer, Category> mapCategories();
}
