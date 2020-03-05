package net.sahet.designpatterns.structural.proxy;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProxyDemo {
	public static void main(String[] args) throws IOException {

		System.out.println("\n	Proxy Java build-in classes ");
		/**
		 * java.lang.reflect.Proxy
		 * 
		 * java.rmi.*
		 * 
		 * Spring and Hibernate provide full of proxy objects to handle different
		 * problems
		 * 
		 */
	}
}

//https://docs.oracle.com/javase/8/docs/technotes/guides/reflection/proxy.html
class DebugProxy implements java.lang.reflect.InvocationHandler {

	private Object obj;

	public static Object newInstance(Object obj) {
		return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
				new DebugProxy(obj));
	}

	private DebugProxy(Object obj) {
		this.obj = obj;
	}

	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		Object result;
		try {
			System.out.println("before method " + m.getName());
			result = m.invoke(obj, args);
		} catch (InvocationTargetException e) {
			throw e.getTargetException();
		} catch (Exception e) {
			throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
		} finally {
			System.out.println("after method " + m.getName());
		}
		return result;
	}
}
