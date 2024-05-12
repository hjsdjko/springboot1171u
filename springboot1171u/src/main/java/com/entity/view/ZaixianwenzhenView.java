package com.entity.view;

import com.entity.ZaixianwenzhenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 在线问诊
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-20 13:32:03
 */
@TableName("zaixianwenzhen")
public class ZaixianwenzhenView  extends ZaixianwenzhenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZaixianwenzhenView(){
	}
 
 	public ZaixianwenzhenView(ZaixianwenzhenEntity zaixianwenzhenEntity){
 	try {
			BeanUtils.copyProperties(this, zaixianwenzhenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
