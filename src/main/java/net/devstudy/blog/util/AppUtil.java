package net.devstudy.blog.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class AppUtil {
	public static void loadProperties(Properties props, String classPathUrl) {
		try (InputStream in = AppUtil.class.getClassLoader().getResourceAsStream(classPathUrl)) {
			props.load(in);
		} catch (IOException e) {
			throw new IllegalArgumentException("Can't load properties from classpath:" + classPathUrl, e);
		}
	}
}
