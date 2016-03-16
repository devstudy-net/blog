package net.devstudy.blog.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.devstudy.blog.entity.Account;
import net.devstudy.blog.entity.Comment;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 * @version 1.0
 */
public class CommentMapper extends AbstractMapper<Comment> {
	private final boolean hasAccountData;

	public CommentMapper(boolean hasAccountData) {
		super();
		this.hasAccountData = hasAccountData;
	}

	@Override
	public Comment handleItem(ResultSet rs) throws SQLException {
		Comment comment = convert.toBean(rs, Comment.class);
		comment.setIdArticle(rs.getLong("id_article"));
		if (hasAccountData) {
			Account account = convert.toBean(rs, Account.class);
			account.setId(rs.getLong("id_account"));
			account.setCreated(rs.getTimestamp("accountCreated"));
			comment.setAccount(account);
		}
		return comment;
	}
}
