package org.example.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.util.Optional;


public class MethodInterception {
    private final Logger logger = LoggerFactory.getLogger(MethodInterception.class);
    public MainPage createPage(Class clazz) {
        logger.info("Invocation of class {}", clazz);

        Class[] classes = new Class[]{clazz};
        ClassLoader loader = clazz.getClassLoader();

        return (MainPage) Proxy.newProxyInstance(
                loader,
                classes,
                (proxy, method, args) -> {
                    if (method.isAnnotationPresent(Selector.class)) {
                        var annotation = method.getAnnotation(Selector.class);
                        return annotation.xpath();
                    } else return Optional.empty();     // I don't think this return-empty-Optional approach is appropriate,
                                                        // but returning null is even more offencive
                }
        );
    }
}
