//package com.neo.scan.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.neo.scan.model.PaginableItemList;
//import com.neo.scan.model.UserInfos;
//import com.neo.scan.repository.UserInfoRepository;
//
//@Service
//public class UserInfoService {
//
//	//@Autowired
//	private UserInfoRepository userInfoRepository;
//
//	public void addNewProduct(UserInfos user_info) {
//		userInfoRepository.save(user_info);
//	}
//
//	@Transactional
//	public void addNewListProducts(List<UserInfos> listUsers) {
//		userInfoRepository.save(listUsers);
//	}
//
//	public long getTotalProducts() {
//		return userInfoRepository.getTotalProducts();
//	}
//
//	public PaginableItemList<UserInfos> getListProducts(int pageSize, int pageNumber) {
//		PaginableItemList<UserInfos> paginableItemList = new PaginableItemList<UserInfos>();
//		paginableItemList.setPageSize(pageSize);
//		paginableItemList.setPageNumber(pageNumber);
//
//		Page<UserInfos> pages = userInfoRepository.findAll(new PageRequest(pageNumber, pageSize));
//		paginableItemList.setTotalProducts(pages.getTotalElements());
//		paginableItemList.setListData(pages.getContent());
//		return paginableItemList;
//	}
//}
