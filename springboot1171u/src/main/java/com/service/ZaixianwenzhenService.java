package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZaixianwenzhenEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZaixianwenzhenVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZaixianwenzhenView;


/**
 * 在线问诊
 *
 * @author 
 * @email 
 * @date 2023-03-20 13:32:03
 */
public interface ZaixianwenzhenService extends IService<ZaixianwenzhenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZaixianwenzhenVO> selectListVO(Wrapper<ZaixianwenzhenEntity> wrapper);
   	
   	ZaixianwenzhenVO selectVO(@Param("ew") Wrapper<ZaixianwenzhenEntity> wrapper);
   	
   	List<ZaixianwenzhenView> selectListView(Wrapper<ZaixianwenzhenEntity> wrapper);
   	
   	ZaixianwenzhenView selectView(@Param("ew") Wrapper<ZaixianwenzhenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZaixianwenzhenEntity> wrapper);
   	

}

