package service;

import model.Teacher;
import repository.TeacherRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class TeacherService {
    int result;
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

    public boolean removeTeacher(long id){
        try{
            if(teacherRepository.findById(id)!=null) result=teacherRepository.deleteTeacher(id);
            if(result>0) return true;
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            System.out.println("delete teacher failed");
        }
        return false;
    }

    public void findTeacher(long id){
        try{
          Teacher teacher=teacherRepository.findById(id);
          if(teacher!=null) System.out.println("teacher found");
          else System.out.println("teacher not found");
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            System.out.println("connection failed");
        }
    }
    public void update(String name, String oldName){
        try{
            int result=teacherRepository.update(name, oldName);
            if(result>0) System.out.println("update success");
            else System.out.println("update failed");

        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            System.out.println("update failed");
        }
    }
}
