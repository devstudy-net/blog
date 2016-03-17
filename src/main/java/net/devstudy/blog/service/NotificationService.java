package net.devstudy.blog.service;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface NotificationService {

	void sendNotification(String title, String content);

	void shutdown();
}
