package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
		StudentDao studentDao = (StudentDao) context.getBean("studentDao");
		Student student;

		System.out.println("*************Welcome to Student Details Page*************");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int studentIdCounter = 0, id;
		String name, city;

		while (true) {
			try {
				System.out.println("Enter 1: Add a new Student");
				System.out.println("Enter 2: View a Student");
				System.out.println("Enter 3: View all Students");
				System.out.println("Enter 4: Update a Student");
				System.out.println("Enter 5: Delete a Student");
				System.out.println("Enter 6: Exit the program");

				int op = Integer.parseInt(br.readLine());

				switch (op) {
				case 1:
					System.out.println("Enter the student Name: ");
					name = br.readLine();

					System.out.println("Enter the city name: ");
					city = br.readLine();

					studentIdCounter += 1;
					student = new Student(studentIdCounter, name, city);
					studentDao.insert(student);
					System.out.println("Student successfully added");
					break;
				case 2:
					System.out.println("Enter the ID of student: ");
					id = Integer.parseInt(br.readLine());
					student = studentDao.getStudent(id);
					System.out.println("Student Name: " + student.getStudentName());
					System.out.println("Student City: " + student.getStudentCity());
					break;
				case 3:
					List<Student> students = studentDao.getStudents();
					for (Student s : students) {
						System.out.println("______________________________________");
						System.out.println("Student Id: " + s.getStudentId());
						System.out.println("Student Name: " + s.getStudentName());
						System.out.println("Student City: " + s.getStudentCity());
					}
					System.out.println("______________________________________");
					System.out.println("List of all students end.");
					break;
				case 4:
					System.out.println("Enter the id of student: ");
					id = Integer.parseInt(br.readLine());
					
					System.out.println("Enter the student Name: ");
					name = br.readLine();

					System.out.println("Enter the city name: ");
					city = br.readLine();

					student = new Student(id, name, city);
					studentDao.updateStudent(student);
					
					System.out.println("Successfully Updated Student details");
					break;
				case 5:
					System.out.println("Enter the student id: ");
					id = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(id);
					System.out.println("Successfully Deleted Student");
					break;
				case 6:
					System.out.println("Thank you");
					System.exit(0);
					break;
				default:
					System.out.println("Please enter the correct option");
				}
			} catch (Exception ex) {
				System.out.println("Error");
				System.out.println(ex.getMessage());
			}

		}

	}
}
