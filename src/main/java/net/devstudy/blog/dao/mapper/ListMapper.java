package net.devstudy.blog.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.AbstractListHandler;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public final class ListMapper<T> extends AbstractListHandler<T> {
	private final AbstractMapper<T> handler;

	public ListMapper(AbstractMapper<T> handler) {
		super();
		this.handler = handler;
		this.handler.shouldBeIterateThroughResultSet = false;
	}

	@Override
	protected T handleRow(ResultSet rs) throws SQLException {
		return handler.handle(rs);
	}
}
