package com.dao;

import com.entity.YonghufankuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YonghufankuiVO;
import com.entity.view.YonghufankuiView;


/**
 * 用户反馈
 * 
 * @author 
 * @email 
 * @date 2023-03-20 13:32:03
 */
public interface YonghufankuiDao extends BaseMapper<YonghufankuiEntity> {
	
	List<YonghufankuiVO> selectListVO(@Param("ew") Wrapper<YonghufankuiEntity> wrapper);
	
	YonghufankuiVO selectVO(@Param("ew") Wrapper<YonghufankuiEntity> wrapper);
	
	List<YonghufankuiView> selectListView(@Param("ew") Wrapper<YonghufankuiEntity> wrapper);

	List<YonghufankuiView> selectListView(Pagination page,@Param("ew") Wrapper<YonghufankuiEntity> wrapper);
	
	YonghufankuiView selectView(@Param("ew") Wrapper<YonghufankuiEntity> wrapper);
	

}
