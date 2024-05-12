package com.entity.view;

import com.entity.KouqianglishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 口腔历史
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-20 13:32:03
 */
@TableName("kouqianglishi")
public class KouqianglishiView  extends KouqianglishiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KouqianglishiView(){
	}
 
 	public KouqianglishiView(KouqianglishiEntity kouqianglishiEntity){
 	try {
			BeanUtils.copyProperties(this, kouqianglishiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
