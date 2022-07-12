package com.hhtc.controller;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hhtc.po.Admin;
import com.hhtc.po.Student;
import com.hhtc.po.Teacher;
import com.hhtc.service.LoginService;
@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;	
	@RequestMapping("/login")
	public ModelAndView findCustomerById(String username,String password,String people,Model model,HttpSession session) {
		if("student".equals(people)) {
			Student student=new Student();
			student.setUsername(username);
			student.setPassword(password);
			Student student2=loginService.findStuTeachByUsername(student);
			if(student2!=null) {
				session.setAttribute("student", student2);
				ModelAndView mav = new ModelAndView("/student/indexs");
				return mav;
			}else {
				ModelAndView mav = new ModelAndView("error");
				return mav;
			}
		}else if("teacher".equals(people)){
			Teacher teacher=new Teacher();
			teacher.setUsername(username);
			teacher.setPassword(password);
			Teacher teacher2=loginService.findTeachByUsername(teacher);
			if(teacher2!=null) {
				session.setAttribute("teacher", teacher2);
				ModelAndView mav = new ModelAndView("/teacher/indext");
				return mav;
			}else {
				ModelAndView mav = new ModelAndView("error");
				return mav;
			}
		}else if("manage".equals(people)){
			Admin admin =new Admin();
			admin.setUsername(username);
			admin.setPassword(password);
			if(loginService.findAdminById(admin)!=null) {
				ModelAndView mav = new ModelAndView("/admin/index");
				return mav;
			}else {
				ModelAndView mav = new ModelAndView("error");
				return mav;
			}
		}
		ModelAndView mav = new ModelAndView("error");
		return mav;
	}
	@RequestMapping("/out")
	public ModelAndView out(HttpServletResponse response,HttpSession session,Model model) {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
}
