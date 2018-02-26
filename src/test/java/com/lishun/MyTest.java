package com.lishun;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lishun
 * @Description: TODO
 * @date 2018/2/11
 */
public class MyTest {
	@Test
	public void test(){
		Peason p = (Peason)Proxy.newProxyInstance(Peason.class.getClassLoader(),Lishun.class.getInterfaces(),new InvocationHandler(){
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Lishun ls = new Lishun();
				return method.invoke(ls, args);
			}
		});

		p.listen("hahahha");
	}
}
interface Peason{
	String look(String video);
	String listen(String music);
}
class Lishun implements Peason{

	@Override
	public String look(String video) {
		System.out.println("----" + video);
		return video;
	}

	@Override
	public String listen(String music) {
		System.out.println("----" + music);
		return music;
	}
}

