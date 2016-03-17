package net.devstudy.blog.service;

import net.devstudy.blog.model.SocialAccount;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface SocialService {

	SocialAccount getSocialAccount(String authToken);
}
