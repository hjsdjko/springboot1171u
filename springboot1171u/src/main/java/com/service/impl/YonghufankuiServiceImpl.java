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


import com.dao.YonghufankuiDao;
import com.entity.YonghufankuiEntity;
import com.service.YonghufankuiService;
import com.entity.vo.YonghufankuiVO;
import com.entity.view.YonghufankuiView;

@Service("yonghufankuiService")
public class YonghufankuiServiceImpl extends ServiceImpl<YonghufankuiDao, YonghufankuiEntity> implements YonghufankuiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YonghufankuiEntity> page = this.selectPage(
                new Query<YonghufankuiEntity>(params).getPage(),
                new EntityWrapper<YonghufankuiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YonghufankuiEntity> wrapper) {
		  Page<YonghufankuiView> page =new Query<YonghufankuiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YonghufankuiVO> selectListVO(Wrapper<YonghufankuiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YonghufankuiVO selectVO(Wrapper<YonghufankuiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YonghufankuiView> selectListView(Wrapper<YonghufankuiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YonghufankuiView selectView(Wrapper<YonghufankuiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
