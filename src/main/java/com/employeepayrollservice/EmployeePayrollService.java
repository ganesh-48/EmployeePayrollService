package com.employeepayrollservice;

import employeePayrollService.EmployeePayrollServices;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.List;

/*@Description- Created a Employee payroll service database.
 * java program connect to database.*/
public class EmployeePayrollService {
    public static void main(String[] args) {
        System.out.println("Welcome to payroll service");

        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "root";
        Connection connection;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find driver in classpath!", e);
        }
        listDrivers();

        try {
            System.out.println("Connecting to database:" + jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection is successfully!!!" + connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println("  " + driverClass.getClass().getName());
        }
    }

    public List<EmployeePayrollData> readEmployeePayrollData(EmployeePayrollServices.IOService dbIo) {
        return null;
    }

    public class IOService {
    }
}