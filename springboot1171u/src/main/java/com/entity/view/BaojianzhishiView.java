package com.entity.view;

import com.entity.BaojianzhishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 保健知识
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-20 13:32:03
 */
@TableName("baojianzhishi")
public class BaojianzhishiView  extends BaojianzhishiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BaojianzhishiView(){
	}
 
 	public BaojianzhishiView(BaojianzhishiEntity baojianzhishiEntity){
 	try {
			BeanUtils.copyProperties(this, baojianzhishiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
