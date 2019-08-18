package org.warless.incubator.common.utils;

import org.springframework.beans.BeanUtils;

import java.io.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author yubb
 * @date 2019-07-10
 */
public final class BeanUtil {

    public static<T> List<T> copyPropertiesList(List<?> origList, Class<T> destClass) {
        return origList.stream().map(orig -> copyProperties(orig, destClass)).collect(Collectors.toList());
    }

    public static<T> Set<T> copyPropertiesSet(Set<?> origList, Class<T> destClass) {
        return origList.stream().map(orig -> copyProperties(orig, destClass)).collect(Collectors.toSet());
    }

    public static<T> T copyProperties(Object orig, Class<T> dest) {
        T obj = null;
        try {
            obj = dest.newInstance();
            BeanUtils.copyProperties(orig, obj);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static <T extends Serializable> T clone(T t) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(t);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
