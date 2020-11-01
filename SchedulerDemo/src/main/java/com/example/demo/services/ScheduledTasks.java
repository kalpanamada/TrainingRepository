package com.example.demo.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.stereotype.Service;

@Service
public class ScheduledTasks {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"MM/dd/yyyy HH:mm:ss");
	
	
  // @Scheduled(cron = "*/5 * * * * ?")
	 @Scheduled(cron = "${cron.expression.key}") 
	public void performTaskUsingCron() {

		System.out.println("Regular task performed using Cron at "
				+ dateFormat.format(new Date()));

	}
}
