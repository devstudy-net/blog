package net.devstudy.blog.service.impl;

import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.devstudy.blog.service.AvatarService;
import net.devstudy.blog.service.BusinessService;
import net.devstudy.blog.service.I18nService;
import net.devstudy.blog.service.NotificationService;
import net.devstudy.blog.service.SocialService;
import net.devstudy.blog.util.AppUtil;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 * @version 1.0
 */
public class ServiceManager {
	public static ServiceManager getInstance(ServletContext context) {
		ServiceManager instance = (ServiceManager) context.getAttribute(SERVICE_MANAGER);
		if (instance == null) {
			instance = new ServiceManager(context);
			context.setAttribute(SERVICE_MANAGER, instance);
		}
		return instance;
	}
	public void destroy() {
		try {
			dataSource.close();
		} catch (SQLException e) {
			LOGGER.error("Close dataSource failed: "+e.getMessage(), e);
		}
		
		LOGGER.info("ServiceManager instance destroyed");
		
	}
	public BusinessService getBusinessService() {
		return businessService;
	}
	
	public String getApplicationProperty(String property) {
		String value = applicationProperties.getProperty(property);
		if (value.startsWith("${sysEnv.")) {
			value = value.replace("${sysEnv.", "").replace("}", "");
			return System.getProperty(value, value);
		} else {
			return value;
		}
	}
	
	private static final String SERVICE_MANAGER = "SERVICE_MANAGER";
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManager.class);
	
	final Properties applicationProperties = new Properties();
	final ServletContext applicationContext;
	final BasicDataSource dataSource;
	final SocialService socialService;
	final AvatarService avatarService;
	final I18nService i18nService;
	final NotificationService notificationService;
	final BusinessService businessService;
	private ServiceManager(ServletContext context) {
		applicationContext = context;
		AppUtil.loadProperties(applicationProperties, "application.properties");
		dataSource = createBasicDataSource();
		socialService = new GooglePlusSocialService(this);
		avatarService = new FileStorageAvatarService(this);
		i18nService = new I18nServiceImpl();
		notificationService = new AsyncEmailNotificationService(this);
		businessService = new BusinessServiceImpl(this);
		LOGGER.info("ServiceManager instance created");
	}
	
	private BasicDataSource createBasicDataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDefaultAutoCommit(false);
		ds.setRollbackOnReturn(true);
		ds.setDriverClassName(getApplicationProperty("db.driver"));
		ds.setUrl(getApplicationProperty("db.url"));
		ds.setUsername(getApplicationProperty("db.username"));
		ds.setPassword(getApplicationProperty("db.password"));
		ds.setInitialSize(Integer.parseInt(getApplicationProperty("db.pool.initSize")));
		ds.setMaxTotal(Integer.parseInt(getApplicationProperty("db.pool.maxSize")));
		return ds;
	}
}
