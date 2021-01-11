package com.Huishi.jdbc;

import java.util.*;

/**
 * ���ܣ�ʵ�ֶ����ݿ����ҵ�����:��ɾ�Ĳ�
 * @author AsajuHuishi
 *
 */
public class StuScoreOperation {
	/**
	 * ����ѧ����¼
	 * @param 
	 */
	public static void add(StuScore stu){
		System.out.println("����ѧ����¼...");
//		System.out.println(stu.getNo()+stu.getName()+stu.getScore()+stu.getClassName());
		int update = CRUDUtils.update("insert into stu_score(no,name,score,className) values(?,?,?,?)", stu.getNo(),stu.getName(),stu.getScore(),stu.getClassName());
		System.out.println(update>0?"��ӳɹ�":"���ʧ��");
	}
	/**
	 * ����ѧ���޸�ѧ����¼
	 * @param 
	 */
	public static void update(StuScore stu){
		System.out.println("����ѧ���޸�ѧ����¼...");
		int update = CRUDUtils.update("update stu_score set name=?,score=?,className=? where no=?",stu.getName(),stu.getScore(),stu.getClassName(), stu.getNo());
		System.out.println(update>0?"�޸ĳɹ�":"�޸�ʧ��");
	}	
	/**
	 * ����ѧ��ɾ��ѧ����¼
	 * @param 
	 */
	public static void delete(String no){
		System.out.println("����ѧ��ɾ��ѧ����¼...");
		int update = CRUDUtils.update("delete from stu_score where no=?",no);
		System.out.println(update>0?"ɾ���ɹ�":"ɾ��ʧ��");
	}		
	/**
	 * ����������ѧ����¼
	 * @param 
	 * @return float grade
	 */
	public static StuScore QueryByName(String name){
		System.out.println("����������ѧ����¼...");
		StuScore stu = CRUDUtils.querySingle("select * from stu_score where name=?", name);
		if (stu != null){
			System.out.println("��ѧ������Ϣ���£�");
			System.out.println("ѧ��ѧ�ţ�"+stu.getNo());
			System.out.println("ѧ���༶��"+stu.getClassName());
			System.out.println("ѧ��������"+stu.getName());
			System.out.println("ѧ���ɼ���"+stu.getScore());
			return stu;
		}else{
			System.out.println("δ�ҵ�������:"+name);
			return null;
		}
	}
	/**
	 * ����ѧ�Ų�ѧ����¼
	 * @param 
	 * @return float grade 
	 */
	public static StuScore QueryByNo(String no){
		System.out.println("����ѧ�Ų�ѧ����¼...");
		StuScore stu = CRUDUtils.querySingle("select * from stu_score where no=?", no);
		if (stu != null){
			System.out.println("��ѧ������Ϣ���£�");
			System.out.println("ѧ��ѧ�ţ�"+stu.getNo());
			System.out.println("ѧ���༶��"+stu.getClassName());
			System.out.println("ѧ��������"+stu.getName());
			System.out.println("ѧ���ɼ���"+stu.getScore());
			return stu;
		}else{
			System.out.println("δ�ҵ���ѧ��:"+no);
			return null;
		}
	}	
	/**
	 * ���ɼ�����
	 * @return List<StuScore> list
	 */
	public static List<StuScore> showBySortScore() {
		System.out.println("���ɼ�����...");
		List<StuScore> list = CRUDUtils.queryMulti("select * from stu_score order by score");
		return list;
	}
	/**
	 * ͳ��
	 * @return List<Map<String,Object>> list
	 */
	public static List<Map<String,Object>> statistics() {
		System.out.println("ͳ��(�ְ༶ͳ��ѧ������,��߷�,��ͷ�,ƽ��ֵ)...");
		List<Map<String,Object>>  list = CRUDUtils.statistics();
		return list;
	}
}
