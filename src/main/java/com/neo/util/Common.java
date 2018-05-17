
package com.neo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

//import org.apache.pdfbox.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Common {
	private static final Logger logger = LoggerFactory.getLogger(Common.class);

	public static String getStringDateJapanFormat(String datetime) throws ParseException {
		SimpleDateFormat japanFormat = new SimpleDateFormat("yyyy�NMM��dd��");
		SimpleDateFormat eLFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = eLFormat.parse(datetime);
		String datestr = japanFormat.format(date);
		return datestr;
	}

	/*****************************************************************
	 * �yfunction get cookie value�z
	 *
	 * @author FVL) NguyenDLP
	 * @param cookieName
	 *            HttpServletRequest
	 * @param request
	 *            HttpServletRequest
	 * @return value String
	 * 
	 *****************************************************************/
	public static String getCookieValue(String cookieName, HttpServletRequest request) {
		String value = null;
		Cookie[] cookieArr = request.getCookies();
		if (cookieArr != null && cookieArr.length > 0) {
			for (Cookie cookie : cookieArr) {
				String name = cookie.getName();
				if (name.equals(cookieName)) {
					value = cookie.getValue();
					break;
				}
			}
		}
		return value;
	}

	/*****************************************************************
	 * �yMethod get file name time by format�z
	 *
	 * @author FVL) NguyenDLP
	 * @return sFile String
	 * 
	 *****************************************************************/
	public static String getFileNamePrefix() {
		DateFormat dateFormat = new SimpleDateFormat("yyMMdd_hhmm_");
		Date now = new Date();
		String sFile = dateFormat.format(now);
		return sFile;
	}

	/*****************************************************************
	 * �yMethod get current time by format�z
	 *
	 * @author FVL) NguyenDLP
	 * @param format
	 *            String
	 * @return currentTime String
	 * 
	 *****************************************************************/
	public static String getCurrentTimeByFormat(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date now = new Date();
		String currentTime = dateFormat.format(now);
		return currentTime;
	}

	/*****************************************************************
	 * �yMethod delete all file in folder�z
	 *
	 * @author FVL) NguyenDLP
	 * @param folder
	 *            File
	 * @return void void
	 * @throws Exception
	 *             IOException
	 * 
	 *****************************************************************/
	public static void deleteFolder(File folder) throws IOException {
		try {
			File[] files = folder.listFiles();
			// some JVMs return null for empty dirs
			if (files != null) {
				for (File f : files) {
					if (f.isDirectory()) {
						deleteFolder(f);
					} else {
						f.delete();
					}
				}
			}
			folder.delete();
		} catch (Exception e) {
			logger.error("IOException", e);
		}
	}

	/*****************************************************************
	 * �yMethod make folder�z
	 *
	 * @author FVL) NguyenDLP
	 * @param path
	 * @return boolean
	 * @throws Exception
	 * 
	 *****************************************************************/
	public boolean mkDirFolder(String path) {
		File f = null;
		boolean bool = false;
		try {
			// returns pathnames for files and directory
			f = new File(path);

			// create
			bool = f.mkdir();

		} catch (Exception e) {
			// if any error occurs
			e.printStackTrace();
			logger.error("Exception", e);
		}
		return bool;
	}

	/*****************************************************************
	 * �yMethod zip file�z
	 *
	 * @author FVL) NguyenDLP
	 * @param sourceFile
	 *            folder need to zip
	 * @param zipOut
	 *            output location
	 * @return void void
	 * @throws Exception
	 *             IOException
	 * 
	 *****************************************************************/
	public void zipFile(String sourceFile, String zipOut) throws IOException {
		File dir = new File(sourceFile);
		File[] files = dir.listFiles();
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipOut),
				Charset.forName(ConstantParams.ENCODE_SHIFTJIS));
		try {
			if (files != null) {
				for (int i = 0; i < files.length; i++) {
					File file = files[i];
					ZipEntry entry = new ZipEntry(file.getName());
					entry.setSize(file.length());
					entry.setTime(file.lastModified());
					out.putNextEntry(entry);
					FileInputStream in = new FileInputStream(file);
					try {
//						IOUtils.copy(in, out);
					} finally {
//						IOUtils.closeQuietly(in);
					}
					out.closeEntry();
				}
			}
		} finally {
//			IOUtils.closeQuietly(out);
		}
	}

	/*****************************************************************
	 * �yMethod get escaped cookies�z
	 *
	 * @author FVL) NguyenDLP
	 * @param cookies
	 *            Cookies
	 * @return escapedCookies Cookies
	 * @throws Exception
	 *             ConverterException
	 * 
	 *****************************************************************/
	// public Cookies cookies(Cookies cookies){
	// Cookies escapedCookies = cookies.withConverter(new Cookies.Converter() {
	// @Override
	// public String convert( String value, String name ) throws
	// ConverterException {
	// ScriptEngine javascript = new ScriptEngineManager().getEngineByName(
	// "JavaScript" );
	// if ( name.equals( "escaped" ) ) {
	// try {
	// return javascript.eval( "unescape('" + value + "')" ).toString();
	// } catch ( ScriptException e ) {
	// throw new ConverterException( e );
	// }
	// }
	// return null;
	// }
	// });
	// return escapedCookies;
	// }

	/*****************************************************************
	 * �yCheck if file is exist or not�z
	 *
	 * @author FVL) NgocNM
	 * @param filePath
	 *            File Path
	 * @return true/false
	 *
	 *****************************************************************/
	public static boolean checkFileExistence(String filePath) {
		logger.info("checkFileExistence Start");
		Path path = Paths.get(filePath);
		if (Files.exists(path)) {
			return true;
		}
		return false;
	}

	/*****************************************************************
	 * �yConvert Date to String�z
	 *
	 * @author FVL) NgocNM
	 * @param date
	 *            Input Date
	 * @return dateString Date String
	 *
	 *****************************************************************/
	public static String convertDateToString(Date date) {
		logger.info("convertDateToString Start");
		if (date == null) {
			return "";
		}
		SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy�NMM��dd��");
		String dateString = newDateFormat.format(date);
		return dateString;
	}

	/*****************************************************************
	 * �yDelete All Files and Directory�z
	 *
	 * @author FVL) NgocNM
	 * @param dir
	 *            Directory
	 *
	 *****************************************************************/
	public static void deleteDirectory(File dir) {
		logger.info("deleteDirectory Start");
		if (dir == null) {
			return;
		}

		File[] contents = dir.listFiles();
		if (contents != null) {
			for (File file : contents) {
				deleteDirectory(file);
			}
		}
		dir.delete();
	}

	/*****************************************************************
	 * �yConvert HTML File to PDF File�z
	 *
	 * @author FVL) NgocNM
	 * @param htmlFilePath
	 *            HTML File Location
	 * @param pdfFilePath
	 *            PDF File Location
	 *
	 *****************************************************************/
	public static boolean convertHtmlToPdf(String htmlToPdfFilePath, String htmlFilePath, String pdfFilePath) {
		logger.info("convertHtmlToPdf Start");

		// Check if execution file exists
		/*
		 * if(!checkFileExistence(htmlToPdfFilePath)) { logger.error(
		 * "Converter file doesn't exist."); return false; }
		 */

		// Excecute command
		// try{
		// String command = htmlToPdfFilePath + " " + htmlFilePath + " " +
		// pdfFilePath;
		// logger.info("command: " + command);
		// Process p;
		// p = Runtime.getRuntime().exec(command);
		// p.waitFor();
		// }catch (Exception e){
		// logger.error("Converter execution failed.", e);
		// return false;
		// }
		//
		// // Check if PDF file is created or not
		// if(!checkFileExistence(pdfFilePath))
		// {
		// logger.error("PDF file is not created.");
		// return false;
		// }

		return true;
	}

}
