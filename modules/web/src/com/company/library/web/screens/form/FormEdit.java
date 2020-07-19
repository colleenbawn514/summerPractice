package com.company.library.web.screens.form;

import com.company.library.entity.Book;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.MetadataTools;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.library.entity.Form;

import javax.inject.Inject;
import java.awt.*;

@UiController("library_Form.edit")
@UiDescriptor("form-edit.xml")
@EditedEntityContainer("formDc")
@LoadDataBeforeShow

public class FormEdit extends StandardEditor<Form> {
    @Inject
    private DataManager dataManager;
    /*@Inject
    private PickerField<Book> bookField;

    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private PickerField<Book> pickerField;

    @Subscribe("pickerField.lookup")
    protected void onPickerFieldLookupActionPerformed(Action.ActionPerformedEvent event) {
       System.out.println("open select");
    }

    @Subscribe("windowCommitAndClose")
    public void addForm(Action.ActionPerformedEvent actionPerformedEvent) {
        System.out.println("AAAAAAAAAA");
    }
    */
    @Inject
    private InstanceContainer<Form> formDc;
    @Inject
    private Metadata metadata;
    @Inject
    private MetadataTools metadataTools;
    @Inject
    private Notifications notifications;
    @Inject
    private Button saveButton;
    @Inject
    private PickerField<Book> bookField;

    @Subscribe(id = "formDc", target = Target.DATA_CONTAINER)
    protected void onOrderDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<Form> event) {
        if(!event.getProperty().equals("book") && !event.getProperty().equals("reader")){
            return;
        }
        Book book = event.getItem().getBook();
        if(book==null) {
            return;
        }
        Boolean alreadyExist = isExistBook(book, event.getItem().getReader().getFullName());
        saveButton.setEnabled(!alreadyExist);
        bookField.setFrame(Frame.ERROR);
        if(alreadyExist){
            notifications.create(Notifications.NotificationType.TRAY)
                    .withCaption("There is such a book on hand")
                    .show();
        }
    }

    private Boolean isExistBook(Book book, String reader){
        return dataManager.load(Form.class)
                .query("select e from library_Form e where e.book.name = :bookName " +
                        "and e.book.author = :bookAuthor " +
                        "and e.endDate is not null " +
                        "and e.reader.fullName = :reader")
                .parameter("bookName", book.getName())
                .parameter("bookAuthor", book.getAuthor())
                .parameter("reader", reader)
                .view("form-view").list().size()!=0;
    }

}