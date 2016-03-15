package net.devstudy.blog.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;

import net.devstudy.blog.dao.mapper.MapCategoryMapper;
import net.devstudy.blog.entity.Category;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 * @version 1.0
 */
public final class SQLDAO {
	private final QueryRunner sql = new QueryRunner();
	
	public Map<Integer, Category> mapCategories(Connection c) throws SQLException {
		return sql.query(c, "select * from category", new MapCategoryMapper());
	}
}
