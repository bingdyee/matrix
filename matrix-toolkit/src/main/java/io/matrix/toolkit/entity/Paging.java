package io.matrix.toolkit.entity;

import org.springframework.data.domain.Pageable;

import java.util.*;

/**
 * @author Noa Swartz
 * @date 2020/09/20
 */
public class Paging<T> implements Iterable<T> {

    private final Long total;

    /** current page */
    private Integer number;
    /** page size */
    private Integer size;
    /** page data */
    private List<T> content;

    public Paging(List<T> content, Pageable pageable, Long total) {
        this.total = total;
        this.content = content == null ? new ArrayList<>() : content;
        this.size = pageable.isPaged() ? pageable.getPageSize() : this.content.size();
        this.number = pageable.isPaged() ? pageable.getPageNumber() : 0;
    }

    public static<T> Paging<T> of(List<T> content, Pageable pageable, Long total) {
        return new Paging<>(content, pageable, total);
    }

    public long getTotalElements() {
        return this.total;
    }

    public int getSize() {
        return this.size;
    }

    public int getNumber() {
        return this.number;
    }

    public List<T> getContent() {
        return Collections.unmodifiableList(content);
    }

    public Integer getTotalPages() {
        return getSize() == 0 ? 1 : (int) Math.ceil((double) total / (double) getSize());
    }

    @Override
    public Iterator<T> iterator() {
        return this.content.iterator();
    }

}
