package edu.ecnu.admission.data;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import edu.ecnu.admission.po.AdmissionTicket;

public class ConnectionFactory{

	
	private static DruidDataSource dataSource = null;
	/**
	 * 初始化连接池
	 * @throws Exception
	 */
	public static void init() throws Exception {
		Properties properties = new Properties();
		
		InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream("druid.properties");  
		properties.load(in); 		
		dataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);		
		
		in.close();
	}
	/**
	 * 获取链接
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		if(null == dataSource)
		{
			init();
		}
        return dataSource.getConnection();
    }    
}
