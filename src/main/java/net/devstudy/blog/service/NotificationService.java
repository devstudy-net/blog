package net.devstudy.blog.service;
/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 * @version 1.0
 */
public interface NotificationService {

	void sendNotification(String title, String content);
	
	void shutdown();
}
