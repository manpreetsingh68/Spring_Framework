package org.framework.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements Shape, ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean {

	private Point pointA;
	private Point pointB;
	private Point pointC;
	private ApplicationContext context = null;
	private String beanName;

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	
	public void getTraingleContext() {
		System.out.println(context.getBean(beanName));
	}

	public void draw() {
		System.out.println("Drawing triangle");
		System.out.println("Point A (" + getPointA().getX() + " , " + getPointA().getY() + " )");
		System.out.println("Point B (" + getPointB().getX() + " , " + getPointB().getY() + " )");
		System.out.println("Point C (" + getPointC().getX() + " , " + getPointC().getY() + " )");
	}

	@Override
	public String toString() {
		return "Triangle [beanName=" + beanName + "]";
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializationBean init method for triangle bean");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposibleBean destroy method for triangle bean");		
	}
	
	public void initMethod() {
		System.out.println("My init method for triangle bean");
	}
	
	public void cleanUp() {
		System.out.println("My destroy method for triangle bean");
	}
}
