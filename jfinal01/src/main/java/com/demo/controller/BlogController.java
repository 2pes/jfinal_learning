package com.demo.controller;

import com.demo.model.Blog;
import com.jfinal.core.Controller;

public class BlogController extends Controller {
	
	public void save() {
		// 页面的modelName正好是Blog类名的首字母小写
		Blog blog = getModel(Blog.class);
		// 如果表单域的名称为 "otherName.title"可加上一个参数来获取
		blog = getModel(Blog.class, "otherName");
	}
	public void add(){
		renderTemplate("add.html");
	}
	public void doAdd(){
		System.out.println(getModel(Blog.class,"b"));
		renderText("提交成功");
	}
	
	public void proxy(){
		renderJsp("proxy.jsp");
	}
}
