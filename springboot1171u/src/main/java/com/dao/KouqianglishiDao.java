package com.dao;

import com.entity.KouqianglishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KouqianglishiVO;
import com.entity.view.KouqianglishiView;


/**
 * 口腔历史
 * 
 * @author 
 * @email 
 * @date 2023-03-20 13:32:03
 */
public interface KouqianglishiDao extends BaseMapper<KouqianglishiEntity> {
	
	List<KouqianglishiVO> selectListVO(@Param("ew") Wrapper<KouqianglishiEntity> wrapper);
	
	KouqianglishiVO selectVO(@Param("ew") Wrapper<KouqianglishiEntity> wrapper);
	
	List<KouqianglishiView> selectListView(@Param("ew") Wrapper<KouqianglishiEntity> wrapper);

	List<KouqianglishiView> selectListView(Pagination page,@Param("ew") Wrapper<KouqianglishiEntity> wrapper);
	
	KouqianglishiView selectView(@Param("ew") Wrapper<KouqianglishiEntity> wrapper);
	

}
