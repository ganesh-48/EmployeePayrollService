package employeePayrollService;

import com.employeepayrollservice.EmployeePayrollData;

import java.util.Collections;
import java.util.List;

public class EmployeePayrollServices {
    public boolean checkEmployeePayrollSynchornizedWithDB(String name) {
        EmployeePayrollServices employeePayrollDBServices = null;
        List<EmployeePayrollData> employeePayrollDataList = Collections.singletonList(employeePayrollDBServices.getEmployeePayrollData(name));
        return employeePayrollDataList.get(0).equals(readEmployeePayrollData(IOService.valueOf(name)));
    }
    public void updateEmployeeSalary(String name, Double salary) {
        int result = employeePayrollDBServices.updateEmployeeData(name, salary);
        if (result == 0) return;
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollData(name);
        if (employeePayrollData != null)
            EmployeePayrollData.salary = salary;
    }

    private EmployeePayrollData getEmployeePayrollData(String name) {
        return this.employeePayrollDataList.stream().filter(employeePayrollDataItem -> employeePayrollDataItem.name.equals(name)).findFirst().orElse(null);
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
