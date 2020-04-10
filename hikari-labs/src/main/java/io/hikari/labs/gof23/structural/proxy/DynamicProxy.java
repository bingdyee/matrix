package io.hikari.labs.gof23.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Dynamic Proxy Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-14
 */
public class DynamicProxy {

    interface ICache {
        void doCache();
    }
    static class MemoryCache implements ICache {
        @Override
        public void doCache() {
            System.err.println("Store Cache In Memory");
        }
    }
    static class MemoryCacheProxy implements InvocationHandler {
        private Object target;
        public MemoryCacheProxy(Object target) {
            this.target = target;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.err.println("Do Something Before Store Cache.");
            Object result = method.invoke(target, args);
            System.err.println("Do Something After Store Cache.");
            return result;
        }
    }
    static class CacheProxyFactory {
        public static ICache getProxy(MemoryCache memoryCache) {
            MemoryCacheProxy proxy = new MemoryCacheProxy(memoryCache);
            return (ICache)Proxy.newProxyInstance(memoryCache.getClass().getClassLoader(),
                    memoryCache.getClass().getInterfaces(), proxy);
        }
    }

    public static void main(String[] args) {
        MemoryCache memoryCache = new MemoryCache();
        ICache cache = CacheProxyFactory.getProxy(memoryCache);
        cache.doCache();
    }

}
