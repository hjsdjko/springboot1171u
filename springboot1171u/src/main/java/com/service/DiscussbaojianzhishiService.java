package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussbaojianzhishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussbaojianzhishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussbaojianzhishiView;


/**
 * 保健知识评论表
 *
 * @author 
 * @email 
 * @date 2023-03-20 13:32:03
 */
public interface DiscussbaojianzhishiService extends IService<DiscussbaojianzhishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussbaojianzhishiVO> selectListVO(Wrapper<DiscussbaojianzhishiEntity> wrapper);
   	
   	DiscussbaojianzhishiVO selectVO(@Param("ew") Wrapper<DiscussbaojianzhishiEntity> wrapper);
   	
   	List<DiscussbaojianzhishiView> selectListView(Wrapper<DiscussbaojianzhishiEntity> wrapper);
   	
   	DiscussbaojianzhishiView selectView(@Param("ew") Wrapper<DiscussbaojianzhishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussbaojianzhishiEntity> wrapper);
   	

}

