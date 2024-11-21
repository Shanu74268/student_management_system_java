package com.student_management_system.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student_management_system.database.DatabaseConnection;
import com.student_management_system.model.Student;

public class Services { 
	 
	    public void addStudent(Student student) {
	        String query = "INSERT INTO students (name, age, grade, email) VALUES (?, ?, ?, ?)";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query)) {

	            stmt.setString(1, student.getName());
	            stmt.setInt(2, student.getAge());
	            stmt.setString(3, student.getGrade());
	            stmt.setString(4, student.getEmail());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<Student> getAllStudents() {
	        List<Student> students = new ArrayList<>();
	        String query = "SELECT * FROM students";

	        try (Connection conn = DatabaseConnection.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(query)) {

	            while (rs.next()) {
	                students.add(new Student(
	                    rs.getInt("id"),
	                    rs.getString("name"),
	                    rs.getInt("age"),
	                    rs.getString("grade"),
	                    rs.getString("email")
	                ));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return students;
	    }

	    public void updateStudent(Student student) {
	        String query = "UPDATE students SET name = ?, age = ?, grade = ?, email = ? WHERE id = ?";

	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query)) {

	            stmt.setString(1, student.getName());
	            stmt.setInt(2, student.getAge());
	            stmt.setString(3, student.getGrade());
	            stmt.setString(4, student.getEmail());
	            stmt.setInt(5, student.getId());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteStudent(int id) {
	        String query = "DELETE FROM students WHERE id = ?";

	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query)) {

	            stmt.setInt(1, id);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
