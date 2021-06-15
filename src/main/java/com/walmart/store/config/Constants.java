package com.walmart.store.config;

public class Constants {

	public static final String TOPIC_NAME 
	= "#{@environment.getProperty('kafka.topic.driver')}";

	public static final String GROUP_ID 
	= "#{@environment.getProperty('kafka.consumer.driver.group')}";

}
