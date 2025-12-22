package com.skillnext1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeDAO {

    public static void save(Employee emp) {
        System.out.println("DAO save() called"); // DEBUG 1

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL Driver Loaded"); // DEBUG 2

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employeewebapp_db",
                "root",
                "root"
            );
            System.out.println("Database Connected"); // DEBUG 3

            String sql = "INSERT INTO employeeweb (name, email, salary) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setDouble(3, emp.getSalary());

            int rows = ps.executeUpdate();
            System.out.println("Rows inserted: " + rows); // DEBUG 4

            con.close();

        } catch (Exception e) {
            System.out.println("ERROR OCCURRED:");
            e.printStackTrace(); // THIS IS CRITICAL
        }
    }
}
