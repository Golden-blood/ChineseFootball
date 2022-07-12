package com.hhtc.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hhtc.po.Page;
import com.hhtc.po.Student;
import com.hhtc.po.Teacher;
import com.hhtc.service.AdminService;
import com.hhtc.service.GeneraService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Controller
public class TeachController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private GeneraService generaService;
	@RequestMapping("/hrefaddscore")
	public ModelAndView hrefaddscore(Model model) {
		ModelAndView mav = new ModelAndView("teacher/addscore");
		return mav;
	}
	@RequestMapping("/hrefupdatepw")
	public ModelAndView hrefupdatepw(Model model) {
		ModelAndView mav = new ModelAndView("teacher/updatepw");
		return mav;
	}
	@RequestMapping(value = "/stuscore",method = {RequestMethod.POST, RequestMethod.GET},produces ="application/json;charset=UTF-8")
	@ResponseBody
	public String stuscoree(Page page,Model model) {
		List<Student> list=adminService.stumanage();
		page.caculatestart();
		List<Student> list2=adminService.liststudent(page);
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("code", 0);
		jsonobj.put("msg", "成功");
		jsonobj.put("count",list.size());
		JSONArray jsonobj2=new JSONArray();
		JSONObject jsonobj3=new JSONObject();
	    for(Student student:list2) {
	    	jsonobj3.put("id",student.getId());
	    	jsonobj3.put("stuno", student.getStuno());
	    	jsonobj3.put("stuname",student.getStuname());
	    	jsonobj3.put("stuclass",student.getStuclass());
	    	jsonobj3.put("score",student.getScore());    	
	    	jsonobj2.add(jsonobj3);
	    }
	    jsonobj.put("data", jsonobj2);		
		return jsonobj.toString();
	}
	@RequestMapping("/updatepw")
	public ModelAndView updatepw(Teacher teacher,Model model) {
		this.generaService.updatepw(teacher);
		ModelAndView mav = new ModelAndView("success");
		return mav;
	}
	@RequestMapping("/updatescore")
	public ModelAndView updatescore(String id,String score,Model model) {
		Student student=new Student();
		student.setId(Integer.parseInt(id));
		student.setScore(score);
		this.generaService.updatescore(student);
		ModelAndView mav = new ModelAndView("teacher/addscore");
		return mav;
	}
}
