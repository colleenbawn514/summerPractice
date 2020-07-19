package com.company.library.web.screens.form;

import com.company.library.entity.Book;
import com.company.library.entity.Reader;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.MetadataTools;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.components.ValidationException;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.library.entity.Form;

import javax.inject.Inject;
import java.awt.*;
import java.util.Map;

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
    @Inject
    private PickerField<Reader> readerField;

    @Subscribe
    public void onInit(InitEvent event) {
        bookField.addValidator(value -> {
            Reader reader = readerField.getValue();
            if(value !=null && reader!=null){
                Boolean alreadyExist = isExistBook(value, reader.getFullName());
                saveButton.setEnabled(!alreadyExist);

                if(alreadyExist){
                    notifications.create(Notifications.NotificationType.TRAY)
                            .withCaption("There is such a book on hand")
                            .show();
                    throw new ValidationException("You cannot select admin user");
                }
            }
        });
    }

    @Subscribe(id = "formDc", target = Target.DATA_CONTAINER)
    protected void onOrderDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<Form> event) {
        if(!event.getProperty().equals("book") && !event.getProperty().equals("reader")){
            return;
        }
        Book book = event.getItem().getBook();
        if(book==null) {
            return;
        }
       bookField.validate();
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