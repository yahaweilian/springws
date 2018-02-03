package com.ynding.config;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * 多数据源支持
 *
 * @author biao
 * @author zzy
 * @since 2016.06
 */
public class MultiDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> dataSourceNames = new InheritableThreadLocal<String>();
    protected static String ORACLE = "oracle";
    protected static String MYSQL = "mysql";
    protected static String SYBASE = "sybase";
    protected static String SQLSERVER = "sqlserver";
    
    protected  Map<String,String> dialect = new HashMap<String,String>();
  

    public Map<String, String> getDialect() {
		return dialect;
	}

	public void setDataSource(String dataSourceName) {
        dataSourceNames.set(dataSourceName);
    }
	
	

    @Override
	public void setTargetDataSources(Map<Object, Object> targetDataSources) {
		super.setTargetDataSources(targetDataSources);
		for (Object key : targetDataSources.keySet()) {
			Object _value = targetDataSources.get(key);
			if(_value instanceof DruidAbstractDataSource){
				String driver = ((DruidAbstractDataSource)_value).getDriverClassName();
				if(driver.toLowerCase().contains(ORACLE)){
					dialect.put((String) key, ORACLE);
				}
				else if(driver.toLowerCase().contains(MYSQL)){
					dialect.put((String) key, MYSQL);
				}
				else if(driver.toLowerCase().contains(SYBASE)){
					dialect.put((String) key, SYBASE);
				}
				else if(driver.toLowerCase().contains(SQLSERVER)){
					dialect.put((String) key, SQLSERVER);
				}
			}
		}
	}

	@Override
    protected Object determineCurrentLookupKey() {
        return dataSourceNames.get();
    }
    
}
