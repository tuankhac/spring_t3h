//package com.neo.filter;
//
//import java.io.IOException;
//import java.util.Scanner;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// * Servlet Filter implementation class filter
// * 
// * @author prgrmmr.aben [at] gmail (dot) com
// *         http://fivesnippets.blogspot.com/2014/08/servlet-filter-for-ddos-spam
// *         -etc.html please give back a small donation if you find this little
// *         educational snippet of code useful
// */
//@WebFilter("/")
//public class DosFilter implements Filter {
//
//	/**
//	 * Default constructor.
//	 */
//	public DosFilter() {
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * @see Filter#destroy()
//	 */
//	public void destroy() {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
//	 */
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		HttpSession session;
//		System.out.println("being filtered"); // you can use logging instead
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse res = (HttpServletResponse) response;
//		res.addHeader("X-FRAME-OPTIONS", "DENY");
//		String requestedPath = req.getRequestURI().substring(req.getContextPath().length());
//		// I was using the test bellow when developing the app
//		/*
//		 * Scanner verify = new Scanner(System.in); if(verify.nextInt()==0){
//		 * req.getSession().invalidate(); }
//		 */
//		session = req.getSession(false);
//		if (req.getSession(false) == null) {
//			session = req.getSession(true);
//			sessionInit(session);
//			req.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
//		} else {
//			//sessionInit(session);
//			long timeElapsed = System.currentTimeMillis() - (long) session.getAttribute("lastTime");
//			System.out.println(timeElapsed);
//			System.out.println("seen");
//			if (session.getAttribute("spam").equals(true))
//				System.out.println("spams are not allowed"); // you can use
//																// logging
//																// instead
//			else if (timeElapsed < 2000) {
//				session.setAttribute("spam", true);
//				System.out.println("spam need to be blocked");
//			} else if (session.getAttribute("logged").equals(false)) {
//				session.setAttribute("lastTime", System.currentTimeMillis());
//				req.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
//				System.out.println(2);
//			} else {// if session.getAttribute("logged").equals(true) which
//					// should be set to true after user is logged
//				System.out.println(requestedPath);
//				session.setAttribute("lastTime", System.currentTimeMillis());
//				if (requestedPath.equals("/login.jsp"))
//					req.getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
//				else
//					req.getServletContext().getRequestDispatcher(requestedPath).forward(request, response);
//			}
//		}
//
//		 chain.doFilter(request, response);
//	}
//
//	private void sessionInit(HttpSession session) {
//		// TODO Auto-generated method stub
//		System.out.println("init");
//		session.setAttribute("spam", false);
//		session.setAttribute("logged", true);
//		session.setAttribute("lastTime", System.currentTimeMillis());
//
//	}
//
//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	public void init(FilterConfig fConfig) throws ServletException {
//		// TODO Auto-generated method stub
//
//	}
//
//}
