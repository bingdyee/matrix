package io.github.matrix.rec;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;

import java.io.File;
import java.io.IOException;

/**
 * @author Noa Swartz
 * @date 2020/12/15
 */
public class StringItemIDFileDataModel extends FileDataModel {

    public ItemMemIDMigrator itemMemIDMigrator;

    public StringItemIDFileDataModel(File dataFile, String regex) throws IOException {
        super(dataFile, regex);
    }

    @Override
    protected long readItemIDFromString(String value) {
        if (itemMemIDMigrator == null) {
            itemMemIDMigrator = new ItemMemIDMigrator();
        }
        long retValue = itemMemIDMigrator.toLongID(value);
        if (null == itemMemIDMigrator.toStringID(retValue)) {
            itemMemIDMigrator.singleInit(value);
        }
        return retValue;
    }

    public String getItemIDAsString(long itemId) {
        return itemMemIDMigrator.toStringID(itemId);
    }

}
