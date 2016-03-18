package net.devstudy.blog.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import net.devstudy.blog.entity.Account;
import net.devstudy.blog.entity.Article;
import net.devstudy.blog.entity.Comment;
import net.devstudy.blog.exception.ApplicationException;
import net.devstudy.blog.exception.ValidateException;
import net.devstudy.blog.form.CommentForm;
import net.devstudy.blog.model.SocialAccount;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
class DemoBusinessService extends BusinessServiceImpl {

	DemoBusinessService(ServiceManager serviceManager) {
		super(serviceManager);
	}

	@Override
	public Comment createComment(CommentForm form) throws ValidateException {
		form.validate(i18nService);
		try (Connection c = dataSource.getConnection()) {
			SocialAccount socialAccount = socialService.getSocialAccount(form.getAuthToken());
			Account a = new Account();
			a.setId(0L);
			a.setAvatar(socialAccount.getAvatar());
			a.setCreated(new Timestamp(System.currentTimeMillis()));
			a.setEmail(socialAccount.getEmail());
			a.setName(socialAccount.getName());
			Comment comment = new Comment(form.getIdArticle(), a, form.getContent(), new Timestamp(System.currentTimeMillis()));
			Article article = sql.findArticleForNewCommentNotification(c, form.getIdArticle());
			sendNewCommentNotification(article, form.getContent(), form.getLocale());
			return comment;
		} catch (SQLException e) {
			throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
		}
	}
}
