//package com.neo.scan.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.neo.scan.dao.QueryForListReturnListDAO;
//import com.neo.scan.model.UserInfos;
//import com.neo.scan.service.UserInfoService;
//
//import java.util.ArrayList;
//import java.util.Random;
//
///**
// * 
// */
//
//@Controller
//@RequestMapping(path = "/")
//public class UserController {
//
//	@Autowired
//	// private UserInfoService userInfoService;
//	private QueryForListReturnListDAO userInfoService;
//
//	private String[] images = { "https://images-na.ssl-images-amazon.com/images/I/519rVW4jTIL._SL500_SS135_.jpg",
//			"https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg",
//			"https://images-na.ssl-images-amazon.com/images/I/517Q0wwZUXL._SL500_SS135_.jpg",
//			"https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg",
//			"https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg" };
//
////	@RequestMapping(value = "/admin", method = RequestMethod.GET)
////	public String admin(Model model) {
////
////		// long totalProducts = userInfoService.getTotalProducts();
////		// if (totalProducts <= 0) {
////		// ArrayList<UserInfo> listProducts = new ArrayList<UserInfo>();
////		// Random random = new Random();
////		//
////		// for (int i = 1; i <= 100; ++i) {
////		// UserInfo p = new UserInfo();
////		// // p.setCreatedDate(new Date());
////		// // p.setName("Product " + i);
////		// // p.setShortDesc("Description for product " + i);
////		// // p.setImage(images[random.nextInt(images.length)]);
////		// listProducts.add(p);
////		// }
////		//
////		// userInfoService.addNewListProducts(listProducts);
////		// model.addAttribute("message", "Total added products: " +
////		// listProducts.size());
////		// } else {
////		// model.addAttribute("message", "Total existed products: " +
////		// totalProducts);
////		// }
////
////		return "admin";
////	}
//
//	@RequestMapping(value = "/user", method = RequestMethod.GET)
//	public String index(Model model, @RequestParam(value = "pageSize", required = false) String ps,
//			@RequestParam(value = "pageNumber", required = false) String pn) {
//
//		// try {
//		// int pageSize = Integer.parseInt(ps);
//		// int pageNumber = Integer.parseInt(pn);
//		// if (pageSize > 0 && pageNumber >= 0) {
//		// model.addAttribute("paginableItem",
//		// userInfoService.getListProducts(pageSize, pageNumber));
//		// } else {
//		// model.addAttribute("paginableItem",
//		// userInfoService.getListProducts(10, 0));
//		// }
//		// } catch (Exception ex) {
//		// model.addAttribute("paginableItem",
//		// userInfoService.getListProducts(10, 0));
//		// }
//		model.addAttribute("paginableItem", userInfoService.getDeptNames());
//		model.addAttribute("adn", "anc");
//		return "user";
//	}
//}
