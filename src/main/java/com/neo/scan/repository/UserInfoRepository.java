//package com.neo.scan.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.neo.scan.model.UserInfos;
//
//@Repository
//public interface UserInfoRepository extends JpaRepository<UserInfos, Integer> {
//
//	@Query("select count(p.id) from user_info p")
//	long getTotalProducts();
//
//}