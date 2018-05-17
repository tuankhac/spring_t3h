package com.neo.scan.config;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.neo.util.DataSourceCategory;
import com.neo.util.ResourceInjection;
import com.neo.util.RoutingDataSource;

@EnableWebMvc
@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.neo.scan" })
@PropertySource(value = { "classpath:databases.properties", "classpath:sql.properties" })
// @EnableJpaRepositories(basePackages="com.neo.scan.repository",
// entityManagerFactoryRef="emf")
public class WebConfig extends WebMvcConfigurerAdapter {
	private static final Charset UTF8 = Charset.forName("UTF-8");

	/*
	 * config all final variable for database
	 */
	private static final String DRIVER_CLASS_NAME = "jdbc.driverClassName";

	private static final String PROPERTY_NAME_CAT_DATABASE_URL = "spring.jdbc.url";
	private static final String PROPERTY_NAME_CAT_DATABASE_USER = "spring.jdbc.username";
	private static final String PROPERTY_NAME_CAT_DATABASE_PASSWORD = "spring.jdbc.password";

	@Autowired
	private Environment environment;

	// @Autowired
	// private ResourceInjection resourceInjection;

	@Bean
	public ResourceInjection resourceInjection() {
		return new ResourceInjection();
	}

	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}

	@Bean
	public MessageSource messageSources() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("MessageResources");

		return messageSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		return jdbcTemplate;
	}

	@Autowired
	@Bean(name = "dataSource")
	public DataSource dataSource() {
		RoutingDataSource dataSource = new RoutingDataSource();
		Map<Object, Object> dsMap = new HashMap<Object, Object>();
		dsMap.put(DataSourceCategory.FJL, catDataSource());
		dataSource.setTargetDataSources(dsMap);
		System.out.println("## Server getDataSource: " + dataSource);
		return dataSource;
	}

	public DataSource catDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty(DRIVER_CLASS_NAME));
		dataSource.setUrl(environment.getRequiredProperty(PROPERTY_NAME_CAT_DATABASE_URL));
		dataSource.setUsername(environment.getRequiredProperty(PROPERTY_NAME_CAT_DATABASE_USER));
		dataSource.setPassword(environment.getRequiredProperty(PROPERTY_NAME_CAT_DATABASE_PASSWORD));
		return dataSource;
	}

	// Transaction Manager
	@Autowired
	@Bean(name = "transactionManager")
	public DataSourceTransactionManager getTransactionManager(DataSource dataSource) {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
		return transactionManager;
	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public static PropertyPlaceholderConfigurer properties() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		Resource[] resources = new ClassPathResource[] { new ClassPathResource("sql.properties") };
		ppc.setLocations(resources);
		ppc.setIgnoreUnresolvablePlaceholders(true);
		return ppc;
	}

	@Bean
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		//localeResolver.setDefaultLocale(Locale.ENGLISH);
		localeResolver.setCookieName("my-locale-cookie");
		localeResolver.setCookieMaxAge(3600);
		return localeResolver;
	}

	@Bean
	public LocaleChangeInterceptor localeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public HandlerInterceptorAdapter handlerInterceptorAdapter() {
		HandlerInterceptorAdapter handler = new HandlerInterceptorAdapter() {

			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {
				//System.out.println(request.getParameter("crud_type"));
				//System.out.println(environment.getRequiredProperty("list_layds_menu_theo_nguoidung"));
				System.out.println(request.getAttribute("an"));
				request.setAttribute("visitorCounter", 1);
				return true;
			}
		};
		return handler;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeInterceptor());
		//registry.addInterceptor(handlerInterceptorAdapter());
		registry.addInterceptor(new MyHandlerInterceptorAdapter());
	}

	// Cấu hình UTF-8 cho các trang.
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
		stringConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "plain", UTF8)));
		converters.add(stringConverter);

		// Add other converters ...
	}

	/*
	 * Cấu hình để sử dụng các file nguồn tĩnh (html, image, ..) Tương đương với
	 * <mvc:resources/> trong cấu hình sử dụng XML.
	 * 
	 * 
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/scripts/**").addResourceLocations("/scripts/");
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/");
		registry.addResourceHandler("/style/**").addResourceLocations("/style/");
	}

	// Tương đương cấu hình trong xml.
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
