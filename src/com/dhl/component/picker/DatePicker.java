/**
 * 一个时间选择器,参照网上大神的现有作品,做了些修改
 */
package com.dhl.component.picker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import com.eltima.components.ui.a3;

/*
 * @author     Shyhao
 * @sourcecode UTF-8
 * @desc       A Java Calender Comp
 * @desc       It was cracked from commercial product,So you can not integer it into Commercial products
 * @desc       Only in personal condition,you can use it!
 * @desc       If you hava any questions,please mail to haoyinsong@foxmail.com 
 */


public class DatePicker extends a3 {

	private static final long serialVersionUID = 2687403109089185561L;

	public DatePicker() {

		super(null, null, null, null);
	}

	public DatePicker(Date specifiedTime, String foemat,Font font, Dimension dimension) {

		super(specifiedTime, foemat, font, dimension);
		
	}
	
	

	/*
	 * @method setLocale
	 * @desc   set the Country,e.g Local.US,Local.CHINA
	 */
	public void setLocale(Locale locale) {
		
		super.setLocale(locale);
	}
	
	/*
	 * @method  getInnerTextField
	 * @desc    return the jformattedfield int the datepick
	 */
	public JFormattedTextField getInnerTextField(){
		
		return fd;
	}
	
	/*
	 * @method getInnerButton
	 * @desc   return the jbutton in the datepick  
	 */
	public JButton getInnerButton(){
		
		return btn;
	}
	
	/*
	 * @method  getValue
	 * @desc    return innerfield's value
	 */
	public Object getValue() {
		return fd.getValue();
	}
	
	/*
	 * @method  getText
	 * @desc    return the innerfield's content
	 */
	public String getText() {
		
		return fd.getText();
	}

	/*
	 * @method setTimePanleVisible
	 * @desc view/hide the timepanel
	 */
	public void setTimePanleVisible(boolean flag) {
		
		super.setTimePanleVisible(flag);
	}

	/*
	 * @method setDisableddays
	 * @desc   set the  specified days disabled
	 */
	public void setDisableddays(int[] days) {
		
		super.setDisableddays(days);
	}

	/*
	 * @method setHightlightdays
	 * @params days{int[]},color{Color}
	 * @desc  Set the specified days  using the specified color
	 */
	public void setHightlightdays(int[] days, Color color) {
		
		super.setHightlightdays(days, color);
	}
	
	/**
	 * 
	 * @作者:風の住む街
	 * @时间:2020-02-06 16:28:21
	 * @备注:
	 *
	 */
	public void setText(String text) {
		fd.setText(text);
	}
	
	/**
	 * 
	 * @作者:風の住む街
	 * @时间:2020-02-06 16:32:56
	 * @备注:清除文本框中的时间
	 *
	 */
	public void clearText() {
		fd.setText("");
	}
	
	
	
}