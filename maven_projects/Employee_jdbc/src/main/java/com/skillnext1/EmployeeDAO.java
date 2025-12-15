package com.skillnext1;
import java.sql.*;

public class EmployeeDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/employee_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Get DB Connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 1. INSERT employee
    public void insertEmployee(Employee emp) {
        String sql = "INSERT INTO Employee VALUES (?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setString(3, emp.getEmail());
            ps.setDouble(4, emp.getSal());

            ps.executeUpdate();
            System.out.println("Employee inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2. VIEW all employees
    public void viewEmployees() {
        String sql = "SELECT * FROM Employee";

        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("ID  NAME  EMAIL  SALARY");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "  " +
                        rs.getString("name") + "  " +
                        rs.getString("email") + "  " +
                        rs.getDouble("sal"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3. UPDATE employee salary
    public void updateEmployee(int id, double newSal) {
        String sql = "UPDATE Employee SET sal=? WHERE id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, newSal);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Employee updated.");
            else
                System.out.println("Employee not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 4. DELETE employee
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM Employee WHERE id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Employee deleted.");
            else
                System.out.println("Employee not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
