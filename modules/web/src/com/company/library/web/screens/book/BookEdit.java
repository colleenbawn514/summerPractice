package com.company.library.web.screens.book;

import com.haulmont.cuba.gui.screen.*;
import com.company.library.entity.Book;

@UiController("library_Book.edit")
@UiDescriptor("book-edit.xml")
@EditedEntityContainer("bookDc")
@LoadDataBeforeShow
public class BookEdit extends StandardEditor<Book> {
}