package service;

import model.Exam;
import repository.ExamRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExamService {
    private ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public void saveExam(Exam exam) {
        try {
            String result = (examRepository.addExam(exam) > 0) ? "add exam success" : "add exam failed";
            System.out.println(result);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("connection failed");
        }
    }

    public void delete(long id) {
        try {
            String result = (examRepository.delete(id) > 0) ? "delete exam success" : "delete exam failed";
            System.out.println(result);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("connection failed");
        }
    }

    public void update(LocalDate newdate, LocalDate olddate) {
        try {
            int result=examRepository.update(newdate, olddate);
            if(result>0) System.out.println("update success");
            else System.out.println("update failed");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("connection failed");
        }
    }

    public void getAllExam() {
        List< Exam > examList = new ArrayList<>();
        try{
           examList= examRepository.getAllExam();
            for (Exam exam : examList) {
                System.out.println(exam);
            }
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            System.out.println("connection failed");
        }

    }

}