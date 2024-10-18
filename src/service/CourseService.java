package service;

import model.Course;
import repository.CourseRepository;

import java.sql.SQLException;
import java.util.List;

public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public void saveCource(Course cource){
        try {
            String result=(courseRepository.addCource(cource)>0)? "add successfull" : "add failed";
            System.out.println(result);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("coonection failed");
        }
    }
    public void remove(String title){
        try {
            int result=courseRepository.delete(title);
            if(result>0) System.out.println("remove success");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("connection failed");
        }
    }
    public void update(String newTitle,String oldTitle){
        try {
            int result=courseRepository.update(newTitle,oldTitle);
            if(result>0) System.out.println("update success");
            else System.out.println("update failed");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("coonection failed");
        }
    }
    public void getAllCourse() {
        try {
            List< Course > courseList = courseRepository.getAllCourse();
            for (Course course : courseList) {
                System.out.println(course.toString());
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("connection failed");
        }
    }
}
