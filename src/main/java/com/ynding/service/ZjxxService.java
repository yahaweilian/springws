package com.ynding.service;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.stereotype.Service;

import com.ynding.dao.ZyxxDao;
import com.ynding.entity.Zjxx;
import com.ynding.exception.DbOprationException;

@Service("zjxxService")
public class ZjxxService extends BaseService<ZyxxDao>{

	public ZjxxService(SqlSessionFactoryBean sqlSessionFactoryBean) {
		super(sqlSessionFactoryBean);
		try {
			initMFB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int addZjxx(Zjxx zjxx) throws DbOprationException {
			return this.add(zjxx);

	}

}
