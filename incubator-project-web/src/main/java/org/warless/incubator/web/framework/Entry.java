package org.warless.incubator.web.framework;

import java.lang.reflect.Method;

/**
 * codespot
 *
 * @author : Noa Swartz
 * @date: 2019-05-24
 * @email: fetaxyu@gmail.com
 */
public class Entry {

    private Object service;
    private Method method;

    public Entry(Object k, Method v) {
        this.service = k;
        this.method = v;
    }

    public Object getService() {
        return service;
    }

    public void setService(Object service) {
        this.service = service;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
