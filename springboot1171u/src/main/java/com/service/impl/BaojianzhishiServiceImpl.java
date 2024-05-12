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


import com.dao.BaojianzhishiDao;
import com.entity.BaojianzhishiEntity;
import com.service.BaojianzhishiService;
import com.entity.vo.BaojianzhishiVO;
import com.entity.view.BaojianzhishiView;

@Service("baojianzhishiService")
public class BaojianzhishiServiceImpl extends ServiceImpl<BaojianzhishiDao, BaojianzhishiEntity> implements BaojianzhishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BaojianzhishiEntity> page = this.selectPage(
                new Query<BaojianzhishiEntity>(params).getPage(),
                new EntityWrapper<BaojianzhishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BaojianzhishiEntity> wrapper) {
		  Page<BaojianzhishiView> page =new Query<BaojianzhishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BaojianzhishiVO> selectListVO(Wrapper<BaojianzhishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BaojianzhishiVO selectVO(Wrapper<BaojianzhishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BaojianzhishiView> selectListView(Wrapper<BaojianzhishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BaojianzhishiView selectView(Wrapper<BaojianzhishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
