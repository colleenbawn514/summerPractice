package com.company.library.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "LIBRARY_BOOK_IN_LIBRARY")
@Entity(name = "library_BookInLibrary")
public class BookInLibrary extends StandardEntity {
    private static final long serialVersionUID = 4362115751858477410L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BOOK_ID")
    protected Book book;

    @NotNull
    @Column(name = "COUNT_", nullable = false)
    protected Integer count;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LIBRARY_ID")
    protected Library library;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}