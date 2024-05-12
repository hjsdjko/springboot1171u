package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.BaojianzhishiEntity;
import com.entity.view.BaojianzhishiView;

import com.service.BaojianzhishiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 保健知识
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-20 13:32:03
 */
@RestController
@RequestMapping("/baojianzhishi")
public class BaojianzhishiController {
    @Autowired
    private BaojianzhishiService baojianzhishiService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BaojianzhishiEntity baojianzhishi,
		HttpServletRequest request){
        EntityWrapper<BaojianzhishiEntity> ew = new EntityWrapper<BaojianzhishiEntity>();

		PageUtils page = baojianzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baojianzhishi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BaojianzhishiEntity baojianzhishi, 
		HttpServletRequest request){
        EntityWrapper<BaojianzhishiEntity> ew = new EntityWrapper<BaojianzhishiEntity>();

		PageUtils page = baojianzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baojianzhishi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BaojianzhishiEntity baojianzhishi){
       	EntityWrapper<BaojianzhishiEntity> ew = new EntityWrapper<BaojianzhishiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( baojianzhishi, "baojianzhishi")); 
        return R.ok().put("data", baojianzhishiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BaojianzhishiEntity baojianzhishi){
        EntityWrapper< BaojianzhishiEntity> ew = new EntityWrapper< BaojianzhishiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( baojianzhishi, "baojianzhishi")); 
		BaojianzhishiView baojianzhishiView =  baojianzhishiService.selectView(ew);
		return R.ok("查询保健知识成功").put("data", baojianzhishiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BaojianzhishiEntity baojianzhishi = baojianzhishiService.selectById(id);
        return R.ok().put("data", baojianzhishi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BaojianzhishiEntity baojianzhishi = baojianzhishiService.selectById(id);
        return R.ok().put("data", baojianzhishi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        BaojianzhishiEntity baojianzhishi = baojianzhishiService.selectById(id);
        if(type.equals("1")) {
        	baojianzhishi.setThumbsupnum(baojianzhishi.getThumbsupnum()+1);
        } else {
        	baojianzhishi.setCrazilynum(baojianzhishi.getCrazilynum()+1);
        }
        baojianzhishiService.updateById(baojianzhishi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BaojianzhishiEntity baojianzhishi, HttpServletRequest request){
    	baojianzhishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(baojianzhishi);
        baojianzhishiService.insert(baojianzhishi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BaojianzhishiEntity baojianzhishi, HttpServletRequest request){
    	baojianzhishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(baojianzhishi);
        baojianzhishiService.insert(baojianzhishi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BaojianzhishiEntity baojianzhishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(baojianzhishi);
        baojianzhishiService.updateById(baojianzhishi);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        baojianzhishiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<BaojianzhishiEntity> wrapper = new EntityWrapper<BaojianzhishiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = baojianzhishiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
