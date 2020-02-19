/**
 *@作者:風の住む街
 *@说明:
 */

package com.dhl.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import com.dhl.component.event.JTextFieldHintListener;
import com.dhl.component.picker.DatePicker;
import com.dhl.component.table.JCustomTable;

/**
 *@作者:風の住む街
 *@说明:主视图
 */
public class MainWindow extends JFrame {
	private static Log log = LogFactory.getLog(MainWindow.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//private JTextField tDate;
	private DatePicker tDate;
	private JTextField tNo;
	private JLabel tAreaLabel;
	private JTextField tArea;
	private JCustomTable table;
	private JLabel clearDate;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		if(log.isDebugEnabled()) {
			log.debug("开始初始化UI界面");
		}
		setFont(new Font("华文楷体", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/com/dhl/data/ncov2.png")));
		setTitle("2019-nCoV 新型肺炎确诊患者相同行程查询工具 V1.3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel tDateLabel = new JLabel("日期：");
		tDateLabel.setFont(new Font("华文楷体", Font.PLAIN, 14));
		tDateLabel.setBounds(24, 38, 44, 25);
		contentPane.add(tDateLabel);
		//tDate = new JTextField("例如：2020-01-01");
		//tDate.setFont(new Font("华文楷体", Font.PLAIN, 14));
		//tDate.addFocusListener(new JTextFieldHintListener("例如：2020-01-01", tDate));
		//tDate.setBounds(69, 38, 151, 25);
		//contentPane.add(tDate);
		//tDate.setColumns(10);
		tDate = getDatePicker();
        contentPane.add(tDate);
        tDate.clearText();
        
		JLabel tNoLabel = new JLabel("车次：");
		tNoLabel.setFont(new Font("华文楷体", Font.PLAIN, 14));
		tNoLabel.setBounds(243, 38, 44, 25);
		contentPane.add(tNoLabel);
		
		tNo = new JTextField("车次或航班，例如：T123");
		tNo.setFont(new Font("华文楷体", Font.PLAIN, 14));
		tNo.addFocusListener(new JTextFieldHintListener("车次或航班，例如：T123", tNo));
		tNo.setColumns(10);
		tNo.setBounds(287, 38, 170, 25);
		contentPane.add(tNo);
		
		tAreaLabel = new JLabel("地区：");
		tAreaLabel.setFont(new Font("华文楷体", Font.PLAIN, 14));
		tAreaLabel.setBounds(470, 38, 44, 25);
		contentPane.add(tAreaLabel);
		
		tArea = new JTextField("地区，例如：成都");
		tArea.setFont(new Font("华文楷体", Font.PLAIN, 14));
		tArea.addFocusListener(new JTextFieldHintListener("地区，例如：成都", tArea));
		tArea.setColumns(10);
		tArea.setBounds(515, 38, 151, 25);
		contentPane.add(tArea);
		
		
		
		table = new JCustomTable();
		table.setFont(new Font("华文楷体", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 95, 764, 457);
		contentPane.add(scrollPane);
		
		JButton button = new JButton("查询");
		button.setFont(new Font("华文行楷", Font.PLAIN, 14));
		button.setBounds(698, 38, 64, 25);
		button.setFocusable(true);
		contentPane.add(button);
		
		clearDate = new JLabel("");
		clearDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tDate.clearText();
			}
		});
		clearDate.setIcon(new ImageIcon(MainWindow.class.getResource("/com/dhl/data/clears.gif")));
		clearDate.setBounds(200, 43, 16, 16);
		contentPane.add(clearDate);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Map<String, String> paraMap = new HashMap<String, String>();
				String tNoV = tNo.getText();
				if(!StringUtils.isEmpty(tNoV) && !tNoV.equals("车次或航班，例如：T123")) {
					paraMap.put("t_no", tNoV);
				}
				String tDateV = tDate.getText();
				if(!StringUtils.isEmpty(tDateV)  && !tDateV.equals("例如：2020-01-01")) {
					paraMap.put("t_date", tDateV);
				}
				
				String tAreaV = tArea.getText();
				if(!StringUtils.isEmpty(tAreaV)  && !tAreaV.equals("地区，例如：成都")) {
					paraMap.put("t_area", tAreaV);
				}
				
				table.refreshTable(table, paraMap);
			}
		});
		
		if(log.isDebugEnabled()) {
			log.debug("初始化UI界面成功");
		}
		button.setFocusable(true);
		button.requestFocus(true);
	}
	
	
	private static DatePicker getDatePicker() {
        final DatePicker datepick;
        // 格式
        String DefaultFormat = "yyyy-MM-dd";
        // 当前时间
        //Date date = new Date();
        // 字体
        Font font = new Font("华文楷体", Font.PLAIN, 14);
   
        Dimension dimension = new Dimension(177, 24);
   
        int[] hilightDays = {  };
   
        int[] disabledDays = { };
   
        datepick = new DatePicker(null, DefaultFormat, font, dimension);
   
        datepick.setLocation(137, 83);
        //69, 38, 151, 25
        datepick.setBounds(69, 38, 127, 25);
        // 设置一个月份中需要高亮显示的日子
        datepick.setHightlightdays(hilightDays, Color.red);
        // 设置一个月份中不需要的日子，呈灰色显示
        datepick.setDisableddays(disabledDays);
        // 设置国家
        datepick.setLocale(Locale.CHINA);
        // 设置时钟面板可见
        datepick.setTimePanleVisible(false);
        return datepick;
    }
}
