package com.hhtc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hhtc.po.Student;
import com.hhtc.service.GeneraService;
@Controller
public class StudentController {
	@Autowired
	private GeneraService generaService;
	//学生
	@RequestMapping("/hrefstuinfo")
	public ModelAndView hrefstuinfo(Model model) {
		ModelAndView mav = new ModelAndView("student/stuinfo");
		return mav;
	}
	@RequestMapping("/hrefupdatepws")
	public ModelAndView hrefupdatepws(Model model) {
		ModelAndView mav = new ModelAndView("student/updatepws");
		return mav;
	}
	@RequestMapping("/updatepws")
	public ModelAndView updatepws(Student student,Model model) {
		this.generaService.updatepws(student);
		ModelAndView mav = new ModelAndView("success");
		return mav;
	}
}
