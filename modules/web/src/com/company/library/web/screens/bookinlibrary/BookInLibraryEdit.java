package com.company.library.web.screens.bookinlibrary;

import com.haulmont.cuba.gui.screen.*;
import com.company.library.entity.BookInLibrary;

@UiController("library_BookInLibrary.edit")
@UiDescriptor("book-in-library-edit.xml")
@EditedEntityContainer("bookInLibraryDc")
@LoadDataBeforeShow
public class BookInLibraryEdit extends StandardEditor<BookInLibrary> {
}