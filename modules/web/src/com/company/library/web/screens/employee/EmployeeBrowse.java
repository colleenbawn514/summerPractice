package com.company.library.web.screens.employee;

import com.haulmont.cuba.gui.screen.*;
import com.company.library.entity.Employee;

@UiController("library_Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
@LoadDataBeforeShow
public class EmployeeBrowse extends StandardLookup<Employee> {

}