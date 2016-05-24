package com.safziy.happyshop.action.struts2;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.safziy.happyshop.entity.AdminUser;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 5410993784250232443L;
	
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	
	public HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	
	public HttpSession getSession(){
		return getRequest().getSession();
	}
	
	public ServletContext getApplication(){
		return ServletActionContext.getServletContext();
	}

	public AdminUser getSessionUserInfo() {
		return (AdminUser) getRequest().getSession().getAttribute("loginAdminUser");
	}
}
