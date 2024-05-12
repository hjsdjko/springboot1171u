package com.entity.model;

import com.entity.KouqianglishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 口腔历史
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-03-20 13:32:03
 */
public class KouqianglishiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 用户名
	 */
	
	private String yonghuming;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 药敏史
	 */
	
	private String yaominshi;
		
	/**
	 * 症状
	 */
	
	private String zhengzhuang;
		
	/**
	 * 治疗情况
	 */
	
	private String zhiliaoqingkuang;
		
	/**
	 * 日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date riqi;
		
	/**
	 * 药单
	 */
	
	private String yaodan;
				
	
	/**
	 * 设置：用户名
	 */
	 
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：药敏史
	 */
	 
	public void setYaominshi(String yaominshi) {
		this.yaominshi = yaominshi;
	}
	
	/**
	 * 获取：药敏史
	 */
	public String getYaominshi() {
		return yaominshi;
	}
				
	
	/**
	 * 设置：症状
	 */
	 
	public void setZhengzhuang(String zhengzhuang) {
		this.zhengzhuang = zhengzhuang;
	}
	
	/**
	 * 获取：症状
	 */
	public String getZhengzhuang() {
		return zhengzhuang;
	}
				
	
	/**
	 * 设置：治疗情况
	 */
	 
	public void setZhiliaoqingkuang(String zhiliaoqingkuang) {
		this.zhiliaoqingkuang = zhiliaoqingkuang;
	}
	
	/**
	 * 获取：治疗情况
	 */
	public String getZhiliaoqingkuang() {
		return zhiliaoqingkuang;
	}
				
	
	/**
	 * 设置：日期
	 */
	 
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	
	/**
	 * 获取：日期
	 */
	public Date getRiqi() {
		return riqi;
	}
				
	
	/**
	 * 设置：药单
	 */
	 
	public void setYaodan(String yaodan) {
		this.yaodan = yaodan;
	}
	
	/**
	 * 获取：药单
	 */
	public String getYaodan() {
		return yaodan;
	}
			
}
