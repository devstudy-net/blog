package net.devstudy.blog.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.devstudy.blog.service.NotificationService;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
class DemoNotificationService implements NotificationService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoNotificationService.class);

	@Override
	public void sendNotification(String title, String content) {
		LOGGER.info("New comment: title=" + title + ", content=" + content);
	}

	@Override
	public void shutdown() {
		// do nothing
	}
}
