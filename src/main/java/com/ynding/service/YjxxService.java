package com.ynding.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.stereotype.Service;

import com.ynding.dao.YjxxDao;
import com.ynding.entity.Yjxx;
import com.ynding.exception.DbOprationException;


/*****
 * 邮寄信息
 * 
 * 作者 tianrui0518
 * 
 * 
 * 时间 2017-7-1
 * **/
@Service("yjxxService")
public class YjxxService extends BaseService<YjxxDao> {

	public YjxxService(SqlSessionFactoryBean sqlSessionFactoryBean) {
		super(sqlSessionFactoryBean);
		try {
			initMFB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int addYjxxInfo(List<Yjxx> yjxx) {//添加邮寄信息

		try {
			return this.batchAdd(yjxx);
		} catch (DbOprationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
 
}
