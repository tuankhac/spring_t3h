//package com.neo.scan.model;
//
//import java.util.Date;
//
//import javax.persistence.*;
//
//@Entity(name = "user_info")
//@NamedQuery(name = "getTotalProducts", query = "select count(p.id) from user_info p")
//public class UserInfos {
//
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "ID")
//	@Id
//	private int id;
//
//	@Column(name = "PASSWORD")
//	private String password;
//
//	@Column(name = "FIRST_NAME")
//	private String first_name;
//
//	@Column(name = "LAST_NAME")
//	private String last_name;
//
//	@Column(name = "MOBILE")
//	private String mobile;
//
//	@Column(name = "DEPARTMENT")
//	private String department;
//
//	@Column(name = "EMAIL")
//	private String email;
//
//	@Column(name = "GENDER")
//	private String gender;
//
//	@Column(name = "STATUS_ID")
//	private int status_id;
//
//	@Column(name = "CREATED_DATE")
//	private Date created_date;
//
//	@Column(name = "MODIFIED_DATE")
//	private Date modified_date;
//
//	@Column(name = "ROLE_LEVER")
//	private int role_lever;
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getFirst_name() {
//		return first_name;
//	}
//
//	public void setFirst_name(String first_name) {
//		this.first_name = first_name;
//	}
//
//	public String getLast_name() {
//		return last_name;
//	}
//
//	public void setLast_name(String last_name) {
//		this.last_name = last_name;
//	}
//
//	public String getMobile() {
//		return mobile;
//	}
//
//	public void setMobile(String mobile) {
//		this.mobile = mobile;
//	}
//
//	public String getDepartment() {
//		return department;
//	}
//
//	public void setDepartment(String department) {
//		this.department = department;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getGender() {
//		return gender;
//	}
//
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//
//	public int getStatus_id() {
//		return status_id;
//	}
//
//	public void setStatus_id(int status_id) {
//		this.status_id = status_id;
//	}
//
//	public Date getCreated_date() {
//		return created_date;
//	}
//
//	public void setCreated_date(Date created_date) {
//		this.created_date = created_date;
//	}
//
//	public Date getModified_date() {
//		return modified_date;
//	}
//
//	public void setModified_date(Date modified_date) {
//		this.modified_date = modified_date;
//	}
//
//	public int getRole_lever() {
//		return role_lever;
//	}
//
//	public void setRole_lever(int role_lever) {
//		this.role_lever = role_lever;
//	}
//
//}
