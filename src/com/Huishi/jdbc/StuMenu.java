package com.Huishi.jdbc;

import java.util.*;
/**
 * ʵ��ѧ���ɼ�����ϵͳ�˵�����
 * @author AsajuHuishi
 *
 */
public class StuMenu {
	private static Scanner s;
	public void menu() {
		//�˵�
		int choose,choose2;
		List<Integer> chos = new ArrayList<Integer>();
		for (int i=1;i<8;i++) {
			chos.add(i);
		}
		Set<Integer> chooseSet = new HashSet<Integer>(chos);
		do {
			System.out.println("=======��ӭ����ѧ���ɼ�����ϵͳ=======");
			System.out.println("1.����ѧ����¼");
			System.out.println("2.�޸�ѧ����¼");
			System.out.println("3.ɾ��ѧ����¼");
			System.out.println("4.��������ѧ�Ų�ѯѧ����¼");
			System.out.println("5.���ɼ�����");
			System.out.println("6.�ְ༶ͳ��");
			System.out.println("7.�˳�");
			System.out.println("��ѡ��1-7����");
          
			Scanner scanner = new Scanner(System.in);
			choose = scanner.nextInt();
			while (!chooseSet.contains(choose)) {
				System.out.println("��ѡ��1-7����");
				choose = scanner.nextInt();
			}
			
			System.out.println("******************************");
			switch (choose) {
			case 1:
				myAdd(); //�˵�ѡ��1��������ѧ��
				break;
			case 2:
				myUpdate();  //�˵�ѡ��2�����޸�ѧ��
				break;
			case 3:
				myDel();  //�˵�ѡ��3����ɾ��ѧ��
				break;
			case 4:       //�˵�ѡ��4���ǲ�ѯѧ��
				System.out.print("��ѡ��������ѯ���ǰ���ѧ�Ų�ѯ(1���� 2ѧ��):");
				Scanner sc2 = new Scanner(System.in);
				choose2 = sc2.nextInt();
				if (choose2==1) {
					myListByName();
				}else if (choose2==2) {
					myListByNo();  
				}
				break;
			case 5:    //�˵�ѡ��5�����ɼ�����
				mySort();
				break;
			case 6:    //�˵�ѡ��6��ͳ��
				myStatistic();
				break;
			case 7:     //�˵�ѡ��7�����˳���ϵͳ
	             System.out.println("��ѡ�����˳�ϵͳ��ȷ��Ҫ�˳���(y/n)");
	             Scanner sc3 = new Scanner(System.in);
	             String scanExit = sc3.next();
	             if(scanExit.equals("y")){
	            	 System.exit(-1);
	            	 System.out.println("���ѳɹ��˳�ϵͳ����ӭ���ٴ�ʹ�ã�");
	             }
	             break;
			default:
				break;
			}
		} while (choose!=7);
	}
	//����ѧ����Ϣ
	public static void myAdd() {
		String continute;
		do {
			s = new Scanner(System.in);
			String no, name;
			float score;
			int className;
			System.out.println("====����ѧ��====");
			System.out.println("ѧ��(���Ȳ�����10)��");
			no = s.next();
			System.out.println("�༶(����):");
			className = s.nextInt();
			System.out.println("������");
			name = s.next();
			System.out.println("�ɼ���");
			score = s.nextFloat();    
			//����StuScoreOperation
			StuScoreOperation.add(new StuScore(no, name, score, className));
			System.out.println("�Ƿ�������(y/n)��");
			s = new Scanner(System.in);
			continute = s.next();
		} while (continute.equals("y"));
	}
	//�޸�ѧ����Ϣ
	public static void myUpdate(){
		s = new Scanner(System.in);
		String no;
		System.out.println("====�޸�ѧ��====");
		System.out.println("������Ҫ�޸ĵ�ѧ��ѧ�ţ�");
		no = s.next();
		StuScoreOperation.QueryByNo(no);

		System.out.println("�������µ�ѧ����Ϣ��");
		s = new Scanner(System.in);
		String name;
		float score;
		int className;
		System.out.println("ѧ���༶��");
		className = s.nextInt();
		System.out.println("ѧ��������");
		name = s.next();
		System.out.println("ѧ���ɼ���");
		score = s.nextFloat();		
		StuScoreOperation.update(new StuScore(no, name, score, className));
	}  
	//ɾ��ѧ����Ϣ
	public static void myDel(){
		s = new Scanner(System.in);
		String no;
		System.out.println("====ɾ��ѧ��====");
		System.out.println("������Ҫɾ����ѧ��ѧ�ţ�");
		no = s.next();   
		StuScoreOperation.QueryByNo(no);
    
		System.out.println("�Ƿ����ɾ��(y/n)��");
		s = new Scanner(System.in);
		String x = s.next();
		if (x.equals("y")) {
			StuScoreOperation.delete(no);
		}
	}	
	//��������ѯѧ����Ϣ
	public static void myListByName(){
		s = new Scanner(System.in);
		System.out.println("====��ѯѧ��====");
		System.out.println("������Ҫ�鿴��ѧ��������");
		StuScoreOperation.QueryByName(s.next());	
	}	
	//��ѧ�Ų�ѯѧ����Ϣ
	public static void myListByNo(){
		s = new Scanner(System.in);
		System.out.println("====��ѯѧ��====");
		System.out.println("������Ҫ�鿴��ѧ��ѧ�ţ�");
		StuScoreOperation.QueryByNo(s.next());	
	}
	//����
	public static void mySort() {
		System.out.println("���ɼ�������ʾ");
		System.out.println("ѧ��\t\t�༶\t����\t�ɼ�");
		List<StuScore> list = StuScoreOperation.showBySortScore();
		for (StuScore stuList:list) {
			System.out.println(stuList.getNo()+"\t"+stuList.getClassName()+"\t"+stuList.getName()+"\t"+stuList.getScore());
		}
	}
	//ͳ��
	public static void myStatistic() {
		System.out.println("ͳ��(�ְ༶ͳ��ѧ������,��߷�,��ͷ�,ƽ��ֵ)");
		List<Map<String,Object>> list = StuScoreOperation.statistics();
		System.out.println(list);
		System.out.println("count\tmax_score\tmin_score\tavg_score");
		for (Map<String,Object> m: list) {
			System.out.println(m.get("count")+"\t"+m.get("max_score")+"\t\t"+m.get("min_score")+"\t\t"+m.get("avg_score"));
		}
	}	
}
