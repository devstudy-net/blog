package net.devstudy.blog.form;

import java.util.Locale;

import net.devstudy.blog.exception.ValidateException;
import net.devstudy.blog.model.AbstractModel;
import net.devstudy.blog.service.I18nService;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public abstract class AbstractForm extends AbstractModel {
	protected Locale locale;

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public Locale getLocale() {
		return locale;
	}

	public void validate(I18nService i18nService) throws ValidateException {

	}
}
