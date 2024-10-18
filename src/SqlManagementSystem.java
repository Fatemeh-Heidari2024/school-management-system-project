import model.Course;
import model.Student;
import repository.CourseRepository;
import repository.ExamRepository;
import repository.StudentRepository;
import repository.TeacherRepository;
import service.CourseService;
import service.ExamService;
import service.StudentService;
import service.TeacherService;

import java.sql.*;
import java.time.LocalDate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class SqlManagementSystem {
    public static void main(String[] args) throws SQLException {
        StudentService studentService = new StudentService(new StudentRepository());
    //studentService.saveStudent(new Student("nn","kk","9874563288",LocalDate.parse("2024-12-12"),12.5));
//        studentService.printStudent();
//        System.out.println("------------------");
//        studentService.printCountOfStudent();
//        System.out.println("*******************");
        //studentService.getStudentByName("fatemeh");
        // studentService.getINfo();
//        final RequestStudentDTO requestStudentDTO = new RequestStudentDTO("mahsa","mahla");
//if(studentService.studentUpdate(requestStudentDTO)==true){
//    System.out.println("update successful");}
        // studentService.removeStudent(new RequestStudentDTO("9874563211"));

       TeacherService teacherService=new TeacherService(new TeacherRepository());
//        teacherService.saveTeacher();
         //teacherService.showAllTeachers();
        // teacherService.update("d","c");
       // teacherService.showAllTeachers();
//        System.out.println("-----------");
//        teacherService.showCountOfTeacher();
//        System.out.println("***************");

//        boolean result=teacherService.removeTeacher(6);
//        if(result==true) System.out.println("delete teacher successful");
//        else System.out.println("delete teacher failed");

        ExamService examService=new ExamService(new ExamRepository());
        //examService.saveExam(new Exam(LocalDate.parse("2024-12-12"),1,1));
        //examService.saveExam(new Exam(LocalDate.parse("2024-12-12"),2,2));
        //examService.getAllExam();
       //examService.update(LocalDate.parse("2024-12-12"),LocalDate.parse("2024-12-18"));
        //examService.getAllExam();
        //examService.delete(1);

        CourseService courseService=new CourseService(new CourseRepository());
        //courseService.saveCource(new Course("network",3));
        //courseService.saveCource(new Course("php",4));
       // courseService.getAllCourse();
        //courseService.update( "network","SIEM");
        //courseService.remove("php");
       // courseService.getAllCourse();


    }
    }