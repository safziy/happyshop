package com.safziy.happyshop.action.struts2;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction implements ServletRequestAware {

	public String execute() {
		System.out.println("LoginAction execute()");
		return "success";
	}

	public String logout() {
		System.out.println(ActionContext.getContext().getSession());
		System.out.println("LoginAction logout()");
		return "fail";
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {

	}

}
