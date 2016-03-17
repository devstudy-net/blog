package net.devstudy.blog.form;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

import net.devstudy.blog.exception.ValidateException;
import net.devstudy.blog.service.I18nService;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 * @version 1.0
 */
public class ContactForm extends AbstractForm {
	private String name;
	private String email;
	private String text;
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getText() {
		return text;
	}
	@Override
	public void validate(I18nService i18nService) throws ValidateException {
		if(!EmailValidator.getInstance().isValid(email)) {
			throw new ValidateException("Email is invalid");
		}
		if(StringUtils.isBlank(name)) {
			throw new ValidateException("Name is required");
		}
		if(StringUtils.isBlank(text)) {
			throw new ValidateException("Text is required");
		}
	}
}
