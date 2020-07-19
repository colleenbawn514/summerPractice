package com.company.library.web.screens.bookinlibrary;

import com.haulmont.cuba.gui.screen.*;
import com.company.library.entity.BookInLibrary;

@UiController("library_BookInLibrary.browse")
@UiDescriptor("book-in-library-browse.xml")
@LookupComponent("bookInLibrariesTable")
@LoadDataBeforeShow
public class BookInLibraryBrowse extends StandardLookup<BookInLibrary> {
}