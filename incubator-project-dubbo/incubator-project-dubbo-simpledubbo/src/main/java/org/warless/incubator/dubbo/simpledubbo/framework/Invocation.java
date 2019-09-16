package org.warless.incubator.dubbo.simpledubbo.framework;

import java.io.Serializable;

/**
 * @author : fetaxyu
 * @date : 2019-09-16
 */
public class Invocation implements Serializable {

    private String interfaceName;
    private String methodName;
    private Class[] parmaTypes;
    private Object[] params;

    public Invocation(String interfaceName, String methodName, Class[] parmaTypes, Object[] params) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.parmaTypes = parmaTypes;
        this.params = params;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParmaTypes() {
        return parmaTypes;
    }

    public void setParmaTypes(Class[] parmaTypes) {
        this.parmaTypes = parmaTypes;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
