package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YonghufankuiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YonghufankuiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YonghufankuiView;


/**
 * 用户反馈
 *
 * @author 
 * @email 
 * @date 2023-03-20 13:32:03
 */
public interface YonghufankuiService extends IService<YonghufankuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YonghufankuiVO> selectListVO(Wrapper<YonghufankuiEntity> wrapper);
   	
   	YonghufankuiVO selectVO(@Param("ew") Wrapper<YonghufankuiEntity> wrapper);
   	
   	List<YonghufankuiView> selectListView(Wrapper<YonghufankuiEntity> wrapper);
   	
   	YonghufankuiView selectView(@Param("ew") Wrapper<YonghufankuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YonghufankuiEntity> wrapper);
   	

}

