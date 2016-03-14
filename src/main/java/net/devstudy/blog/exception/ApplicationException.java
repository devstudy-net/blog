package net.devstudy.blog.exception;
/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 * @version 1.0
 */
public class ApplicationException extends RuntimeException {
	private static final long serialVersionUID = -3180716741910924439L;

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
