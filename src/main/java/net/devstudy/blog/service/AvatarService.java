package net.devstudy.blog.service;

import java.io.IOException;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 * @version 1.0
 */
public interface AvatarService {

	int AVATAR_SIZE_IN_PX = 80;
	
	String MEDIA_AVATAR_PREFFIX = "/media/avatar/";

	String downloadAvatar (String url) throws IOException;
	
	boolean deleteAvatarIfExists (String avatarPath);
}
