package com.company.library.web.screens.library;

import com.haulmont.cuba.gui.screen.*;
import com.company.library.entity.Library;

@UiController("library_Library.edit")
@UiDescriptor("library-edit.xml")
@EditedEntityContainer("libraryDc")
@LoadDataBeforeShow
public class LibraryEdit extends StandardEditor<Library> {
}