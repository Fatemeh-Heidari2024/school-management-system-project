package repository;

import model.Course;
import model.Exam;
import util.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExamRepository {
    DBConnection dbConnection = new DBConnection();
        public int addExam(Exam exam)throws SQLException {
             DBConnection dbConnection1 = new DBConnection();
            String addExam ="insert into school_management.public.exam(date,grade,cource_id) values (?,?,?)";
            PreparedStatement preparedStatement=dbConnection.getDatabaseConnection().prepareStatement(addExam,1);
            preparedStatement.setDate(1, Date.valueOf(exam.getDate()));
            preparedStatement.setInt(2, exam.getGrade());
            preparedStatement.setLong(3,exam.getCourseId());
            return preparedStatement.executeUpdate();
        }
        public int delete(long id)throws SQLException{
            String deleteExamSql="delete from school_management.public.exam where exam_id=?";
            PreparedStatement preparedStatement=dbConnection.getDatabaseConnection().prepareStatement(deleteExamSql);
            preparedStatement.setLong(1,id);
            return preparedStatement.executeUpdate();
        }
        public int update(LocalDate newDate,LocalDate oldDate)throws SQLException{
            String updateExamSql="update school_management.public.exam set date=? where date=?";
            PreparedStatement preparedStatement=dbConnection.getDatabaseConnection().prepareStatement(updateExamSql);
            preparedStatement.setDate(1, Date.valueOf(newDate));
            preparedStatement.setDate(2,Date.valueOf(oldDate));
             return preparedStatement.executeUpdate();
        }
        public List<Exam> getAllExam()throws SQLException{
            List<Exam> examList=new ArrayList<>();
            String getExamSql ="select * from school_management.public.exam";
            Statement statement= dbConnection.getSqlStatement();
            ResultSet resultSet= statement.executeQuery(getExamSql);
            while(resultSet.next()){
                examList.add(new Exam(resultSet.getLong(1),
                        resultSet.getDate(2).toLocalDate(),
                        (resultSet.getInt(4)),
                        resultSet.getLong(4))) ;
            }
            return examList;
        }

    }