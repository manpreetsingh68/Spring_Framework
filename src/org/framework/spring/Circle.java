package org.framework.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape, ApplicationEventPublisherAware {
	
	private Point centre;
	private ApplicationEventPublisher publisher;
	@Autowired
	private MessageSource messageSource;

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public void draw() {
		System.out.println(messageSource.getMessage("drawing.circle", null, "Default circle message", null));
		System.out.println(messageSource.getMessage("drawing.point", new Object[] {centre.getX(), centre.getY()}, "Default circle message", null));
		//System.out.println("Centre is ( " + centre.getX() + ", " + centre.getY() + " )");
		System.out.println(messageSource.getMessage("greeting", null, "Default message", null));
		DrawEvent event = new DrawEvent(this);
		publisher.publishEvent(event);
	}
	
	public Point getCentre() {
		return centre;
	}
	
	//@Autowired
	//@Qualifier("circlePoint")
	
	@Resource(name="pointC")
	public void setCentre(Point centre) {
		this.centre = centre;
	}
	
	@PostConstruct
	public void initCircle() {
		System.out.println("Init of cirlce");
	}
	
	@PreDestroy
	public void destroyCircle() {
		System.out.println("Destroy of circle");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}
	
}
