package com.safziy.happyshop.action.struts2.test;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;

import org.apache.struts2.StrutsTestCase;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.junit.Test;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;
import com.safziy.happyshop.action.struts2.AdminLoginAction;

public class AdminLoginActionTest extends StrutsTestCase {
	
	@Test
	public void testGetActionMapping() {
		ActionMapping mapping = getActionMapping("/adminLogin.action");
		assertNotNull(mapping);
		assertEquals("/", mapping.getNamespace());
		assertEquals("adminLogin", mapping.getName());
	}

	@Test
	public void testGetActionProxy() throws Exception {
		// set parameters before calling getActionProxy
		request.setParameter("username", "safziy");

		ActionProxy proxy = getActionProxy("/adminLogin.action");
		assertNotNull(proxy);

		AdminLoginAction action = (AdminLoginAction) proxy.getAction();
		assertNotNull(action);

		String result = proxy.execute();
		assertEquals(Action.SUCCESS, result);
		assertEquals("safziy", action.getUsername());
	}

	@Test
	public void testExecuteAction() throws ServletException, UnsupportedEncodingException {
		String output = executeAction("/adminLogin.action");
		assertEquals("Hello", output);
	}

	@Test
	public void testGetValueFromStack() throws ServletException, UnsupportedEncodingException {
		request.setParameter("username", "safziy");
		executeAction("/adminLogin.action");
		String username = (String) findValueAfterExecute("username");
		assertEquals("safziy", username);
	}
}
