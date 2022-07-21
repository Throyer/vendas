package com.github.throyer.vendas.api.domain.pagination;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class Page<T> {
    private final Collection<? extends T> content;
    private final Integer page;
    private final Integer size;  
    private final Integer totalPages;  
    private final Long totalElements;

    public Page(org.springframework.data.domain.Page<T> page) {
        this.content = page.getContent();
        this.page = page.getNumber();
        this.size = page.getSize();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
    }

    public Page(Collection<? extends T> content, Integer page, Integer size, Long count) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.totalPages = (int) Math.ceil((double)count / size);
        this.totalElements = count;
    }

    public static <T> Page<T> of(org.springframework.data.domain.Page<T> page) {
        return new Page<>(page);
    }
    
    public static <T> Page<T> of(Collection<T> content, Integer page, Integer size, Long count) {
        return new Page<T>(content, page, size, count);
    }

    public <U> Page<U> map(Function<? super T, ? extends U> converter) {
        var content = this.content.stream().map(converter).toList();
        return new Page<U>(content, this.page, this.size, this.totalElements);
    }

    public static <T> Page<T> empty() {
        return new Page<>(List.of(), 0, 0, 0L);
    }

    public Collection<? extends T> getContent() {
        return content;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }
}
