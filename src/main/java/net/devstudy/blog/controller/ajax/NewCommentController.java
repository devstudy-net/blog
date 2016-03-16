package net.devstudy.blog.controller.ajax;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.devstudy.blog.controller.AbstractController;
import net.devstudy.blog.entity.Comment;
import net.devstudy.blog.form.CommentForm;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 * @version 1.0
 */
@WebServlet("/ajax/comment")
public class NewCommentController extends AbstractController {
	private static final long serialVersionUID = 5627021600006044806L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CommentForm form = null; //TODO Create form from current request
		Comment comment = getBusinessService().createComment(form);
		req.setAttribute("comments", Collections.singleton(comment));
		forwardToFragment("comments.jsp", req, resp);
	}
}
