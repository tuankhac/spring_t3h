package com.neo.scan.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neo.scan.dao.SpringJdbcDaoSupportSDAO;
import com.neo.scan.model.Role;
import com.neo.scan.model.UserInfo;

@RestController
public class AjaxController {

	@Autowired
	SpringJdbcDaoSupportSDAO springJdbcDaoSupportSDAO;

	@Autowired
	private Environment environment;

	// @RequestMapping(method = RequestMethod.GET)
	// public ModelAndView home() {
	// ModelAndView mv = new ModelAndView("crud_exec");
	// return mv;
	// }

	@RequestMapping(value = "/crud_exec", method = RequestMethod.GET)
	public @ResponseBody ModelAndView ajax_ref(HttpServletRequest request,
			@RequestParam Map<String, String> allRequestParams,
			@RequestParam(value = "crud_type", required = false) String crud_type,
			@RequestParam(value = "query", required = false) String query,
			@RequestParam(value = "queryString", required = false) String queryString) {

		ModelAndView mv = new ModelAndView("crud_exec");
		String ajaxResponse = "ajaxResponse";

		List<Map<String, Object>> list = null;
		String value = "";
		String valueInt = "";
		if (crud_type == null || crud_type.isEmpty()) {
			return new ModelAndView("400Page", "message", "URL or paramters are not correct, please check!");
		}
		if (query == null || query.isEmpty()) {
			return new ModelAndView("400Page", "message", "URL or paramters are not correct, please check!");
		}
		if (queryString == null || queryString.isEmpty()) {
			return new ModelAndView("400Page", "message", "URL or paramters are not correct, please check!");
		}

		try {
			Object[] arrayParams = new Object[allRequestParams.size() - 3];
			Iterator<String> i = allRequestParams.keySet().iterator();
			i.next();
			i.next();
			i.next();
			int pos = 0;
			System.out.println("chay xuong day");
			while (i.hasNext()) {
				String key = (String) i.next();
				String values = allRequestParams.get(key);
				if (key.equals("userID")) {
					arrayParams[pos] = request.getUserPrincipal().getName();
					System.out.println("user"+arrayParams[pos]);
				}
				if (key.equals("userIP")) {
					arrayParams[pos] = request.getRemoteAddr();
					System.out.println("ip"+arrayParams[pos]);
				} else {
					arrayParams[pos] = values;
				}
				pos++;
				System.out.println("key:" + key + "| value:" + values);
			}
			switch (query) {
			case "ref":
				list = springJdbcDaoSupportSDAO.getRef(environment.getProperty(queryString), arrayParams);
				mv.addObject("ajaxResponse", list);
				break;
			case "value":
				value = springJdbcDaoSupportSDAO.getValue(environment.getProperty(queryString), arrayParams);
				
				mv.addObject("ajaxResponse", value);
				break;
			case "valueInt":
				valueInt =  springJdbcDaoSupportSDAO.getValueInt(environment.getProperty(queryString), arrayParams);
				mv.addObject("ajaxResponse", valueInt);
				break;
			case "query":
				break;
			case "exec":
				break;
			}

		} catch (Exception e) {
			list = new ArrayList<>();
			e.printStackTrace();
		}

		// ObjectMapper mapper = new ObjectMapper();

		// try {
		// ajaxResponse = mapper.writeValueAsString(list);
		// } catch (JsonProcessingException e) {
		// e.printStackTrace();
		// }
		// System.out.println("check ajax" + ajaxResponse);
		
		return mv;
	}

	// @RequestMapping(value = "/search", method = RequestMethod.GET)
	// public @ResponseBody String searchRole(HttpServletRequest request) {
	// String query = request.getParameter("name");
	// Role person = searchRoleByName(query);
	//
	// ObjectMapper mapper = new ObjectMapper();
	// String ajaxResponse = "";
	// try {
	// ajaxResponse = mapper.writeValueAsString(person);
	// } catch (JsonProcessingException e) {
	// e.printStackTrace();
	// }
	//
	// return ajaxResponse;
	// }
}