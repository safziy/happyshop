package com.safziy.happyshop.advice;

public class ActionAdvice {
	
	public void before() {
		System.out.println("ActionAdvice before");
	}
	
	/**
	public void before(Method method, Object[] args, Object target) {
		System.out.println("Before ==== " + target + " " + method.getName() +" "+ args);
	}

	public void after(Object returnValue, Method method, Object[] args, Object target) {
		System.out.println("MyAdvice after()");
	}

	
	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
            Object arg3) {
		System.out.println("MyAdvice afterReturning()");
	}

	public void afterThrowing() {
		System.out.println("MyAdvice afterThrowing()");
	}

	public void around() {
		System.out.println("MyAdvice around()");
	}
	*/
}
