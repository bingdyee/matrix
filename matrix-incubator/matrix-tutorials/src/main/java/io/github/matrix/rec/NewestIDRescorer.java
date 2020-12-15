package io.github.matrix.rec;

import org.apache.mahout.cf.taste.recommender.IDRescorer;

/**
 * @author Noa Swartz
 * @date 2020/12/15
 */
public class NewestIDRescorer implements IDRescorer {

    public static final double DEFAULT_ALPHA = 1.0;

    private final double alpha;

    public NewestIDRescorer() {
        this.alpha = DEFAULT_ALPHA;
    }

    public NewestIDRescorer(double alpha) {
        this.alpha = alpha;
    }

    @Override
    public double rescore(long id, double originalScore) {
        return isNewest(id) ? originalScore * alpha : originalScore;
    }

    @Override
    public boolean isFiltered(long id) {
        return false;
    }

    public boolean isNewest(long id) {
        return false;
    }

}
