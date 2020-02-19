/**
 *@作者:風の住む街
 *@说明:
 */

package com.dhl.component.table;

import javax.swing.table.DefaultTableModel;

/**
 *@作者:風の住む街
 *@说明:禁用表格单元格编辑
 */
public class JCustomTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	
	public JCustomTableModel(Object[][] content, Object[] header) {
		super(content, header);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
