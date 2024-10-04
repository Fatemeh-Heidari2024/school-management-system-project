import model.Student;
import repository.StudentRepository;
import repository.TeacherRepository;
import service.StudentService;
import service.TeacherService;

import java.sql.*;
import java.time.LocalDate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class SqlManagementSystem {
    public static void main(String[] args) throws SQLException {
        StudentService studentService = new StudentService(new StudentRepository());
//        studentService.saveStudent(new Student("ff","hh","9874563211",LocalDate.parse("2024-12-12"),12.5));
//        studentService.printStudent();
//        System.out.println("------------------");
//        studentService.printCountOfStudent();
//        System.out.println("*******************");
//        TeacherService teacherService=new TeacherService(new TeacherRepository());
//        teacherService.saveTeacher();
//        teacherService.showAllTeachers();
//        System.out.println("-----------");
//        teacherService.showCountOfTeacher();
//        System.out.println("***************");
        //studentService.getStudentByName("fatemeh");
        studentService.getINfo();

    }
}