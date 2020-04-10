package io.hikari.labs.gof23.structural.proxy;

/**
 * Static Proxy Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-14
 */
public class StaticProxy {

    interface ICache {
        void doCache();
    }
    static class MemoryCache implements ICache {
        @Override
        public void doCache() {
            System.err.println("Store Cache In Memory");
        }
    }
    static class MemoryCacheProxy implements ICache {
        private MemoryCache memoryCache = new MemoryCache();
        @Override
        public void doCache() {
            System.err.println("Do Something Before Store Cache.");
            memoryCache.doCache();
            System.err.println("Do Something After Store Cache.");
        }
    }

    public static void main(String[] args) {
        ICache cache = new MemoryCacheProxy();
        cache.doCache();
    }


}
