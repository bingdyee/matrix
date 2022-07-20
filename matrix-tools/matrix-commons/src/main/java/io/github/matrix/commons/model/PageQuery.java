package io.github.matrix.commons.model;


/**
 * @author Bing D. Yee
 * @since 2021/04/05
 */
public class PageQuery {

    private int page = 0;

    private int size = 10;

    private int sort = 1;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

}
