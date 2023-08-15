package org.example.task1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class MethodInterception {
    public MainPage createPage(Class clazz) {
        Class[] classes = new Class[]{clazz};
        ClassLoader loader = clazz.getClassLoader();

        return (MainPage) Proxy.newProxyInstance(
                loader,
                classes,
                (proxy, method, args) -> {
                    if (method.isAnnotationPresent(Selector.class)) {
                        var annotation = method.getAnnotation(Selector.class);
                        return annotation.xpath();
                    } else throw new Exception();
                }
        );
    }
}
