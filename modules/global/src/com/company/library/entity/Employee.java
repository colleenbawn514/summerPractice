package com.company.library.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamePattern("%s|fullName")
@Table(name = "LIBRARY_EMPLOYEE")
@Entity(name = "library_Employee")
public class Employee extends StandardEntity {
    private static final long serialVersionUID = 2653251762766592547L;

    @NotBlank(message = "Имя должно быть заполненым")
    @NotEmpty(message = "Имя должно быть заполненым")
    @NotNull(message = "Имя должно быть заполненым")
    @Column(name = "FULL_NAME")
    protected String fullName;

    @OneToMany(mappedBy = "employee")
    protected List<Form> forms;

    @NotNull(message = "Место работы не может быть пустым")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LIBRARY_ID")
    protected Library library;

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}