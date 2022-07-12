package com.hhtc.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hhtc.dao.LoginDao;
import com.hhtc.po.Admin;
import com.hhtc.po.Student;
import com.hhtc.po.Teacher;
@Component
public class LoginService {
	@Autowired
	private LoginDao loginDao;
	public Admin findAdminById(Admin admin) {
		return this.loginDao.findAdminByUsername(admin);
	}
	public Teacher findTeachByUsername(Teacher teacher) {
		return this.loginDao.findTeachByUsername(teacher);
	}
	public Student findStuTeachByUsername(Student student) {
		return this.loginDao.findStuByUsername(student);
	}
}
