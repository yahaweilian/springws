package com.ynding.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.stereotype.Service;

import com.ynding.dao.YcclilbDao;
import com.ynding.entity.Yccljlb;
import com.ynding.exception.DbOprationException;

/*****
 * 异常处理表服务层
 * 
 * 作者 tianrui0518
 * 
 * 
 * 时间 2017-7-7
 * **/
@Service("ycclilbService")
public class YcclilbService extends BaseService<YcclilbDao>{

	public YcclilbService(SqlSessionFactoryBean sqlSessionFactoryBean) {
		super(sqlSessionFactoryBean);
		try {
			initMFB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Yccljlb> getYcclilbList(){
		  Map<String,Object> params = this.newParamsMap();
			params.put("sdzt","1");//1为锁定状态
			
		  try {
			return this.getList(params);
		} catch (DbOprationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return null;
	  } 
}
