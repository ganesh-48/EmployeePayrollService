package com.employeepayrollservice;

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

    @Test
    public void giveUpdateSalaryForEmployeeWhenItShouldMatch() {
        EmployeePayrollServices employeePayrollServices = new EmployeePayrollServices();
        employeePayrollDataList = employeePayrollService.readEmployeePayrollData(EmployeePayrollServices.IOService.DB_IO);
        employeePayrollServices.updateEmployeeSalary("ram", 30000.0);
        boolean result = employeePayrollServices.checkEmployeePayrollSynchornizedWithDB("ram");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenEmployeeSalaryWhenUpdatedshouldSynchornizeDB() {
        EmployeePayrollServices employeePayrollServices = new EmployeePayrollServices();
        employeePayrollDataList = employeePayrollService.readEmployeePayrollData(EmployeePayrollServices.IOService.DB_IO);
        employeePayrollService.updateDataUsingStatement("ram", 3000000.00);
        boolean result = employeePayrollServices.checkEmployeePayrollSynchornizedWithDB("ram");
        Assertions.assertTrue(result);
    }
}
