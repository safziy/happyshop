package com.safziy.happyshop.action.struts2;

import javax.servlet.http.HttpServletRequest;

import com.safziy.happyshop.entity.AdminUser;
import com.safziy.happyshop.services.AdminUserService;

public class AdminLoginAction extends BaseAction {

	private static final long serialVersionUID = 869316979129607570L;
	
	private String username;
	private String password;
	
	private AdminUserService adminUserService;

	public String login() {
		AdminUser loginAdminUser = getSessionUserInfo();
		HttpServletRequest request = getRequest();
		if (loginAdminUser != null) {
			request.setAttribute("loginAdminUser", loginAdminUser);
			// request.setAttribute("ADMIN_LOGIN_USER_SUM", Integer.valueOf(Static.ADMIN_LOGIN_USER_SUM));
			// this.powerMap = this.sysUserPowerService.getPowerMap(loginUser.getId());
			// this.maplist = this.sysUserPowerService.getAllPower(loginUser.getId());
			return SUCCESS;
		}
		if (username == null || password == null) {
			return LOGIN;
		}
		try {
			AdminUser adminUser = adminUserService.getAdminUser(username, password);
			if (adminUser != null) {
				request.setAttribute("loginAdminUser", adminUser);
				request.getSession().setAttribute("loginAdminUser", adminUser);
				//this.powerMap = this.sysUserPowerService.getPowerMap(loginUser.getId());
				//this.maplist = this.sysUserPowerService.getAllPower(loginUser.getId());
				//request.getSession().setAttribute("userpowermap", this.maplist);
				return SUCCESS;
			}
			addFieldError("errorMsg", "账号或密码错误");
			return LOGIN;
		} catch (Exception e) {
			String tips = "系统繁忙,请稍后重试";
			request.setAttribute("error_info", tips);
			return LOGIN;
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
