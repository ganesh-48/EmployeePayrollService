package employeePayrollService;

import com.employeepayrollservice.EmployeePayrollData;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDBServices {
    private List<EmployeePayrollData> employeePayrollDataList;

    private Connection getConnection() throws SQLException, SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/employee_payroll";
        String userName = "root";
        String userPass = "root";
        Connection connection;
        System.out.println("Connecting to database:"+jdbcURL);
        connection = DriverManager.getConnection(jdbcURL,userName,userPass);
        System.out.println("Connection is successful! "+ connection);
        return connection;
    }

    public List<EmployeePayrollData> readData() {
        String sql= "SELECT * FROM employee_payroll; ";
        List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        try {
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                double salary = result.getDouble("salary");
                LocalDate startDate = result.getDate("start").toLocalDate();
                employeePayrollList.add(new EmployeePayrollData(id, name, salary, startDate));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeePayrollDataList;
    }
}
