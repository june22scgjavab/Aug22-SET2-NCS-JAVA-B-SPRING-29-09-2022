package com.infosys.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import com.infosys.exception.CustomerException;

@Component
@Aspect
public class LoggingAspect {

	public static final Log LOGGER = LogFactory.getLog(LoggingAspect.class); 

	@Before("execution(* com.infosys.service.*Impl.*(..))")
	public void before() throws CustomerException {
		LOGGER.info("Before advice called.");
	}

	@After("execution(* com.infosys.service.*Impl.*(..))")
	public void after() throws CustomerException {
		LOGGER.info("After advice called.");
	}

	@AfterReturning("execution(* com.infosys.service.*Impl.*(..))")
	public void afterReturning() throws CustomerException {
		LOGGER.info("After returning advice called.");
	}

	@AfterThrowing(pointcut = "execution(* com.infosys.service.*Impl.*(..))", throwing = "exception")
	public void afterThrowing(CustomerException exception) throws CustomerException {
		LOGGER.error(exception.getMessage(), exception);
	}

}