/**
 *@作者:風の住む街
 *@说明:
 */

package com.dhl.tabledata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.dhl.data.ProvinceCity;

/**
 *@作者:風の住む街
 *@说明:表格数据
 */
public class TableData {

	private static List<Map<String,String>> queryData = DataUtil.queryService.queryData(null);
	private static Object[][] dataTable= null;
	public static int COLUMN_SIZE=13;
	
	static {
		dataTable = TableData.setDataTable(queryData, COLUMN_SIZE);
	}
	
	/**
	 * 
	 * @作者:風の住む街
	 * @时间:2020-02-05 11:54:28
	 * @备注:设置数据表
	 *
	 */
	public static Object[][] setDataTable(List<Map<String,String>> queryData,int columnSize) {
		Object[][] dataTable= new Object[queryData.size()][columnSize];
		for (int i = 0; i < queryData.size(); i++) {
			Map<String, String> dataMap = queryData.get(i);
			dataTable[i][0]= (i+1)+"";
			dataTable[i][1]= DictData.getDictData().get(dataMap.get("t_type"));
			dataTable[i][2]= dataMap.get("t_date");
			dataTable[i][3]= dataMap.get("t_no");
			dataTable[i][4]= dataMap.get("t_no_sub");
			dataTable[i][5]= dataMap.get("t_pos_start");
			dataTable[i][6]= dataMap.get("t_pos_end");
			dataTable[i][7]= dataMap.get("t_memo");
			dataTable[i][8]= dataMap.get("t_start");
			dataTable[i][9]= dataMap.get("t_end");
			dataTable[i][10]= dataMap.get("who");
			dataTable[i][11]= dataMap.get("updated_at");
			dataTable[i][12]= dataMap.get("source");
		}
		return dataTable;
	}
	
	public static  Object[][] getDataTable() {
		return dataTable;
	}
	
	/**
	 * 
	 * @作者:風の住む街
	 * @时间:2020-02-05 11:54:09
	 * @备注:表头
	 *
	 */
	public static String[] getTableHeader() {
		return new String[] {"序号",
				"\u4EA4\u901A\u5DE5\u5177", "\u65E5\u671F", "\u8F66\u6B21/\u8F66\u724C/\u822A\u73ED\u53F7/\u573A\u6240\u540D\u79F0", "\u8F66\u53A2", "\u51FA\u53D1\u7AD9", "\u5230\u8FBE\u7AD9", "\u8F66\u6B21\u9644\u52A0\u63CF\u8FF0", "\u5F00\u59CB\u65F6\u95F4", "\u7ED3\u675F\u65F6\u95F4", "\u7EBF\u7D22\u6765\u6E90", "\u63D0\u4EA4\u65F6\u95F4","新闻地址"
			};
	}
	
	/**
	 * 
	 * @作者:風の住む街
	 * @时间:2020-02-05 11:53:49
	 * @备注:刷新表数据
	 *
	 */
	public static Object[][] refreshTableData(Map<String,String> paraMap) {
		List<Map<String,String>> queryData = DataUtil.queryService.queryData(paraMap);
		List<Map<String,String>> withArea = filterWithArea(queryData,paraMap);
		dataTable = TableData.setDataTable(withArea, COLUMN_SIZE);
		return dataTable;
	}
	
	/**
	 * 
	 * @作者:風の住む街
	 * @时间:2020-02-05 11:26:38
	 * @备注:按照地区过滤
	 *
	 */
	public static List<Map<String,String>> filterWithArea(List<Map<String,String>> queryData,Map<String,String> paraMap){
		List<Map<String,String>> rData = new ArrayList<Map<String,String>>();
		String area = paraMap.get("t_area");
		if(StringUtils.isEmpty(area)) {
			return queryData;
		}
		for (Map<String, String> map : queryData) {
			if(ProvinceCity.regexAreaName(area, map.get("t_no")) || ProvinceCity.regexAreaName(area, map.get("t_pos_start")) ||ProvinceCity.regexAreaName(area, map.get("t_pos_end")) || ProvinceCity.regexAreaName(area, map.get("t_memo"))) {
				rData.add(map);
			}
		}
		return rData;
	}
	
}
