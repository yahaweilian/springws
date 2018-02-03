package com.ynding.service;

import java.util.Map;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.stereotype.Service;

import com.ynding.dao.JyztbDao;
import com.ynding.entity.Jyztb;
import com.ynding.exception.DbOprationException;


/*****
 * 交易状态表服务层
 * 
 * 作者 tianrui0518
 * 
 * 
 * 时间 2017-7-1
 * **/
@Service("jyztbService")
public class JyztbService extends BaseService<JyztbDao> {

	public JyztbService(SqlSessionFactoryBean sqlSessionFactoryBean) {
		super(sqlSessionFactoryBean);
		try {
			initMFB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int addJyztbInfo(Jyztb jyztb) throws DbOprationException {//添加房产信息

			return this.add(jyztb);

	}
	
	public Jyztb getJyztb(Map map){
		  try {
			return  this.getObject(map);
		} catch (DbOprationException e) {
			e.printStackTrace();
		}
		  return null;
	  } 
	
	
	public Jyztb getJyztbList(String uuid,String Channelid){
		  Map<String,Object> params = this.newParamsMap();
			params.put("fcxxId",uuid);//
			params.put("channelId",Channelid);//根据channel来判断渠道，不是同一渠道的不能办理
		  try {
			return (Jyztb) this.getList(params).get(0);
		} catch (DbOprationException e) {
			e.printStackTrace();
		}
		  return null;
	  }
	
	

	public int addBdcxxInfo(Map<String, Object> params) throws Exception {
		return this.mapperfb.getObject().update_dynamic(params);
	} 
	
	public int getwsjy(String  fwuuid) throws Exception{
		Map<String, Object> params = this.getNewParamMap();
		params.put("fwuuid", fwuuid);
		return this.mapperfb.getObject().getwsjy(params);
	}
	
	public int updateFpkpbj(String  fwuuid) throws Exception{
		Map<String, Object> params = this.getNewParamMap();
		params.put("fwuuid", fwuuid);
		return this.mapperfb.getObject().updateFpkpbj(params);
	}
}
