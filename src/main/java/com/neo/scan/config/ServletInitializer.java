package com.neo.scan.config;

import java.io.InputStream;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.neo.util.ConstantParams;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// config log file for all log want to log file
		InputStream io = null;
		io = this.getClass().getClassLoader().getResourceAsStream(ConstantParams.LOG4J_FILE);
		PropertyConfigurator.configure(io);

		// Cookie filter Register
		FilterRegistration encodingFilter = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
		encodingFilter.addMappingForUrlPatterns(null, false, "*");
		encodingFilter.setInitParameter("encoding", "UTF-8");
		encodingFilter.setInitParameter("forceEncoding", "true");
		servletContext.setInitParameter("throwExceptionIfNoHandlerFound", "true");
		encodingFilter.addMappingForUrlPatterns(null, true, "/*");
		super.onStartup(servletContext);
	}
}
