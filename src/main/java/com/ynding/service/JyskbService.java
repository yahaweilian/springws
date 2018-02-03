package com.ynding.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.stereotype.Service;

import com.ynding.dao.JyskbDao;
import com.ynding.entity.Jyskb;
import com.ynding.exception.DbOprationException;



/*****
 * 交易税款表服务层
 * 
 * 作者 tianrui0518
 * 
 * 
 * 时间 2017-7-1
 * **/
@Service("jyskbService")
public class JyskbService extends BaseService<JyskbDao> {

	public JyskbService(SqlSessionFactoryBean sqlSessionFactoryBean) {
		super(sqlSessionFactoryBean);
		try {
			initMFB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int addJyskbInfo(List<Jyskb> jyskb) throws DbOprationException {//添加房产信息

			return this.batchAdd(jyskb);
	
	}
	public List<Jyskb> getJyskbList(String uuid){
		  Map<String,Object> params = this.newParamsMap();
			params.put("fcxxId",uuid);
		  try {
			return this.getList(params);
		} catch (DbOprationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return null;
	  } 
	public List<Jyskb> getJyskbListlb(String uuid){
		  Map<String,Object> params = this.newParamsMap();
			params.put("fcxxId",uuid);
		  try {
			return this.mapperfb.getObject().getJyskbLists(params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return null;
	  } 
	public List<Jyskb> getZzsList(String uuid,String zhsdm){
		  Map<String,Object> params = this.newParamsMap();
			params.put("fcxxId",uuid);
			params.put("zsxmdm",zhsdm);
		  try {
			return this.mapperfb.getObject().getZzsList(params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return null;
	  } 
	
}
