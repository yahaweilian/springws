package com.ynding.service;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.stereotype.Service;

import com.ynding.dao.JspzDao;
import com.ynding.entity.Jspz;
import com.ynding.exception.DbOprationException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("jspzService")
public class JspzService extends BaseService<JspzDao>{

	public JspzService(SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
		super(sqlSessionFactoryBean);
		initMFB();
	}

	public List<Jspz> getQyList() throws DbOprationException {
		Map<String,Object> params = this.newParamsMap();
		params.put("sfqy","Y");
		return this.getList(params);
		//return null;
		//return <Jspz> super.getList();
	}
	public Jspz getBYJmxzdm(String yhdm) throws DbOprationException{
		try {
			return this.mapperfb.getObject().getByJmxzdm(yhdm);
		} catch (Exception e) {
			e.printStackTrace();
			throw new
			DbOprationException();
		}
	}
	
}
