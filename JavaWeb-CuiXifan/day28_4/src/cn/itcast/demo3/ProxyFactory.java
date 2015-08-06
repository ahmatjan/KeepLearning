package cn.itcast.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂
 * @author chenzhongzheng
 *
 */
public class ProxyFactory {
	private Object targetObject;
	private BeforeAdvice beforeAdvice;
	private AfterAdvice afterAdvice;

	public Object getTargetObject() {
		return targetObject;
	}
	public void setTargetObject(Object targetObject) {
		this.targetObject = targetObject;
	}
	public BeforeAdvice getBeforeAdvice() {
		return beforeAdvice;
	}
	public void setBeforeAdvice(BeforeAdvice beforeAdvice) {
		this.beforeAdvice = beforeAdvice;
	}
	public AfterAdvice getAfterAdvice() {
		return afterAdvice;
	}
	public void setAfterAdvice(AfterAdvice afterAdvice) {
		this.afterAdvice = afterAdvice;
	}

	public Object createProxy() {
		// 设置三大参数
		ClassLoader loader = this.getClass().getClassLoader();
		Class[] interfaces = targetObject.getClass().getInterfaces();
		InvocationHandler h = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// 调用前置增强
				if (beforeAdvice != null)
					beforeAdvice.before();
				// 调用本来想要调用方法
				Object result = method.invoke(targetObject, args);
				// 调用后置增强
				if (afterAdvice != null)
					afterAdvice.after();
				return result;
			}
		};

		Object proxyObject = Proxy.newProxyInstance(loader, interfaces, h);
		return proxyObject;
	}
}
