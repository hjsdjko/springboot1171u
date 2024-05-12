package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BaojianzhishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BaojianzhishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BaojianzhishiView;


/**
 * 保健知识
 *
 * @author 
 * @email 
 * @date 2023-03-20 13:32:03
 */
public interface BaojianzhishiService extends IService<BaojianzhishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BaojianzhishiVO> selectListVO(Wrapper<BaojianzhishiEntity> wrapper);
   	
   	BaojianzhishiVO selectVO(@Param("ew") Wrapper<BaojianzhishiEntity> wrapper);
   	
   	List<BaojianzhishiView> selectListView(Wrapper<BaojianzhishiEntity> wrapper);
   	
   	BaojianzhishiView selectView(@Param("ew") Wrapper<BaojianzhishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BaojianzhishiEntity> wrapper);
   	

}

