package com.Huishi.jdbc;

import java.util.*;
/**
 * 实现学生成绩管理系统菜单功能
 * @author AsajuHuishi
 *
 */
public class StuMenu {
	private static Scanner s;
	public void menu() {
		//菜单
		int choose,choose2;
		List<Integer> chos = new ArrayList<Integer>();
		for (int i=1;i<8;i++) {
			chos.add(i);
		}
		Set<Integer> chooseSet = new HashSet<Integer>(chos);
		do {
			System.out.println("=======欢迎进入学生成绩管理系统=======");
			System.out.println("1.新增学生记录");
			System.out.println("2.修改学生记录");
			System.out.println("3.删除学生记录");
			System.out.println("4.按姓名或学号查询学生记录");
			System.out.println("5.按成绩排序");
			System.out.println("6.分班级统计");
			System.out.println("7.退出");
			System.out.println("请选择（1-7）：");
          
			Scanner scanner = new Scanner(System.in);
			choose = scanner.nextInt();
			while (!chooseSet.contains(choose)) {
				System.out.println("请选择（1-7）：");
				choose = scanner.nextInt();
			}
			
			System.out.println("******************************");
			switch (choose) {
			case 1:
				myAdd(); //菜单选择1，是新增学生
				break;
			case 2:
				myUpdate();  //菜单选择2，是修改学生
				break;
			case 3:
				myDel();  //菜单选择3，是删除学生
				break;
			case 4:       //菜单选择4，是查询学生
				System.out.print("请选择按姓名查询还是按照学号查询(1姓名 2学号):");
				Scanner sc2 = new Scanner(System.in);
				choose2 = sc2.nextInt();
				if (choose2==1) {
					myListByName();
				}else if (choose2==2) {
					myListByNo();  
				}
				break;
			case 5:    //菜单选择5，按成绩排序
				mySort();
				break;
			case 6:    //菜单选择6，统计
				myStatistic();
				break;
			case 7:     //菜单选择7，是退出该系统
	             System.out.println("您选择了退出系统，确定要退出吗？(y/n)");
	             Scanner sc3 = new Scanner(System.in);
	             String scanExit = sc3.next();
	             if(scanExit.equals("y")){
	            	 System.exit(-1);
	            	 System.out.println("您已成功退出系统，欢迎您再次使用！");
	             }
	             break;
			default:
				break;
			}
		} while (choose!=7);
	}
	//新增学生信息
	public static void myAdd() {
		String continute;
		do {
			s = new Scanner(System.in);
			String no, name;
			float score;
			int className;
			System.out.println("====新增学生====");
			System.out.println("学号(长度不超过10)：");
			no = s.next();
			System.out.println("班级(整数):");
			className = s.nextInt();
			System.out.println("姓名：");
			name = s.next();
			System.out.println("成绩：");
			score = s.nextFloat();    
			//调用StuScoreOperation
			StuScoreOperation.add(new StuScore(no, name, score, className));
			System.out.println("是否继续添加(y/n)：");
			s = new Scanner(System.in);
			continute = s.next();
		} while (continute.equals("y"));
	}
	//修改学生信息
	public static void myUpdate(){
		s = new Scanner(System.in);
		String no;
		System.out.println("====修改学生====");
		System.out.println("请输入要修改的学生学号：");
		no = s.next();
		StuScoreOperation.QueryByNo(no);

		System.out.println("请输入新的学生信息：");
		s = new Scanner(System.in);
		String name;
		float score;
		int className;
		System.out.println("学生班级：");
		className = s.nextInt();
		System.out.println("学生姓名：");
		name = s.next();
		System.out.println("学生成绩：");
		score = s.nextFloat();		
		StuScoreOperation.update(new StuScore(no, name, score, className));
	}  
	//删除学生信息
	public static void myDel(){
		s = new Scanner(System.in);
		String no;
		System.out.println("====删除学生====");
		System.out.println("请输入要删除的学生学号：");
		no = s.next();   
		StuScoreOperation.QueryByNo(no);
    
		System.out.println("是否真的删除(y/n)：");
		s = new Scanner(System.in);
		String x = s.next();
		if (x.equals("y")) {
			StuScoreOperation.delete(no);
		}
	}	
	//按姓名查询学生信息
	public static void myListByName(){
		s = new Scanner(System.in);
		System.out.println("====查询学生====");
		System.out.println("请输入要查看的学生姓名：");
		StuScoreOperation.QueryByName(s.next());	
	}	
	//按学号查询学生信息
	public static void myListByNo(){
		s = new Scanner(System.in);
		System.out.println("====查询学生====");
		System.out.println("请输入要查看的学生学号：");
		StuScoreOperation.QueryByNo(s.next());	
	}
	//排序
	public static void mySort() {
		System.out.println("按成绩升序显示");
		System.out.println("学号\t\t班级\t姓名\t成绩");
		List<StuScore> list = StuScoreOperation.showBySortScore();
		for (StuScore stuList:list) {
			System.out.println(stuList.getNo()+"\t"+stuList.getClassName()+"\t"+stuList.getName()+"\t"+stuList.getScore());
		}
	}
	//统计
	public static void myStatistic() {
		System.out.println("统计(分班级统计学生数量,最高分,最低分,平均值)");
		List<Map<String,Object>> list = StuScoreOperation.statistics();
		System.out.println(list);
		System.out.println("count\tmax_score\tmin_score\tavg_score");
		for (Map<String,Object> m: list) {
			System.out.println(m.get("count")+"\t"+m.get("max_score")+"\t\t"+m.get("min_score")+"\t\t"+m.get("avg_score"));
		}
	}	
}
