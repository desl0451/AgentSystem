package org.agent.common;

public class SQLTools {
	/**
	 * MyBatis模糊查询阴谋诡计止SQL注入
	 * 
	 * @return
	 */
	public static String transfer(String keyword) {
		if (keyword.contains("%") || keyword.contains("_")) {
			keyword = keyword.replaceAll("\\\\", "\\\\\\\\").replaceAll("\\%", "\\\\").replaceAll("\\_", "\\\\_");
		}
		return keyword;
	}
}
