package com.lishun.config;

import com.lishun.annotation.ReadDataSource;
import com.lishun.annotation.WriteDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author lishun
 * @Description: TODO
 * @date 2018/2/9
 */
//@Component
//@Aspect
public class ServiceAspect implements PriorityOrdered {
	@Pointcut("execution(public * com.lishun.service.*.*(..))")
	public void dataSource(){};

	@Before("dataSource()")
	public void before(JoinPoint joinPoint){
		Class<?> className = joinPoint.getTarget().getClass();//获得当前访问的class
		String methodName = joinPoint.getSignature().getName();//获得访问的方法名
		Class[] argClass = ((MethodSignature)joinPoint.getSignature()).getParameterTypes();//得到方法的参数的类型
		String dataSource = DynamicDataSource.DEFAULT_DS;
		try {
			Method method = className.getMethod(methodName, argClass);// 得到访问的方法对象
			if (method.isAnnotationPresent(ReadDataSource.class)) {
				ReadDataSource annotation = method.getAnnotation(ReadDataSource.class);
				dataSource = annotation.vlaue();
				int i = new Random().nextInt(2) + 1;    /* 简单的负载均衡 */

				dataSource = dataSource + "_" + i;
			}else if (method.isAnnotationPresent(WriteDataSource.class)){
				WriteDataSource annotation = method.getAnnotation(WriteDataSource.class);
				dataSource = annotation.value();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DynamicDataSource.setDB(dataSource);// 切换数据源
	}

	/* 基于方法名
	@Before("execution(public * com.lishun.service.*.find*(..)) || execution(public * com.lishun.service.*.query*(..))")
	public void read(JoinPoint joinPoint){
		DynamicDataSource.setDB("read_ds");// 切换数据源
	}
	@Before("execution(public * com.lishun.service.*.insert*(..)) || execution(public * com.lishun.service.*.add*(..))")
	public void write(JoinPoint joinPoint){
		DynamicDataSource.setDB("write_ds");// 切换数据源
	}
	*/

	@After("dataSource()")
	public void after(JoinPoint joinPoint){
		DynamicDataSource.clearDB();// 切换数据源
	}

	@AfterThrowing("dataSource()")
	public void AfterThrowing(){
		System.out.println("AfterThrowing---------------" );
	}

	@Override
	public int getOrder() {
		return 1;//数值越小该切面先被执行,先选择数据源（防止事务aop使用数据源出现空异常)
	}
}
