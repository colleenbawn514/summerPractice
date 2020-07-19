package com.company.library.web.screens.reader;

import com.haulmont.cuba.gui.screen.*;
import com.company.library.entity.Reader;

@UiController("library_Reader.edit")
@UiDescriptor("reader-edit.xml")
@EditedEntityContainer("readerDc")
@LoadDataBeforeShow
public class ReaderEdit extends StandardEditor<Reader> {
}