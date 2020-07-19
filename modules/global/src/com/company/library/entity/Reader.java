package com.company.library.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamePattern("%s|fullName")
@Table(name = "LIBRARY_READER")
@Entity(name = "library_Reader")
public class Reader extends StandardEntity {
    private static final long serialVersionUID = 1703347473164870323L;

    @NotNull
    @Column(name = "FULL_NAME", nullable = false)
    protected String fullName;

    @OneToMany(mappedBy = "reader")
    protected List<Form> forms;

    @JoinTable(name = "LIBRARY_LIBRARY_READER_LINK",
            joinColumns = @JoinColumn(name = "READER_ID"),
            inverseJoinColumns = @JoinColumn(name = "LIBRARY_ID"))
    @ManyToMany
    protected List<Library> libraries;

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}