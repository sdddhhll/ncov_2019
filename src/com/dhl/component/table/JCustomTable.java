/**
 *@作者:風の住む街
 *@说明:
 */

package com.dhl.component.table;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dhl.tabledata.TableData;
import com.dhl.utils.CommonUtils;

/**
 * @作者:風の住む街
 * @说明:扩展默认JTable 实现一些个性化的需要
 */
public class JCustomTable extends JTable {
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(JCustomTable.class);
	private JPopupMenu m_popupMenu;
	private JTable jTable;
	public static boolean firstOpenFlag = true;

	public JCustomTable() {
		jTable = this;
		renderTable(jTable);
		jTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					int focusedRowIndex = jTable.rowAtPoint(e.getPoint());
					if (focusedRowIndex == -1) {
						return;
					}
					// 将表格所选项设为当前右键点击的行
					jTable.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);
					// 弹出菜单
					createPopupMenu();
					m_popupMenu.show(jTable, e.getX(), e.getY());
				}
			}
		});
	}
	
	/**
	 * 
	 * @作者:風の住む街
	 * @时间:2020-02-18 21:46:49
	 * @备注:渲染表格
	 *
	 */
	public void renderTable(JTable table) {
		DefaultTableCellRenderer  renderCenter  =  new  DefaultTableCellRenderer();   
		renderCenter.setHorizontalAlignment(JTextField.CENTER);   
		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTable.setModel(new JCustomTableModel(TableData.getDataTable(), TableData.getTableHeader()));
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTable.getColumnModel().getColumn(0).setPreferredWidth(70);
		jTable.getColumnModel().getColumn(0).setCellRenderer(renderCenter);
		jTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		jTable.getColumnModel().getColumn(1).setCellRenderer(renderCenter);
		jTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		jTable.getColumnModel().getColumn(2).setCellRenderer(renderCenter);
		jTable.getColumnModel().getColumn(3).setPreferredWidth(195);
		jTable.getColumnModel().getColumn(4).setPreferredWidth(100);
		jTable.getColumnModel().getColumn(5).setPreferredWidth(100);
		jTable.getColumnModel().getColumn(6).setPreferredWidth(100);
		jTable.getColumnModel().getColumn(7).setPreferredWidth(275);
		jTable.getColumnModel().getColumn(8).setPreferredWidth(140);
		jTable.getColumnModel().getColumn(8).setCellRenderer(renderCenter);
		jTable.getColumnModel().getColumn(9).setPreferredWidth(140);
		jTable.getColumnModel().getColumn(9).setCellRenderer(renderCenter);
		jTable.getColumnModel().getColumn(10).setPreferredWidth(120);
		jTable.getColumnModel().getColumn(11).setPreferredWidth(140);
		jTable.getColumnModel().getColumn(11).setCellRenderer(renderCenter);
		jTable.getColumnModel().getColumn(12).setPreferredWidth(240);
		jTable.setRowHeight(30);
		jTable.setFont(new Font("华文楷体",Font.PLAIN,14));
		JTableHeader header=jTable.getTableHeader();
        header.setFont(new Font("华文楷体",Font.PLAIN,14));//字体
	}
	
	/**
	 * 
	 * @作者:風の住む街
	 * @时间:2020-02-18 21:46:49
	 * @备注:刷新表格
	 *
	 */
	public void refreshTable(JTable jTable,Map<String,String> paraMap) {
		TableData.refreshTableData(paraMap);
		jTable.setModel(new JCustomTableModel(TableData.getDataTable(), TableData.getTableHeader()));
		renderTable(jTable);
	}

	/**
	 * 
	 * @作者:風の住む街
	 * @时间:2020-02-18 21:46:49
	 * @备注:右键弹出菜单
	 *
	 */
	private void createPopupMenu() {
		m_popupMenu = new JPopupMenu();
		JMenuItem delMenItem = new JMenuItem();
		delMenItem.setText("查看相关报道");
		delMenItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(firstOpenFlag) {
					int n = JOptionPane.showConfirmDialog(null, "将打开您的默认浏览器,可能速度较慢,请耐心等待");
					if(n == JOptionPane.CANCEL_OPTION || n == JOptionPane.NO_OPTION) {
						return;
					}
					firstOpenFlag = false;
				}
				int row = jTable.getSelectedRow();
				Object sourceUrl = jTable.getValueAt(row, 12);
				if(CommonUtils.isWindowsPlatform()) {
					CommonUtils.openWinBrowserWithUrl((String)sourceUrl);
				}else if(CommonUtils.isMacPlatform()) {
					CommonUtils.openMacBrowserWithUrl((String)sourceUrl);
				}else {
					if(log.isDebugEnabled()) {
						log.debug("仅支持MAC与WIN平台");
					}
				}
			}
		});
		m_popupMenu.add(delMenItem);
	}
}
