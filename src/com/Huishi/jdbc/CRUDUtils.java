package com.Huishi.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 功能：封装增删改查
 * @author AsajuHuishi
 *
 */
public class CRUDUtils {
	/**
	 * 增删改 通用
	 * 针对任何表任何增删改
	 * @return
	 */
	public static int update(String sql,Object...params){//不确定个数 不确定类型
		//获取链接
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i=0;i<params.length;i++){
				preparedStatement.setObject(i+1, params[i]);
			}
			int update = preparedStatement.executeUpdate();
			return update;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.close(null, preparedStatement, connection);
		}
	}
	/**
	 * 单条查询StuScore表
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public static StuScore querySingle(String sql,Object...params){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		try {
			//获取连接
			connection = JDBCUtils.getConnection();
			//执行查询
			preparedStatement = connection.prepareStatement(sql);
			for (int i=0;i<params.length;i++){
				preparedStatement.setObject(i+1, params[i]);
			}
			set = preparedStatement.executeQuery();
			
			if(set.next()){//只有一行
				String no = set.getString("no");
				String name = set.getString("name");
				Float score = set.getFloat("score");
				int className = set.getInt("className");
				StuScore stu = new StuScore(no,name,score,className);
				return stu;
			}
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.close(set, preparedStatement, connection);
		}		
	}
	public static List<StuScore> queryMulti(String sql,Object...params){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		try {
			//获取连接
			connection = JDBCUtils.getConnection();
			//执行查询
			preparedStatement = connection.prepareStatement(sql);
			for (int i=0;i<params.length;i++){
				preparedStatement.setObject(i+1, params[i]);
			}
			set = preparedStatement.executeQuery();
			List list = new ArrayList<>();
			while(set.next()){//只有一行
				String no = set.getString("no");
				String name = set.getString("name");
				Float score = set.getFloat("score");
				int className = set.getInt("className");
				StuScore stu = new StuScore(no,name,score,className);
				list.add(stu);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.close(set, preparedStatement, connection);
		}		
	}
	
	public static List<Map<String,Object>> statistics() {
		Connection connection = null;
		ResultSet set = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement("select count(*),max(score),min(score),round(avg(score),4) from stu_score group by className order by avg(score) desc");
			List<Map<String,Object>> list = new ArrayList<>();
			set = preparedStatement.executeQuery();
			while (set.next()) {
				Map<String,Object> record = new HashMap<>();//保存于字典
				record.put("count", set.getObject(1));
				record.put("max_score", set.getObject(2));
				record.put("min_score", set.getObject(3));
				record.put("avg_score", set.getObject(4));
				list.add(record);	
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.close(set, preparedStatement, connection);
		}
	}
	
}
