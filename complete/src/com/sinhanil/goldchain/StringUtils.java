package com.sinhanil.goldchain;

import com.google.gson.GsonBuilder;

public class StringUtils {

	/**
	 * Convert object to json
	 * @param o
	 * @return
	 */
	public static String getJson(Object o) {
		return new GsonBuilder().setPrettyPrinting().create().toJson(o);
	}
	
	/**
	 * create difficulty string target, to compare to hash. eg difficulty of 5 will return "00000"
	 * @param difficulty
	 * @return 
	 */	
	public static String getDificultyString(int difficulty) {
		return new String(new char[difficulty]).replace('\0', '0');
	}

}
