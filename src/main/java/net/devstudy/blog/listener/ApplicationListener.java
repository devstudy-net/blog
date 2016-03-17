package net.devstudy.blog.listener;

import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.devstudy.blog.Constants;
import net.devstudy.blog.entity.Category;
import net.devstudy.blog.service.impl.ServiceManager;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@WebListener
public final class ApplicationListener implements ServletContextListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServiceManager serviceManager = ServiceManager.getInstance(sce.getServletContext());
		Map<Integer, Category> map = serviceManager.getBusinessService().mapCategories();
		sce.getServletContext().setAttribute("social_googleplus_clientId", serviceManager.getApplicationProperty("social.googleplus.clientId"));
		sce.getServletContext().setAttribute(Constants.CATEGORY_MAP, map);
		LOGGER.info("Application started");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServiceManager.getInstance(sce.getServletContext()).destroy();
		LOGGER.info("Application destroyed");
	}
}
