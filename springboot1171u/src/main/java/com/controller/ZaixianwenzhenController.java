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

import com.entity.ZaixianwenzhenEntity;
import com.entity.view.ZaixianwenzhenView;

import com.service.ZaixianwenzhenService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 在线问诊
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-20 13:32:03
 */
@RestController
@RequestMapping("/zaixianwenzhen")
public class ZaixianwenzhenController {
    @Autowired
    private ZaixianwenzhenService zaixianwenzhenService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZaixianwenzhenEntity zaixianwenzhen,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			zaixianwenzhen.setYishenggonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			zaixianwenzhen.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZaixianwenzhenEntity> ew = new EntityWrapper<ZaixianwenzhenEntity>();

		PageUtils page = zaixianwenzhenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianwenzhen), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZaixianwenzhenEntity zaixianwenzhen, 
		HttpServletRequest request){
        EntityWrapper<ZaixianwenzhenEntity> ew = new EntityWrapper<ZaixianwenzhenEntity>();

		PageUtils page = zaixianwenzhenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianwenzhen), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZaixianwenzhenEntity zaixianwenzhen){
       	EntityWrapper<ZaixianwenzhenEntity> ew = new EntityWrapper<ZaixianwenzhenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zaixianwenzhen, "zaixianwenzhen")); 
        return R.ok().put("data", zaixianwenzhenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZaixianwenzhenEntity zaixianwenzhen){
        EntityWrapper< ZaixianwenzhenEntity> ew = new EntityWrapper< ZaixianwenzhenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zaixianwenzhen, "zaixianwenzhen")); 
		ZaixianwenzhenView zaixianwenzhenView =  zaixianwenzhenService.selectView(ew);
		return R.ok("查询在线问诊成功").put("data", zaixianwenzhenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZaixianwenzhenEntity zaixianwenzhen = zaixianwenzhenService.selectById(id);
        return R.ok().put("data", zaixianwenzhen);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZaixianwenzhenEntity zaixianwenzhen = zaixianwenzhenService.selectById(id);
        return R.ok().put("data", zaixianwenzhen);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZaixianwenzhenEntity zaixianwenzhen, HttpServletRequest request){
    	zaixianwenzhen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zaixianwenzhen);
        zaixianwenzhenService.insert(zaixianwenzhen);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZaixianwenzhenEntity zaixianwenzhen, HttpServletRequest request){
    	zaixianwenzhen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zaixianwenzhen);
        zaixianwenzhenService.insert(zaixianwenzhen);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZaixianwenzhenEntity zaixianwenzhen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zaixianwenzhen);
        zaixianwenzhenService.updateById(zaixianwenzhen);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zaixianwenzhenService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ZaixianwenzhenEntity> wrapper = new EntityWrapper<ZaixianwenzhenEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			wrapper.eq("yishenggonghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = zaixianwenzhenService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
