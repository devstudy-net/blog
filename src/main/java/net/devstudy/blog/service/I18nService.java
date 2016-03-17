package net.devstudy.blog.service;

import java.util.Locale;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 * @version 1.0
 */
public interface I18nService {
	
	String getMessage(String key, Locale locale, Object... args);
}
