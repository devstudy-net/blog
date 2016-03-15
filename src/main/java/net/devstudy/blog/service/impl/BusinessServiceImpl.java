package net.devstudy.blog.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import net.devstudy.blog.dao.SQLDAO;
import net.devstudy.blog.entity.Category;
import net.devstudy.blog.exception.ApplicationException;
import net.devstudy.blog.service.BusinessService;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 * @version 1.0
 */
class BusinessServiceImpl implements BusinessService {
	private final DataSource dataSource;
	private final SQLDAO sql;
	
	BusinessServiceImpl(ServiceManager serviceManager) {
		super();
		this.dataSource = serviceManager.dataSource;
		this.sql = new SQLDAO();
	}

	@Override
	public Map<Integer, Category> mapCategories() {
		try (Connection c = dataSource.getConnection()) {
			return sql.mapCategories(c);
		} catch (SQLException e) {
			throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
		}
	}
}
