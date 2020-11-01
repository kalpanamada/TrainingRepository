package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.ScheduledTasks;

@RestController
@RequestMapping("/test")
public class TestController {
	
	private static final String SCHEDULED_TASKS = "scheduledTasks";
	@Autowired
	private ScheduledAnnotationBeanPostProcessor postProcessor;

	@Autowired
	private ScheduledTasks scheduledTasks;
	
	@GetMapping(value = "/stopScheduler")
	public String stopSchedule(){
	    postProcessor.postProcessBeforeDestruction(scheduledTasks, SCHEDULED_TASKS);
	    return "OK";
	}


}
