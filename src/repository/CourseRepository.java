package repository;

import model.Course;
import util.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    DBConnection dbConnection=new DBConnection();
    public int addCource(Course cource)throws SQLException {
        String addCourse="insert into school_management.public.cource(cource_title, cource_unit) values (?,?)";
        PreparedStatement preparedStatement=dbConnection.getDatabaseConnection().prepareStatement(addCourse,1);
        preparedStatement.setString(1,cource.getTitle());
        preparedStatement.setInt(2,cource.getUnit());
        return preparedStatement.executeUpdate();
    }
    public int delete(String title)throws SQLException{
        String deleteCourseSql="delete from school_management.public.cource where cource_title=?";
        PreparedStatement preparedStatement=dbConnection.getDatabaseConnection().prepareStatement(deleteCourseSql);
        preparedStatement.setString(1,title);
       return preparedStatement.executeUpdate();
    }
    public int update(String newTitle,String oldTitle)throws SQLException{
        String updateCourseSql ="update school_management.public.cource set cource_title=? where cource_title=?";
        PreparedStatement preparedStatement=dbConnection.getDatabaseConnection().prepareStatement(updateCourseSql);
        preparedStatement.setString(1,newTitle);
        preparedStatement.setString(2,oldTitle);
        int result= preparedStatement.executeUpdate();
        return result;
    }
    public List<Course> getAllCourse()throws SQLException{
        List<Course> courseList=new ArrayList<>();
        String getCourseSql="select * from school_management.public.cource";
       Statement statement= dbConnection.getSqlStatement();
      ResultSet resultSet= statement.executeQuery(getCourseSql);
      while(resultSet.next()){
         courseList.add(new Course(resultSet.getLong(1),resultSet.getString(2),resultSet.getInt(3))) ;
      }
      return courseList;
    }

}
