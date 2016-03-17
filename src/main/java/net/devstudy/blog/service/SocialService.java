package net.devstudy.blog.service;

import net.devstudy.blog.model.SocialAccount;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 * @version 1.0
 */
public interface SocialService {

	SocialAccount getSocialAccount(String authToken);
}
