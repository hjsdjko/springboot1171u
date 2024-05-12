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


import com.dao.DiscussbaojianzhishiDao;
import com.entity.DiscussbaojianzhishiEntity;
import com.service.DiscussbaojianzhishiService;
import com.entity.vo.DiscussbaojianzhishiVO;
import com.entity.view.DiscussbaojianzhishiView;

@Service("discussbaojianzhishiService")
public class DiscussbaojianzhishiServiceImpl extends ServiceImpl<DiscussbaojianzhishiDao, DiscussbaojianzhishiEntity> implements DiscussbaojianzhishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussbaojianzhishiEntity> page = this.selectPage(
                new Query<DiscussbaojianzhishiEntity>(params).getPage(),
                new EntityWrapper<DiscussbaojianzhishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussbaojianzhishiEntity> wrapper) {
		  Page<DiscussbaojianzhishiView> page =new Query<DiscussbaojianzhishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussbaojianzhishiVO> selectListVO(Wrapper<DiscussbaojianzhishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussbaojianzhishiVO selectVO(Wrapper<DiscussbaojianzhishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussbaojianzhishiView> selectListView(Wrapper<DiscussbaojianzhishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussbaojianzhishiView selectView(Wrapper<DiscussbaojianzhishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
