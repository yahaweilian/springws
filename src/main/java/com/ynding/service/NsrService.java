package com.ynding.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.stereotype.Service;

import com.ynding.dao.NsrDao;
import com.ynding.entity.Nsr;
import com.ynding.exception.DbOprationException;


/*****
 * 纳税人服务层
 * 
 * 作者 tianrui0518
 * 
 * 
 * 时间 2017-7-1
 * **/
@Service("nsrService")
public class NsrService extends BaseService<NsrDao> {

	public NsrService(SqlSessionFactoryBean sqlSessionFactoryBean) {
		super(sqlSessionFactoryBean);
		try {
			initMFB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int addNsrInfo(List<Nsr> nsr) throws DbOprationException {//添加房产信息

			return this.batchAdd(nsr);
	
	}
	
	public List<Nsr> getNsrList(Map map){
		  try {
			return this.getList(map);
		} catch (DbOprationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return null;
	  } 
	
	public List<Nsr> getNsrs(Map map){
		  try {
			return this.mapperfb.getObject().getNseLists(map);
		} catch (DbOprationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return null;
	  } 
	
	public List<Nsr> getNsrList(String uuid){
		  Map<String,Object> params = this.newParamsMap();
			params.put("fwxxId",uuid);
		  try {
			return this.getList(params);
		} catch (DbOprationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return null;
	  } 
	
	public Nsr getNsrClr(String nsrxm,String nsrzjhm){
		  Map<String,Object> params = this.newParamsMap();
			params.put("nsrxm",nsrxm);
			params.put("nsrzjhm",nsrzjhm);
			try {
				return this.mapperfb.getObject().getNsrClr(params);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	  } 
	
	
}
