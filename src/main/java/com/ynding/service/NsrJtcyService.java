package com.ynding.service;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.stereotype.Service;

import com.ynding.dao.NsrJtcyDao;
import com.ynding.entity.NsrJtcy;
import com.ynding.exception.DbOprationException;

import java.util.List;
import java.util.Map;

/**
 * Created by wangdong on 2017/7/16.
 */
@Service("nsrJtcyService")
public class NsrJtcyService extends BaseService<NsrJtcyDao>{

    public NsrJtcyService(SqlSessionFactoryBean sqlSessionFactoryBean) {
        super(sqlSessionFactoryBean);
        try {
            initMFB();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public List<NsrJtcy> getNsrJecyList(Map map){
    	try {
			return this.getList(map);
		} catch (DbOprationException e) {
			e.printStackTrace();
		}
    	return null;
    	
    }

    public int addNsrJtcyInfo(List<NsrJtcy> nsrJtcy) throws DbOprationException {//添加房产信息

            return this.batchAdd(nsrJtcy);
   
    }
}
