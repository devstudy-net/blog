package net.devstudy.blog.exception;
/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 * @version 1.0
 */
public class ValidateException extends Exception {
	private static final long serialVersionUID = 5113543063260048361L;

	public ValidateException(String message) {
		super(message);
	}

	public ValidateException(Throwable cause) {
		super(cause);
	}

	public ValidateException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
