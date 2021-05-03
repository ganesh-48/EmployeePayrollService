package com.employeepayrollservice;

import java.util.List;

public class EmployeePayrollServices {
    public void updateEmployeeSalary(String name, double salary) {

    }

    public boolean checkEmployeePayrollSynchornizedWithDB(String name) {
        return false;
    }

    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO,REST_IO}

    private List<EmployeePayrollData> employeePayrollDataList;
    private EmployeePayrollServices employeePayrollServices;
    public EmployeePayrollServices() {}

    public List<EmployeePayrollData> readEmployeePayrollData(IOService ioService) {
        if(ioService.equals(IOService.DB_IO))
            this.employeePayrollDataList = new EmployeePayrollDBServices().readData();
        return this.employeePayrollDataList;
    }
}
