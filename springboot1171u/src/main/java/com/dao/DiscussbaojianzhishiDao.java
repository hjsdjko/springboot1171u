package com.dao;

import com.entity.DiscussbaojianzhishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussbaojianzhishiVO;
import com.entity.view.DiscussbaojianzhishiView;


/**
 * 保健知识评论表
 * 
 * @author 
 * @email 
 * @date 2023-03-20 13:32:03
 */
public interface DiscussbaojianzhishiDao extends BaseMapper<DiscussbaojianzhishiEntity> {
	
	List<DiscussbaojianzhishiVO> selectListVO(@Param("ew") Wrapper<DiscussbaojianzhishiEntity> wrapper);
	
	DiscussbaojianzhishiVO selectVO(@Param("ew") Wrapper<DiscussbaojianzhishiEntity> wrapper);
	
	List<DiscussbaojianzhishiView> selectListView(@Param("ew") Wrapper<DiscussbaojianzhishiEntity> wrapper);

	List<DiscussbaojianzhishiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussbaojianzhishiEntity> wrapper);
	
	DiscussbaojianzhishiView selectView(@Param("ew") Wrapper<DiscussbaojianzhishiEntity> wrapper);
	

}
