/**
 *@作者:風の住む街
 *@说明:
 */

package com.dhl.tabledata;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *@作者:風の住む街
 *@说明:字典工具类
 */
public class DictData {
	private static List<Map<String,String>> queryDict = DataUtil.queryService.queryDict();
	private static Map<String, String> dictData = new LinkedHashMap<String, String>();
	static {
		getDictData();
	}
	public static Map<String, String> getDictData() {
		for (int i = 0; i < queryDict.size(); i++) {
			Map<String, String> dictMap = queryDict.get(i);
			dictData.put(dictMap.get("dic_code"), dictMap.get("dic_value"));
		}
		return dictData;
	}
}
