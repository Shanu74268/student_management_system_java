package com.student_management_system.main;

import java.util.List;
import java.util.Scanner;

import com.student_management_system.model.Student;
import com.student_management_system.service.Services;

public class Main {
	public static void main(String[] args) {
		        Services service = new Services();
		        Scanner scanner = new Scanner(System.in);

		        while (true) {
		            System.out.println("\nStudent Management System");
		            System.out.println("1. Add Student");
		            System.out.println("2. View All Students");
		            System.out.println("3. Update Student");
		            System.out.println("4. Delete Student");
		            System.out.println("5. Exit");
		            System.out.print("Choose an option: ");

		            int choice = scanner.nextInt();
		            scanner.nextLine(); // Consume newline

		            switch (choice) {
		                case 1:
		                    System.out.print("Enter name: ");
		                    String name = scanner.nextLine();
		                    System.out.print("Enter age: ");
		                    int age = scanner.nextInt();
		                    scanner.nextLine(); // Consume newline
		                    System.out.print("Enter grade: ");
		                    String grade = scanner.nextLine();
		                    System.out.print("Enter email: ");
		                    String email = scanner.nextLine();

		                    service.addStudent(new Student(name, age, grade, email));
		                    System.out.println("Student added successfully!");
		                    break;

		                case 2:
		                    List<Student> students = service.getAllStudents();
		                    for (Student student : students) {
		                        System.out.println(student.getId() + " | " +
		                                student.getName() + " | " +
		                                student.getAge() + " | " +
		                                student.getGrade() + " | " +
		                                student.getEmail());
		                    }
		                    break;

		                case 3:
		                    System.out.print("Enter student ID to update: ");
		                    int id = scanner.nextInt();
		                    scanner.nextLine(); // Consume newline
		                    System.out.print("Enter new name: ");
		                    name = scanner.nextLine();
		                    System.out.print("Enter new age: ");
		                    age = scanner.nextInt();
		                    scanner.nextLine(); // Consume newline
		                    System.out.print("Enter new grade: ");
		                    grade = scanner.nextLine();
		                    System.out.print("Enter new email: ");
		                    email = scanner.nextLine();

		                    service.updateStudent(new Student(id, name, age, grade, email));
		                    System.out.println("Student updated successfully!");
		                    break;

		                case 4:
		                    System.out.print("Enter student ID to delete: ");
		                    id = scanner.nextInt();
		                    service.deleteStudent(id);
		                    System.out.println("Student deleted successfully!");
		                    break;

		                case 5:
		                    System.out.println("Exiting...");
		                    return;

		                default:
		                    System.out.println("Invalid choice. Try again.");
		            }
		        }
		    }
}
