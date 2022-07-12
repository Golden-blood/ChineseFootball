package com.hhtc.dao;
import com.hhtc.po.Admin;
import com.hhtc.po.Student;
import com.hhtc.po.Teacher;
public interface LoginDao {
	//根据用户名查找管理员
	public Admin findAdminByUsername(Admin admin);
	//根据用户名查找老师
	public Teacher findTeachByUsername(Teacher teacher);
	//根据用户名查找学生
	public Student findStuByUsername(Student student);
}
