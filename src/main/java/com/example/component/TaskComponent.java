package com.example.component;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("tasComponent")
public class TaskComponent {

	private static Log LOG = LogFactory.getLog(TaskComponent.class);
	
	@Scheduled(fixedDelay = 5000)
	public void toTask(){
		LOG.info("TIME IS: " + new Date());
	}
	
}
