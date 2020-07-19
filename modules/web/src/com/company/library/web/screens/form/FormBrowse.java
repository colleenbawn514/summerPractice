package com.company.library.web.screens.form;

import com.haulmont.cuba.gui.screen.*;
import com.company.library.entity.Form;

@UiController("library_Form.browse")
@UiDescriptor("form-browse.xml")
@LookupComponent("formsTable")
@LoadDataBeforeShow
public class FormBrowse extends StandardLookup<Form> {
}