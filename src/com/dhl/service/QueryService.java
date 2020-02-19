/**
 *@作者:風の住む街
 *@说明:
 */

package com.dhl.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dhl.mapper.QueryMapper;

/**
 *@作者:風の住む街
 *@说明:查询服务类
 */
public class QueryService {
	
	@Autowired
	public QueryMapper queryMapper;
	
	public List<Map<String,String>> queryData(Map<String, String> paraMap){
		return queryMapper.queryData(paraMap);
	}
	public List<Map<String,String>> queryDict(){
		return queryMapper.queryDict();
	}
}
