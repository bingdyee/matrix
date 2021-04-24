package io.github.matrix.commons.util;

import java.util.Collection;

/**
 * @author Bing D. Yee
 * @since 2021/04/07
 */
public class CollectionUtils {

    public static boolean isEmpty(Collection<?> coll) {
        return (coll == null || coll.isEmpty());
    }

    public static boolean isNotEmpty(Collection<?> coll) {
        return !CollectionUtils.isEmpty(coll);
    }

}
