package repository;

import model.Teacher;
import util.DBConnection;
import util.GlobalProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository {
    DBConnection dbConnection=new DBConnection();
    //language=SQL;
    String sql ="""
    insert into school_management.public.teacher(first_name,last_name,national_code,dob)
    values(?,?,?,?)""";
    public void addTeacher(Teacher teacher) throws SQLException {
        PreparedStatement preparedStatement=dbConnection.getDatabaseConnection().prepareStatement(sql,1);
        preparedStatement.setString(1,teacher.getFirstName());
        preparedStatement.setString(2,teacher.getLastName());
        preparedStatement.setString(3,teacher.getNationalCode());
        preparedStatement.setDate(4, Date.valueOf(teacher.getDataOfBirth()));
        preparedStatement.executeUpdate();
    }

    public List<Teacher> getAllTeacher() throws SQLException{
        String selectSql="select * from school_management.public.teacher";
        Statement statement= dbConnection.getSqlStatement();
       // statement.executeQuery(selectSql);
        List<Teacher> teachers=new ArrayList<>();
        ResultSet resultSet=statement.executeQuery(selectSql);
        while(resultSet.next()){
            Teacher teacher = new Teacher();
            teacher.setId(resultSet.getInt(1));
            teacher.setFirstName(resultSet.getString(2));
            teacher.setLastName(resultSet.getString(3));
            teacher.setNationalCode(resultSet.getString(4));
            teacher.setDataOfBirth(resultSet.getDate(5).toLocalDate());
            teachers.add(teacher);
        }
        return teachers;
    }
    public int getCountOfTeachers() throws SQLException {
        int count=0;
        Statement statement= dbConnection.getSqlStatement();
        String countSql="select count(teacher_id) as count from school_management.public.teacher";
       // statement.executeQuery(countSql);
        ResultSet resultSet=statement.executeQuery(countSql);
        while(resultSet.next()){
            count=resultSet.getInt("count");
        }
        return count;
    }
}
