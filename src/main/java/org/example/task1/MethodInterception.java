package org.example.task1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class MethodInterception {
    public MainPage createPage(Class clazz) {
        Class[] classes = new Class[]{clazz};
        ClassLoader loader = clazz.getClassLoader();
        InvocationHandler handler = new MyProxy();
        Object proxy = Proxy.newProxyInstance(loader, classes, handler);

        return (MainPage) proxy;

    }

    static class MyProxy implements InvocationHandler {
        public MyProxy() {
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.isAnnotationPresent(Selector.class)) {
                var selectorAnnotation = method.getAnnotation(Selector.class);
                return selectorAnnotation.xpath();
            } else {
                throw new Exception();
            }
        }
    }
}
