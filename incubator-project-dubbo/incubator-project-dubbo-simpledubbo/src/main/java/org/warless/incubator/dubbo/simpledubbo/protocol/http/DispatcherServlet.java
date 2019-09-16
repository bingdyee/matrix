package org.warless.incubator.dubbo.simpledubbo.protocol.http;

import org.apache.commons.io.IOUtils;
import org.warless.incubator.dubbo.simpledubbo.framework.Invocation;
import org.warless.incubator.dubbo.simpledubbo.register.InMemoryRegister;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : fetaxyu
 * @date : 2019-09-15
 */
public class DispatcherServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(req.getInputStream());
            Invocation invocation = (Invocation)ois.readObject();
            Class implClass = InMemoryRegister.getService(invocation.getInterfaceName());
            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParmaTypes());
            String result = (String) method.invoke(implClass.newInstance(), invocation.getParams());
            IOUtils.write(result, resp.getOutputStream(), "UTF-8");
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
