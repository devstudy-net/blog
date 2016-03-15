package net.devstudy.blog.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.devstudy.blog.entity.Article;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 * @version 1.0
 */
public class ArticleMapper extends AbstractMapper<Article> {

	@Override
	public Article handleItem(ResultSet rs) throws SQLException {
		Article a = convert.toBean(rs, Article.class);
		a.setIdCategory(rs.getInt("id_category"));
		return a;
	}

}
