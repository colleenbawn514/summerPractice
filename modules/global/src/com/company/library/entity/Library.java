package com.company.library.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamePattern("%s|name")
@Table(name = "LIBRARY_LIBRARY")
@Entity(name = "library_Library")
public class Library extends StandardEntity {
    private static final long serialVersionUID = -58286453506487130L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @OneToMany(mappedBy = "library")
    protected List<BookInLibrary> bookInLibrary;

    @OneToMany(mappedBy = "library")
    protected List<Employee> employees;

    @JoinTable(name = "LIBRARY_LIBRARY_READER_LINK",
            joinColumns = @JoinColumn(name = "LIBRARY_ID"),
            inverseJoinColumns = @JoinColumn(name = "READER_ID"))
    @ManyToMany
    protected List<Reader> readers;

    public List<BookInLibrary> getBookInLibrary() {
        return bookInLibrary;
    }

    public void setBookInLibrary(List<BookInLibrary> bookInLibrary) {
        this.bookInLibrary = bookInLibrary;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}