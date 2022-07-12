package com.hhtc.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hhtc.dao.AdminDao;
import com.hhtc.po.Page;
import com.hhtc.po.Student;
import com.hhtc.po.Teacher;
@Component
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	//学生
	//分页
	public List<Student> liststudent(Page page){
		return this.adminDao.liststudent(page);
	}
	public void addStudent(Student student) {
		this.adminDao.addStudent(student);
	}
	public Student selectone(String id) {
		return adminDao.selectone(id);
	};
	public List<Student> stumanage() {
		return this.adminDao.stumanage();
	}
	public void delstudnet(String id) {
		this.adminDao.delstudnet(id);
	}
	public void updatestu(Student student) {
		this.adminDao.updatestu(student);
	};
	public List<Student> selectbyname(String stuname){
		return this.adminDao.selectbyname(stuname);
	}
	
	//老师
	public void addteacher(Teacher teacher) {
		this.adminDao.addteacher(teacher);
	};
	public Teacher selectonetea(String id) {
		return this.adminDao.selectonetea(id);
	}
	public List<Teacher> teamanage(){
		return this.adminDao.teamanage();
	}
	public void delteacher(String id){
		this.adminDao.delteacher(id);
	}
	public void updatetea(Teacher teacher) {
		this.adminDao.updatetea(teacher);
	};
	public List<Teacher> selectbynametea(String teaname){
		return this.adminDao.selectbynametea(teaname);
	}
}