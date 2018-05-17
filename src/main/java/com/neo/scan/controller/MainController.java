package com.neo.scan.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.SecureRandom;
import org.apache.commons.codec.binary.Base64;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neo.scan.dao.SpringJdbcDaoSupportSDAO;

@Controller
public class MainController {
	private String keyString = "adkj@#$02#@adflkj)(*jlj@#$#@LKjasdjlkj<.,mo@#$@#kljlkdsu343";
	@Autowired
	SpringJdbcDaoSupportSDAO springJdbcDaoSupportSDAO;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String indexPage(Model model, HttpServletRequest request, @ModelAttribute() Object obj) {
		//Object[] arrayParams = new Object[] { request.getUserPrincipal().getName(), "vi_VN" };
		Object[] arrayParams = new Object[] { "admin", "vi_VN" };
		String menu = getBootstrapMenu("select layds_menu_theo_nguoidung_gen(?,?)", arrayParams, request.getContextPath());
		// System.out.println("abc"+obj);
		model.addAttribute("menu", menu);
		return "index";
	}

	@RequestMapping(value = { "/help" }, method = RequestMethod.GET)
	public String helpPage(Model model) {
		return "help";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model) {
		return "adminPage";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String loginPage(Model model) {
		return "loginPage";
	}

	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		return "logoutSuccessfulPage";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			model.addAttribute("message",
					"Hi " + principal.getName() + "<br> You do not have permission to access this page!");
		} else {
			model.addAttribute("msg", "You do not have permission to access this page!");
		}
		return "403Page";
	}

	@RequestMapping(value = "/400", method = RequestMethod.GET)
	public String badRequest(Model model) {
		model.addAttribute("message", "URL or paramters are not correct, please check!");
		return "400Page";
	}

	@RequestMapping(value = "/crud")
	public ModelAndView crudPage(HttpServletRequest request, @RequestParam Map<String, String> allRequestParams,
			@RequestParam(value = "crud_type", required = false) String crud_type) {
		if (crud_type == null || crud_type.isEmpty()) {
			return new ModelAndView("400Page", "message", "URL or paramters are not correct, please check!");
		}
		//System.out.println(request.getAttribute("a"));
		// Map m=request.getParameterMap();
		// Set s = m.entrySet();
		// Iterator it = s.iterator();
		//
		// while(it.hasNext()){
		//
		// Map.Entry<String,String[]> entry =
		// (Map.Entry<String,String[]>)it.next();
		//
		// String key = entry.getKey();
		// String[] value = entry.getValue();
		//
		// System.out.println(key + ","+ value);
		// }

		//for (String parameter : allRequestParams.keySet()) {
			// model.addObject(parameter,
			// allRequestParams.get(parameter).toString());
			//System.out.println(parameter + "|" + allRequestParams.get(parameter).toString());
		//}

		Object[] arrayParams = new Object[] { request.getUserPrincipal().getName(), "vi_VN" };
		String menu = getBootstrapMenu("select layds_menu_theo_nguoidung_gen(?,?)", arrayParams, request.getContextPath());

		Enumeration<String> listAttribute = request.getAttributeNames();
		while (listAttribute.hasMoreElements()) {
			String name = (String) listAttribute.nextElement();
			// Get the value of the attribute
			Object value = request.getAttribute(name);

		}
		ModelAndView mv = new ModelAndView("crud");
		mv.addObject("menu", menu);
		return mv;
	}

	public String getBootstrapMenu(String methodFunction, Object[] arrayParams, String uri) {
		String res = "";
		res = springJdbcDaoSupportSDAO.getValue(methodFunction, arrayParams);
		return res;
	}

	/**
	 * Encrypts and encodes the Object and IV for url inclusion
	 * 
	 * @param input
	 * @return
	 * @throws Exception
	 */
	private String[] encryptObject(Object obj) throws Exception {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		ObjectOutput out = new ObjectOutputStream(stream);
		try {
			// Serialize the object
			out.writeObject(obj);
			byte[] serialized = stream.toByteArray();

			// Setup the cipher and Init Vector
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] iv = new byte[cipher.getBlockSize()];
			new SecureRandom().nextBytes(iv);
			IvParameterSpec ivSpec = new IvParameterSpec(iv);

			// Hash the key with SHA-256 and trim the output to 128-bit for the
			// key
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.update(keyString.getBytes());
			byte[] key = new byte[16];
			System.arraycopy(digest.digest(), 0, key, 0, key.length);
			SecretKeySpec keySpec = new SecretKeySpec(key, "AES");

			// encrypt
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

			// Encrypt & Encode the input
			byte[] encrypted = cipher.doFinal(serialized);
			byte[] base64Encoded = Base64.encodeBase64(encrypted);
			String base64String = new String(base64Encoded);
			String urlEncodedData = URLEncoder.encode(base64String, "UTF-8");

			// Encode the Init Vector
			byte[] base64IV = Base64.encodeBase64(iv);
			String base64IVString = new String(base64IV);
			String urlEncodedIV = URLEncoder.encode(base64IVString, "UTF-8");

			return new String[] { urlEncodedData, urlEncodedIV };
		} finally {
			stream.close();
			out.close();
		}
	}

	/**
	 * Decrypts the String and serializes the object
	 * 
	 * @param base64Data
	 * @param base64IV
	 * @return
	 * @throws Exception
	 */
	public Object decryptObject(String base64Data, String base64IV) throws Exception {
		// Decode the data
		byte[] encryptedData = Base64.decodeBase64(base64Data.getBytes());

		// Decode the Init Vector
		byte[] rawIV = Base64.decodeBase64(base64IV.getBytes());

		// Configure the Cipher
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec ivSpec = new IvParameterSpec(rawIV);
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.update(keyString.getBytes());
		byte[] key = new byte[16];
		System.arraycopy(digest.digest(), 0, key, 0, key.length);
		SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
		cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

		// Decrypt the data..
		byte[] decrypted = cipher.doFinal(encryptedData);

		// Deserialize the object
		ByteArrayInputStream stream = new ByteArrayInputStream(decrypted);
		ObjectInput in = new ObjectInputStream(stream);
		Object obj = null;
		try {
			obj = in.readObject();
		} finally {
			stream.close();
			in.close();
		}
		return obj;
	}
}