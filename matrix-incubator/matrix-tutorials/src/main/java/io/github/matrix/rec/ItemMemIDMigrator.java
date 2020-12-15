package io.github.matrix.rec;

import org.apache.mahout.cf.taste.impl.common.FastByIDMap;
import org.apache.mahout.cf.taste.impl.model.AbstractIDMigrator;

/**
 * @author Noa Swartz
 * @date 2020/12/15
 */
public class ItemMemIDMigrator extends AbstractIDMigrator {

    public FastByIDMap<String> longToString;

    public ItemMemIDMigrator() {
        longToString = new FastByIDMap<>(10000);
    }

    public void storeMapping(long longId, String stringId) {
        longToString.put(longId, stringId);
    }

    public void singleInit(String stringId) {
        storeMapping(toLongID(stringId), stringId);
    }

    @Override
    public String toStringID(long longID) {
        return longToString.get(longID);
    }

}
