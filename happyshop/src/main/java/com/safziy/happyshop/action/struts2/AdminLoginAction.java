package com.safziy.happyshop.action.struts2;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.safziy.happyshop.entity.AdminUser;
import com.safziy.happyshop.services.AdminUserService;

public class AdminLoginAction extends BaseAction {

	private static final long serialVersionUID = 869316979129607570L;

	private String username;
	private String password;

	private Map<String, Object> powerMap;

	private AdminUserService adminUserService = new AdminUserService();

	public String login() {
		System.out.println("AdminLoginAction login()");
		AdminUser loginAdminUser = getSessionUserInfo();
		HttpServletRequest request = getRequest();
		if (loginAdminUser != null) {
			request.setAttribute("loginAdminUser", loginAdminUser);
			// request.setAttribute("ADMIN_LOGIN_USER_SUM",
			// Integer.valueOf(Static.ADMIN_LOGIN_USER_SUM));
			// this.powerMap =
			// this.sysUserPowerService.getPowerMap(loginUser.getId());
			// this.maplist =
			// this.sysUserPowerService.getAllPower(loginUser.getId());
			
			loginInit();
			
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
				// this.powerMap =
				// this.sysUserPowerService.getPowerMap(loginUser.getId());
				// this.maplist =
				// this.sysUserPowerService.getAllPower(loginUser.getId());
				// request.getSession().setAttribute("userpowermap",
				// this.maplist);

				loginInit();
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
	
	public void loginInit(){
		powerMap = new HashMap<String, Object>();
		powerMap.put("customer", "customer");
		powerMap.put("good", "good");
		powerMap.put("order", "order");
		powerMap.put("warehouse", "warehouse");
		powerMap.put("market", "market");
		powerMap.put("information", "information");
		powerMap.put("mall", "mall");
		powerMap.put("baseinfo", "baseinfo");
		powerMap.put("formcenter", "formcenter");
		powerMap.put("dataflow", "dataflow");
		powerMap.put("system", "system");
		powerMap.put("desktop", "desktop");
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

	public Map<String, Object> getPowerMap() {
		return powerMap;
	}

	public void setPowerMap(Map<String, Object> powerMap) {
		this.powerMap = powerMap;
	}

}
