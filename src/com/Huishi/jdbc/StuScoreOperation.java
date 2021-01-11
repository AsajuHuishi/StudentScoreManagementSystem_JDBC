package com.Huishi.jdbc;

import java.util.*;

/**
 * 功能：实现对数据库具体业务操作:增删改查
 * @author AsajuHuishi
 *
 */
public class StuScoreOperation {
	/**
	 * 增加学生记录
	 * @param 
	 */
	public static void add(StuScore stu){
		System.out.println("增加学生记录...");
//		System.out.println(stu.getNo()+stu.getName()+stu.getScore()+stu.getClassName());
		int update = CRUDUtils.update("insert into stu_score(no,name,score,className) values(?,?,?,?)", stu.getNo(),stu.getName(),stu.getScore(),stu.getClassName());
		System.out.println(update>0?"添加成功":"添加失败");
	}
	/**
	 * 按照学号修改学生记录
	 * @param 
	 */
	public static void update(StuScore stu){
		System.out.println("按照学号修改学生记录...");
		int update = CRUDUtils.update("update stu_score set name=?,score=?,className=? where no=?",stu.getName(),stu.getScore(),stu.getClassName(), stu.getNo());
		System.out.println(update>0?"修改成功":"修改失败");
	}	
	/**
	 * 按照学号删除学生记录
	 * @param 
	 */
	public static void delete(String no){
		System.out.println("按照学号删除学生记录...");
		int update = CRUDUtils.update("delete from stu_score where no=?",no);
		System.out.println(update>0?"删除成功":"删除失败");
	}		
	/**
	 * 按照姓名查学生记录
	 * @param 
	 * @return float grade
	 */
	public static StuScore QueryByName(String name){
		System.out.println("按照姓名查学生记录...");
		StuScore stu = CRUDUtils.querySingle("select * from stu_score where name=?", name);
		if (stu != null){
			System.out.println("该学生的信息如下：");
			System.out.println("学生学号："+stu.getNo());
			System.out.println("学生班级："+stu.getClassName());
			System.out.println("学生姓名："+stu.getName());
			System.out.println("学生成绩："+stu.getScore());
			return stu;
		}else{
			System.out.println("未找到此姓名:"+name);
			return null;
		}
	}
	/**
	 * 按照学号查学生记录
	 * @param 
	 * @return float grade 
	 */
	public static StuScore QueryByNo(String no){
		System.out.println("按照学号查学生记录...");
		StuScore stu = CRUDUtils.querySingle("select * from stu_score where no=?", no);
		if (stu != null){
			System.out.println("该学生的信息如下：");
			System.out.println("学生学号："+stu.getNo());
			System.out.println("学生班级："+stu.getClassName());
			System.out.println("学生姓名："+stu.getName());
			System.out.println("学生成绩："+stu.getScore());
			return stu;
		}else{
			System.out.println("未找到此学号:"+no);
			return null;
		}
	}	
	/**
	 * 按成绩排序
	 * @return List<StuScore> list
	 */
	public static List<StuScore> showBySortScore() {
		System.out.println("按成绩排序...");
		List<StuScore> list = CRUDUtils.queryMulti("select * from stu_score order by score");
		return list;
	}
	/**
	 * 统计
	 * @return List<Map<String,Object>> list
	 */
	public static List<Map<String,Object>> statistics() {
		System.out.println("统计(分班级统计学生数量,最高分,最低分,平均值)...");
		List<Map<String,Object>>  list = CRUDUtils.statistics();
		return list;
	}
}
