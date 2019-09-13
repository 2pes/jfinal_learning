package com.demo.controller;

import java.util.List;

import com.demo.interceptor.AInterceptor;
import com.demo.interceptor.BInterceptor;
import com.demo.interceptor.MethodInterceptor;
import com.demo.model.Blog;
import com.demo.service.ServiceImpl;
import com.jfinal.aop.Before;
import com.jfinal.aop.Duang;
import com.jfinal.core.Controller;
import com.jfinal.kit.JMap;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.SqlPara;

public class BlogController extends Controller {

	public void save() {
		// 页面的modelName正好是Blog类名的首字母小写
		Blog blog = getModel(Blog.class);
		// 如果表单域的名称为 "otherName.title"可加上一个参数来获取
		blog = getModel(Blog.class, "otherName");
	}

	public void add() {
		renderTemplate("add.html");
	}

	public void doAdd() {
		System.out.println(getModel(Blog.class, "b"));
		Blog blog = getModel(Blog.class);

		// 用Record代替Model
		// Record record = new Record();
		// record.set("name", "blog_name");
		// record.set("desc", "blog_desc");
		// Db.save("t_blog",record);

		blog.save();
		renderText("提交成功");
	}

	public void sqlManagerFindAll() {
		String sql = Blog.dao.getSql("blogList");
		List<Blog> blogs = Blog.dao.find(sql);

		renderJson(blogs);
	}

	public void sqlManagerGetById() {
		String sql = Blog.dao.getSql("blogGetById");
		Blog blog = Blog.dao.findFirst(sql, 3);

		renderJson(blog);
	}

	public void sqlManagerGetBetween() {
		String sql = Blog.dao.getSql("blogBetween");
		List<Blog> blogs = Blog.dao.find(sql, 5, 7);

		renderJson(blogs);
	}

	public void sqlManagerGetBetweenNew() {
		JMap cond = JMap.create("a", 5).set("b", 7);

		SqlPara para = Blog.dao.getSqlPara("blog.blogBetweenNew", cond);

		List<Blog> blogs = Blog.dao.find(para);

		renderJson(blogs);
	}

	public void queryAllBlog() {
		// String sql = "select * from t_blog order by id
		// desc";//不要在controller中写sql，此处仅为演示
		// List<Blog> blogs = Blog.dao.find(sql);
		// Blog blog1 = Blog.dao.findFirst(sql);

		Blog blog = Blog.dao.findById("3");
		System.out.println(blog.getStr("name"));
		System.out.println(blog.getStr("desc"));
		// 分页查询数据记录
		Page<Blog> pageBlog = Blog.dao.paginate(1, 1, "select * ", "from blog order by id desc");
		renderJson(pageBlog);
	}

	public void update() {
		Blog blog = new Blog();
		blog.set("id", 3);
		blog.set("title", "name_3");
		blog.set("content", "desc_3");
		blog.update();
		renderText("更新成功");
	}

	public void delete() {
		Blog.dao.deleteById(4);
	}

	public void relation() {
		String sql = "select b.*, u.user_name from blog b inner join user u on b.user_id=u.id where b.id=?";
		Blog blog = Blog.dao.findFirst(sql, 123);
		String name = blog.getStr("user_name");
		renderJson(name);
	}

	/**
	 * 测试 Method Interceptor 的用法
	 */
	@Before(MethodInterceptor.class)
	public void testMethod() {
		renderTemplate("index.html");
	}

	public void testInjectMethod() {
		ServiceImpl service = Duang.duang(ServiceImpl.class);
		// ServiceImpl service = Duang.duang(ServiceImpl.class,
		// InjectInterceptor.class);
		service.testInject();
		renderTemplate("index.html");
	}

	@Before({ AInterceptor.class, BInterceptor.class })
	public void testInterceptorStack() {
		renderTemplate("index.html");
	}

	public void testTemplate() {
		renderTemplate("template-test.html");
	}
	/*
	 * public void proxy(){ renderJsp("proxy.jsp"); }
	 */

}
