package com.employeepayrollservice;

import employeePayrollService.EmployeePayrollServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EmployeePayrollServiceTest {
    EmployeePayrollService employeePayrollService;
    List<EmployeePayrollData> employeePayrollDataList;

    @Test
    public void givenEmployeePayrollServiceDataBaseWhenRetrivedShoudCount() {
        EmployeePayrollServices employeePayrollServices = new EmployeePayrollServices();
        employeePayrollDataList = employeePayrollService.readEmployeePayrollData(EmployeePayrollServices.IOService.DB_IO);
        Assertions.assertEquals(3,employeePayrollDataList.size());
    }
}
