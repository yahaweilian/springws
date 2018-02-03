package com.ynding.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.stereotype.Service;

import com.ynding.dao.TpfjDao;
import com.ynding.entity.Tpfj;
import com.ynding.exception.DbOprationException;
import com.ynding.ws.param2.taxML.Fctpfj;


/*****
 * 图片附件服务层
 * 
 * 作者 tianrui0518
 * 
 * 
 * 时间 2017-7-1
 * **/
@Service("tpfjService")
public class TpfjService extends BaseService<TpfjDao> {

	public TpfjService(SqlSessionFactoryBean sqlSessionFactoryBean) {
		super(sqlSessionFactoryBean);
		try {
			initMFB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int addTpfjInfo(List<Tpfj> tpfj) {//添加房产信息

		try {
			return this.batchAdd(tpfj);
		} catch (DbOprationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
  public List<Tpfj> getTpfjList(String uuid){
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
  
  /**
   * 判断list在数据库是否已经存在
   * @param list
   * @return 0:list里元素在库里全部存在，1：list里元素在库里没一个存在，
   * 		 2：传入的list是空， 3：其他
   * @throws DbOprationException
   */
  public int isInDb(List<Fctpfj> list) throws DbOprationException{
	  if(list != null && list.size() <= 0 ){
		  return 2;
	  }
	  
	  Map<String, Object> map = new HashMap<>();
	  map.put("fctpfjList", list);
	  try {
		int i = this.mapperfb.getObject().getCountByFctpid(map);
		if(i == 0){
			return 1;
		}else if(i >0 && list.size() == i){
			return 0;
		}
	  } catch (Exception e) {
		e.printStackTrace();
		throw new DbOprationException();
	  }
	  
	  return 3;
  }
  public void updateFctpfj(List<Fctpfj> list) {
		 try {
			(this.mapperfb.getObject()).updateFctpfj(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
