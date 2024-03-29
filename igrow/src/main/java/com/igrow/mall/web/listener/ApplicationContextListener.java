package com.igrow.mall.web.listener;

import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.igrow.mall.service.common.intf.SystemRepairService;
import com.igrow.mall.web.initializer.PurviewInitalizer;

public class ApplicationContextListener extends ContextLoaderListener {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationContextListener.class);
	
	private ContextLoader contextLoader;
	private TimeZone systemTimezone;
	private static ApplicationContext ctx = null;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		logger.info("-----------------[before] {};{}------------------------",new Object[]{TimeZone.getDefault(),new Date()});
		this.systemTimezone = ((TimeZone)TimeZone.getDefault().clone());
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+0800"));
		this.contextLoader = createContextLoader();
		this.contextLoader.initWebApplicationContext(event.getServletContext());
		logger.info("系统启动初始化数据");
		ctx = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		//PurviewInitalizer purviewInitalizer = (PurviewInitalizer) ctx.getBean("purviewInitalizer");
		//purviewInitalizer.execute();
		logger.info("初始化数据完成");
		logger.info("系统启动修复数据库");
		//SystemRepairService systemRepairService = (SystemRepairService) ctx.getBean("systemRepairServiceImpl");
		//systemRepairService.repair();
		//systemRepairService.deleteAndRepair();
		logger.info("修复数据库完成");
		//自定义宏的初始化
	/*	MacrosInitalizer macrosInitalizer=SpringBeanManager.getBean(MacrosInitalizer.class);
		macrosInitalizer.execute();*/
		logger.info("-----------------[after] {};{}------------------------",new Object[]{TimeZone.getDefault(),new Date()});
	}
	
	 public void contextDestroyed(ServletContextEvent event) {
		 TimeZone.setDefault(this.systemTimezone);
	  	if (this.contextLoader != null)
		  this.contextLoader.closeWebApplicationContext(event.getServletContext());
	 }
	 
	 
	 protected ContextLoader createContextLoader() {
		 return new ContextLoader();
	  }
	  
	 public ContextLoader getContextLoader() {
		 return this.contextLoader;
	 }
}
