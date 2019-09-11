package org.warless.incubator.web.framework;


import java.lang.reflect.InvocationTargetException;

/**
 * codespot
 *
 * @author : Noa Swartz
 * @date: 2019-05-24
 * @email: fetaxyu@gmail.com
 */
public abstract class AbstractController {

    public ResponseEntity invokeService(RequestEntity params) throws InvocationTargetException, IllegalAccessException {
        Entry entry = SpringContextUtil.getMethod(params.getTraCode());
        return (ResponseEntity)entry.getMethod().invoke(entry.getService(), params);
    }

    protected abstract ResponseEntity doGet(RequestEntity params);
    protected abstract ResponseEntity doPost(RequestEntity params);

}
