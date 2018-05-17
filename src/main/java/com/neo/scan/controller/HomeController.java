//package com.neo.scan.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.context.MessageSource;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import org.springframework.ui.Model;
//import java.util.Locale;
//import org.apache.log4j.Logger;
//
//@Controller
//public class HomeController {
//
//	@Autowired
//	private MessageSource messageSource;
//
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	private Logger logger = Logger.getLogger("app");
//
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String index(Locale locale, Model model) {
//		// jdbcTemplate.ex
//		// add parametrized message from controller
//		String welcome = messageSource.getMessage("welcome.message", new Object[] { "John Doe" }, locale);
//
//		model.addAttribute("message", welcome);
//
//		// obtain locale from LocaleContextHolder
//		Locale currentLocale = LocaleContextHolder.getLocale();
//		model.addAttribute("locale", currentLocale);
//
//		model.addAttribute("startMeeting", "10:30");
//		// Logger.getLogger("app").info("Khoi tao ghi log");
//		// ResourceInjection rj =
//		// ApplicationContextHolder.getContext().getBean(ResourceInjection.class);
//		// rj.configLog();
//		logger.info("abc");
//		return "index";
//	}
//
//}
