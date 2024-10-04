package service;

import model.Teacher;
import repository.TeacherRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherService {
    TeacherRepository teacherRepository=new TeacherRepository();

    public TeacherService(TeacherRepository teacherRepository) {
    }

    public void saveTeacher(){
        Teacher teacher = new Teacher();
        teacher.setFirstName("c");
        teacher.setLastName("d");
        teacher.setNationalCode("8956215487");
        teacher.setDataOfBirth(LocalDate.parse("2000-10-09"));
        try{
            teacherRepository.addTeacher(teacher);
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            System.out.println("connection failed");
        }

    }

    public void showAllTeachers(){
        try{
            List<Teacher> teachers=teacherRepository.getAllTeacher();
            for (Teacher teacher : teachers) {
                System.out.println(teacher.toString());
            }
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            System.out.println("Connection failed");
        }
    }
    public void showCountOfTeacher(){
        try{
            int count=teacherRepository.getCountOfTeachers();
            System.out.println("CountOfTeacher is: "+count);
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            System.out.println("connection failed");
        }
    }
}
