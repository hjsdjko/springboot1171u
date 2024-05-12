package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KouqianglishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KouqianglishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KouqianglishiView;


/**
 * 口腔历史
 *
 * @author 
 * @email 
 * @date 2023-03-20 13:32:03
 */
public interface KouqianglishiService extends IService<KouqianglishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KouqianglishiVO> selectListVO(Wrapper<KouqianglishiEntity> wrapper);
   	
   	KouqianglishiVO selectVO(@Param("ew") Wrapper<KouqianglishiEntity> wrapper);
   	
   	List<KouqianglishiView> selectListView(Wrapper<KouqianglishiEntity> wrapper);
   	
   	KouqianglishiView selectView(@Param("ew") Wrapper<KouqianglishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KouqianglishiEntity> wrapper);
   	

}

