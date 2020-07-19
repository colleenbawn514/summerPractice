package com.company.library.web.screens.employee;

import com.company.library.entity.Book;
import com.company.library.entity.Form;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.library.entity.Employee;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@UiController("library_Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
@LoadDataBeforeShow
public class EmployeeEdit extends StandardEditor<Employee> {
    @Inject
    private Table<Form> formsTable;

    @Inject
    private DataManager dataManager;

    @Inject
    private CollectionLoader<Form> formsDl;

    @Inject
    private Notifications notifications;

    @Subscribe("formsTable.closeForm")
    public void closeForm(Action.ActionPerformedEvent actionPerformedEvent) {

        Form form = formsTable.getSingleSelected();
        assert form != null;

        form = loadFormById(form.getId());
        System.out.println(form.getEndDate());
        form.setEndDate(new Date());

        CommitContext commitContext = new CommitContext();
        commitContext.addInstanceToCommit(form, "form-view");
        dataManager.commit(commitContext);

        notifications.create(Notifications.NotificationType.TRAY)
                .withCaption("Формуляр закрыт")
                .show();
        formsDl.load();
    }

    private Form loadFormById(UUID formId) {
        LoadContext<Form> loadContext = LoadContext.create(Form.class)
                .setId(formId).setView("form-view");
        return dataManager.load(loadContext);
    }

}