package com.company.library.web.screens.library;

import com.haulmont.cuba.gui.screen.*;
import com.company.library.entity.Library;

@UiController("library_Library.browse")
@UiDescriptor("library-browse.xml")
@LookupComponent("librariesTable")
@LoadDataBeforeShow
public class LibraryBrowse extends StandardLookup<Library> {
}