package net.devstudy.blog.form;
/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 * @version 1.0
 */
public class CommentForm{
	private Long idArticle;
	private String content;
	private String authToken;
	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getContent() {
		return content;
	}
	public Long getIdArticle() {
		return idArticle;
	}
	public String getAuthToken() {
		return authToken;
	}
}
