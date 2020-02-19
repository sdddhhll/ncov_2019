/**
 *@作者:風の住む街
 *@说明:
 */

package com.dhl.mapper;

import java.util.List;
import java.util.Map;

/**
 *@作者:風の住む街
 *@说明:
 */
public interface QueryMapper {
	/**
	 * 
	 * @作者:風の住む街
	 * @时间:2020-02-18 21:54:46
	 * @备注:获取数据
	 *
	 */
	public List<Map<String,String>> queryData(Map<String, String> paraMap);
	/**
	 * 
	 * @作者:風の住む街
	 * @时间:2020-02-18 21:54:46
	 * @备注:获取字典
	 *
	 */
	public List<Map<String,String>> queryDict();
}
