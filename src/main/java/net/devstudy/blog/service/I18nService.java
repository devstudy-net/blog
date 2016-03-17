package net.devstudy.blog.service;

import java.util.Locale;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface I18nService {

	String getMessage(String key, Locale locale, Object... args);
}
