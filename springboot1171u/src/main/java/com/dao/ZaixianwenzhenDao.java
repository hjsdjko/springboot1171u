package com.dao;

import com.entity.ZaixianwenzhenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZaixianwenzhenVO;
import com.entity.view.ZaixianwenzhenView;


/**
 * 在线问诊
 * 
 * @author 
 * @email 
 * @date 2023-03-20 13:32:03
 */
public interface ZaixianwenzhenDao extends BaseMapper<ZaixianwenzhenEntity> {
	
	List<ZaixianwenzhenVO> selectListVO(@Param("ew") Wrapper<ZaixianwenzhenEntity> wrapper);
	
	ZaixianwenzhenVO selectVO(@Param("ew") Wrapper<ZaixianwenzhenEntity> wrapper);
	
	List<ZaixianwenzhenView> selectListView(@Param("ew") Wrapper<ZaixianwenzhenEntity> wrapper);

	List<ZaixianwenzhenView> selectListView(Pagination page,@Param("ew") Wrapper<ZaixianwenzhenEntity> wrapper);
	
	ZaixianwenzhenView selectView(@Param("ew") Wrapper<ZaixianwenzhenEntity> wrapper);
	

}
