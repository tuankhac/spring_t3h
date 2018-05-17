package com.neo.scan.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyHandlerInterceptorAdapter extends HandlerInterceptorAdapter {
	 PropertiesConfiguration properties;
	public MyHandlerInterceptorAdapter() {
		init();
		//System.out.println("chay vao day");
	}

	private void init(){
		properties = new PropertiesConfiguration();
		try {
			//System.out.println(ServletContext.class.getClass().getResourceAsStream("classpath:sql.properties"));
			Resource resources = new ClassPathResource( "sql.properties" );
			properties.load(resources.getInputStream());
			//System.out.println(properties.getStringArray("role/index.list_param")[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String crud_type = request.getParameter("crud_type");
		//System.out.println(request.getSession().getAttribute("list_layds_menu_theo_nguoidung"));
		request.setAttribute("visitorCounter", 1);
		String[] list_param = properties.getStringArray(crud_type);
		for (int i = 0; i < list_param.length; i++) {
			String key = properties.getString(crud_type+ "."+list_param[i]);
//			System.out.println("key "+key);
			request.setAttribute(list_param[i], key.toString());
		}
		return true;
	}
}
