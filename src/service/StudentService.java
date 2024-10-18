package service;

import dto.EnrollmentDTO;
import dto.RequestStudentDTO;
import model.Student;
import repository.StudentRepository;
import service.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    int result;
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
        try{
            if(student!=null)
                studentRepository.addStudent(student);
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            System.out.println("add student failed");
        }
    }

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

    public boolean studentUpdate(RequestStudentDTO requestStudentDTO){
        try{
            int result=studentRepository.updateStudent(requestStudentDTO.getOldName(),requestStudentDTO.getNewName());
            if(result>0) return true;

        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            System.out.println("update failed");
        }
        return false;
    }
    public void removeStudent(RequestStudentDTO requestStudentDTO){
        try{
            if(studentRepository.findById(requestStudentDTO.getId())!=null)
            result=studentRepository.deleteStudent(requestStudentDTO.getNatCode());
               if(result>0) System.out.println("delete student successful");
            else System.out.println("delete student failed");
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            System.out.println("connection failed");
        }
    }
}
