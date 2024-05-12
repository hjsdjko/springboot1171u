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


import com.dao.KouqianglishiDao;
import com.entity.KouqianglishiEntity;
import com.service.KouqianglishiService;
import com.entity.vo.KouqianglishiVO;
import com.entity.view.KouqianglishiView;

@Service("kouqianglishiService")
public class KouqianglishiServiceImpl extends ServiceImpl<KouqianglishiDao, KouqianglishiEntity> implements KouqianglishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KouqianglishiEntity> page = this.selectPage(
                new Query<KouqianglishiEntity>(params).getPage(),
                new EntityWrapper<KouqianglishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KouqianglishiEntity> wrapper) {
		  Page<KouqianglishiView> page =new Query<KouqianglishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KouqianglishiVO> selectListVO(Wrapper<KouqianglishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KouqianglishiVO selectVO(Wrapper<KouqianglishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KouqianglishiView> selectListView(Wrapper<KouqianglishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KouqianglishiView selectView(Wrapper<KouqianglishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
