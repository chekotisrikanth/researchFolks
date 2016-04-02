package com.marketing.tool.utility;

/**
 * @author Anilkumar Ravula
 * @date  Aug 7, 2015
 */
public class StringUtil {
	
	/**
	 * Simple String Concatanation
	 * @date  Aug 7, 2015
	 * @param strings
	 * @return
	 */
	public static String buildString(Object ... strings) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < strings.length; i++) {
			builder.append(strings[i]);
		}
		return builder.toString();
		
	}

}
