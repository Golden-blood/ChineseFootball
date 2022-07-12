package com.hhtc.controller;
import java.util.List;
import javax.servlet.http.HttpSession;
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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Controller
public class AdminController {
	@Autowired
		private AdminService adminService;
	@RequestMapping("/welcome")
	public ModelAndView welcome(Model model) {
		ModelAndView mav = new ModelAndView("admin/welcome");
		return mav;
	}
	//学生
		//学生数据分页
		@RequestMapping(value = "/liststudent",method = {RequestMethod.POST, RequestMethod.GET},produces ="application/json;charset=UTF-8")
		@ResponseBody
		public String liststudent(Page page) {
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
		    	jsonobj3.put("username",student.getUsername());
		    	jsonobj3.put("password",student.getPassword());
		    	jsonobj3.put("stuclass",student.getStuclass());
		    	jsonobj3.put("stuname",student.getStuname());
		    	jsonobj3.put("stuno",student.getStuno());
		    	jsonobj2.add(jsonobj3);
		    }
		    jsonobj.put("data", jsonobj2);		
			return jsonobj.toString();
		}
		@RequestMapping("/addstudent")
		public ModelAndView addstu(Student student,Model model) {
			adminService.addStudent(student);
			ModelAndView mav = new ModelAndView("admin/stumanage");
			return mav;
		}
		@RequestMapping("/delstu")
		public ModelAndView delstu(String id,Model model) {
			adminService.delstudnet(id);
			ModelAndView mav = new ModelAndView("admin/stumanage");
			return mav;
		}
		@RequestMapping("/updatestu")
		public ModelAndView updatestu(String id,Student student,Model model) {
			student.setId(Integer.parseInt(id));
			adminService.updatestu(student);
			ModelAndView mav = new ModelAndView("admin/stumanage");
			return mav;
		}
		@RequestMapping(value = "/mohuname",method = {RequestMethod.POST, RequestMethod.GET},produces ="application/json;charset=UTF-8")
		@ResponseBody
		public String mohuname(HttpSession session) {
			@SuppressWarnings("unchecked")
			List<Student> list=(List<Student>) session.getAttribute("list");
			JSONObject jsonobj=new JSONObject();
			jsonobj.put("code", 0);
			jsonobj.put("msg", "成功");
			jsonobj.put("count",list.size());
			JSONArray jsonobj2=new JSONArray();
			JSONObject jsonobj3=new JSONObject();
		    for(Student student:list) {
		    	jsonobj3.put("id",student.getId());
		    	jsonobj3.put("username",student.getUsername());
		    	jsonobj3.put("password",student.getPassword());
		    	jsonobj3.put("stuclass",student.getStuclass());
		    	jsonobj3.put("stuname",student.getStuname());
		    	jsonobj3.put("stuno",student.getStuno());
		    	jsonobj2.add(jsonobj3);
		    }
		    jsonobj.put("data", jsonobj2);		
			return jsonobj.toString();
		}
	//老师
		@RequestMapping("/addtea")
		public ModelAndView addteacher(Teacher teacher,Model model) {
			adminService.addteacher(teacher);
			ModelAndView mav = new ModelAndView("admin/teamanage");
			return mav;
		}
		@RequestMapping(value = "/teamanage",method = {RequestMethod.POST, RequestMethod.GET},produces ="application/json;charset=UTF-8")
		@ResponseBody
		public String teamanage(Model model) {
			List<Teacher> list=adminService.teamanage();
			JSONObject jsonobj=new JSONObject();
			jsonobj.put("code", 0);
			jsonobj.put("msg", "成功");
			jsonobj.put("count",list.size());
			JSONArray jsonobj2=new JSONArray();
			JSONObject jsonobj3=new JSONObject();
		    for(Teacher teacher:list) {
		    	jsonobj3.put("id",teacher.getId());
		    	jsonobj3.put("username",teacher.getUsername());
		    	jsonobj3.put("password",teacher.getPassword());
		    	jsonobj3.put("teaname",teacher.getTeaname());
		    	jsonobj2.add(jsonobj3);
		    }
		    jsonobj.put("data", jsonobj2);		
			return jsonobj.toString();
		}
		@RequestMapping("/deltea")
		public ModelAndView deltea(String id,Model model) {
			adminService.delteacher(id);
			ModelAndView mav = new ModelAndView("admin/teamanage");
			return mav;
		}
		@RequestMapping("/updatetea")
		public ModelAndView updatetea(String id,Teacher teacher,Model model) {
			teacher.setId(Integer.parseInt(id));
			adminService.updatetea(teacher);
			ModelAndView mav = new ModelAndView("admin/teamanage");
			return mav;
		}
		@RequestMapping(value = "/mohunametea",method = {RequestMethod.POST, RequestMethod.GET},produces ="application/json;charset=UTF-8")
		@ResponseBody
		public String mohunametea(HttpSession session) {
			@SuppressWarnings("unchecked")
			List<Teacher> list=(List<Teacher>) session.getAttribute("tealist");
			JSONObject jsonobj=new JSONObject();
			jsonobj.put("code", 0);
			jsonobj.put("msg", "成功");
			jsonobj.put("count",list.size());
			JSONArray jsonobj2=new JSONArray();
			JSONObject jsonobj3=new JSONObject();
		    for(Teacher teacher:list) {
		    	jsonobj3.put("id",teacher.getId());
		    	jsonobj3.put("username",teacher.getUsername());
		    	jsonobj3.put("password",teacher.getPassword());
		    	jsonobj3.put("teaname",teacher.getTeaname());
		    	jsonobj2.add(jsonobj3);
		    }
		    jsonobj.put("data", jsonobj2);		
			return jsonobj.toString();
		}
}
