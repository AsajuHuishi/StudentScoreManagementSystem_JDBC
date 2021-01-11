package com.Huishi.jdbc;
/**
 * 本类功能：建立和student表相同的字段
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| no        | varchar(10) | YES  |     | NULL    |       |
| name      | varchar(20) | YES  |     | NULL    |       |
| score     | float       | YES  |     | NULL    |       |
| className | int(11)     | YES  |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+
 * @author AsajuHuishi
 *
 */
public class StuScore {
	@Override
	public String toString() {
		return "StuScore [no=" + no + ", name=" + name + ", score=" + score + ", className=" + className + "]";
	}
	private String no;
	private String name;
	private float score;
	private int className;
	public StuScore(String no, String name, float score, int className) {
		super();
		this.no = no;
		this.name = name;
		this.score = score;
		this.className = className;
	}
	public StuScore(){ //缺省构造函数
		super();
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public int getClassName() {
		return className;
	}
	public void setClassName(int className) {
		this.className = className;
	}
}
