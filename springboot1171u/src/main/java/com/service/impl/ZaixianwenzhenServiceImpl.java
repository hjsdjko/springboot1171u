package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZaixianwenzhenDao;
import com.entity.ZaixianwenzhenEntity;
import com.service.ZaixianwenzhenService;
import com.entity.vo.ZaixianwenzhenVO;
import com.entity.view.ZaixianwenzhenView;

@Service("zaixianwenzhenService")
public class ZaixianwenzhenServiceImpl extends ServiceImpl<ZaixianwenzhenDao, ZaixianwenzhenEntity> implements ZaixianwenzhenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZaixianwenzhenEntity> page = this.selectPage(
                new Query<ZaixianwenzhenEntity>(params).getPage(),
                new EntityWrapper<ZaixianwenzhenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZaixianwenzhenEntity> wrapper) {
		  Page<ZaixianwenzhenView> page =new Query<ZaixianwenzhenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZaixianwenzhenVO> selectListVO(Wrapper<ZaixianwenzhenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZaixianwenzhenVO selectVO(Wrapper<ZaixianwenzhenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZaixianwenzhenView> selectListView(Wrapper<ZaixianwenzhenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZaixianwenzhenView selectView(Wrapper<ZaixianwenzhenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
