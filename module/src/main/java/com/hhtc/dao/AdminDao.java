package com.hhtc.dao;
import java.util.List;

import com.hhtc.po.Page;
import com.hhtc.po.Student;
import com.hhtc.po.Teacher;
public interface AdminDao {
	//学生
	public void addStudent(Student student);
	public Student selectone(String id);
	public List<Student> stumanage();
	public void delstudnet(String id);
	public void updatestu(Student student);
	public List<Student> selectbyname(String stuname);
	public List<Student> liststudent(Page page);
	//老师
	public void addteacher(Teacher teacher);
	public Teacher selectonetea(String id);
	public List<Teacher> teamanage();
	public void delteacher(String id);
	public void updatetea(Teacher teacher);
	public List<Teacher> selectbynametea(String teaname);
}
