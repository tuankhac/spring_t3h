/**
 * *************************************************************** 
 * Class CSVUtils : contains some common function write CSV file in the project
 *
 ****************************************************************
 */

package com.neo.util;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

public class CSVUtils {
	private static final char DEFAULT_SEPARATOR = ',';

	/**
	 * *************************************************************** 
	 * Method writeLine(Writer w, List<String> values)
	 *
	 * 		@original 				N/A
	 * 		@author 				FVL) NguyenDLP
	 * 		@param Writer 			w
	 * 		@param List<String> 	values
	 * 		@return 				N/A
	 * 		@throws IOException 	(show message if have errors)
	 *
	 ****************************************************************
	 */

	public static void writeLine(Writer w, List<String> values) throws IOException {
		writeLine(w, values, DEFAULT_SEPARATOR, ' ');
	}

	public static void writeLine(Writer w, List<String> values, char separators) throws IOException {
		writeLine(w, values, separators, ' ');
	}

	/**
	 * *************************************************************** 
	 * Method followCVSformat(String value)
	 *
	 * 		@original			 N/A
	 * 		@author 			FVL) NguyenDLP
	 * 		@param String 		value input String
	 * 		@return return 		result return String
	 * 		@throws 			N/A
	 *
	 ****************************************************************
	 */
	private static String followCVSformat(String value) {

		String result = value;
		if (result.contains("\"")) {
			result = result.replace("\"", "\"\"");
		}
		return result;

	}

	/**
	 * *************************************************************** 
	 * 		Method writeLine(Writer w, List<String> values, char separators, char customQuote)
	 *
	 * 		@author 					FVL) NguyenDLP
	 * 		@param Writer 				w
	 * 		@param List<String> 		values
	 * 		@param char 				separators
	 * 		@param char 				customQuote
	 * 		@return 					N/A
	 * 		@throws IOException 		Show error message if have errors
	 *
	 ****************************************************************
	 */
	public static void writeLine(Writer w, List<String> values, char separators, char customQuote) throws IOException {
		boolean first = true;

		if (separators == ' ') {
			separators = DEFAULT_SEPARATOR;
		}

		StringBuilder sb = new StringBuilder();
		for (String value : values) {
			if (!first) {
				sb.append(separators);
			}
			if (customQuote == ' ') {
				sb.append(followCVSformat(value));
			} else {
				sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
			}

			first = false;
		}
		sb.append("\n");
		w.append(sb.toString());
	}

	/**
	 * ***************************************************************
	 * Method writeToFile(String filePath, String content)
	 *
	 *		@original N/A
	 *		@author FVL) NguyenDLP
	 * 		@param String filePath
	 * 		@param String content
	 * 		@return boolean
	 * 		@throws IOException Show error message if have errors
	 ****************************************************************
	 */

	public static boolean writeToFile(String filePath, String content) {
		try {
			FileOutputStream outputStream = new FileOutputStream(filePath);
			OutputStreamWriter osw = new OutputStreamWriter(outputStream, ConstantParams.ENCODE_SHIFTJIS);
			Writer write = new BufferedWriter(osw);
			List<String> stringWriter = Arrays.asList(content);
			CSVUtils.writeLine(write, stringWriter);
			write.flush();
			write.close();
			osw.flush();
			osw.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * *************************************************************** 
	 * Method writeAppendToFile(String filePath, String data)
	 *
	 * 		@original N/A
	 * 		@author FVL) NguyenDLP
	 * 		@param String filePath
	 * 		@param String data
	 * 		@return boolean
	 * 		@throws IOException Show error message if have errors
	 *
	 ****************************************************************
	 */
	public static boolean writeAppendToFile(String filePath, String data) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		boolean res = false;
		try {
			File file = new File(filePath);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write(data);
			bw.newLine();
			res = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return res;
	}

}
