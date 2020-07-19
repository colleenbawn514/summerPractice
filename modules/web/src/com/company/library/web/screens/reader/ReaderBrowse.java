package com.company.library.web.screens.reader;

import com.haulmont.cuba.gui.screen.*;
import com.company.library.entity.Reader;

@UiController("library_Reader.browse")
@UiDescriptor("reader-browse.xml")
@LookupComponent("readersTable")
@LoadDataBeforeShow
public class ReaderBrowse extends StandardLookup<Reader> {
}