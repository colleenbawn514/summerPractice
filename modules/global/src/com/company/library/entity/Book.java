package com.company.library.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamePattern("%s - %s|name,author")
@Table(name = "LIBRARY_BOOK")
@Entity(name = "library_Book")
public class Book extends StandardEntity {
    private static final long serialVersionUID = 1845121213811114513L;

    @NotBlank(message = "Имя должно быть заполненым")
    @NotEmpty(message = "Имя должно быть заполненым")
    @Length(message = "Имя не должно превышать 255 символов", min = 1, max = 255)
    @NotNull
    @Column(name = "AUTHOR", nullable = false)
    protected String author;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "book")
    protected List<Form> forms;

    @Length(message = "Имя должно превышать 255 символов", min = 1, max = 255)
    @NotBlank(message = "Имя должно быть заполнено")
    @NotEmpty(message = "Имя должно быть заполненым")
    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @OneToMany(mappedBy = "book")
    protected List<BookInLibrary> bookInLibrary;

    public List<BookInLibrary> getBookInLibrary() {
        return bookInLibrary;
    }

    public void setBookInLibrary(List<BookInLibrary> bookInLibrary) {
        this.bookInLibrary = bookInLibrary;
    }

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}