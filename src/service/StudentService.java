package service;

import dto.EnrollmentDTO;
import model.Student;
import repository.StudentRepository;
import service.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void printStudent() {
        try{
            List< Student > students=studentRepository.getAllStudent();
            for (Student student : students) {
                System.out.println(student.toString());
            }
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            //System.out.println("connection failed!");
        }

    }

    public void printCountOfStudent() {
        try{
            int count=studentRepository.getCountOfStudent();
            System.out.println("count of students is: "+count);
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            //System.out.println("connection failed");
        }
    }
    public void saveStudent(Student student){
        if(student!=null)
            studentRepository.addStudent(student);
    }
//    public List< EnrollmentDTO > showStudentEnrollment(Long student_id){
//        studentRepository.
//    }

    public void getStudentByName(String name){
        List<Student> students=new ArrayList<>();
        try{
             students=studentRepository.getStudentByFirstName(name);
            for (Student student : students) {
                System.out.println(student.toString());
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            System.out.println("failed");
        }
    }
    public void getINfo(){
        try{
            List<EnrollmentDTO> enrollmentDTOS=studentRepository.enrollment();
            for (EnrollmentDTO enrollmentDTO : enrollmentDTOS) {
                System.out.println(enrollmentDTO.toString());
            }
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
