package repository;

import dto.EnrollmentDTO;
import model.Student;
import util.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class StudentRepository {
    /* language=sql */
    DBConnection DB =new DBConnection();

    String sql="select * from school_management.public.student order by first_name desc";
    String sql1="select count(student_id) as c from school_management.public.student";
    public List< Student > getAllStudent() throws SQLException{
        ResultSet resultSet= DB.getSqlStatement().executeQuery(sql);
        List<Student> students=new ArrayList<>();
        while (resultSet.next()){
            Student student= new Student(resultSet.getInt("student_id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("national_code"),
                    resultSet.getDate("dob").toLocalDate(),
                    resultSet.getDouble("gpu"));
            students.add(student);
        }
        return students;
    }

    public int getCountOfStudent() throws SQLException {

        ResultSet resultSet=DB.getSqlStatement().executeQuery(sql1);
        int counts=0;
        while (resultSet.next()){
                    counts=resultSet.getInt("c");
        }
        return counts;
    }

    public void addStudent(Student student) throws SQLException{
            DBConnection dbConnection = new DBConnection();
           // System.out.println("connection to DB successfully");
            String sql = " insert into school_management.public.student(first_name, last_name, national_code, dob,gpu) values(?,?,?,?,?)";
            PreparedStatement preparedStatement =dbConnection.getDatabaseConnection().prepareStatement(sql,1);
          preparedStatement.setString(1,student.getFirstName());
          preparedStatement.setString(2,student.getLastName());
          preparedStatement.setString(3,student.getNationalCode());
          preparedStatement.setDate(4, Date.valueOf(student.getDataOfBirth()));
          preparedStatement.setDouble(5,student.getGpu());
          preparedStatement.executeUpdate();
    }

    public List< EnrollmentDTO > enrollment() throws SQLException {
      String sql= "select s.first_name,s.last_name,c.cource_title from school_management.public.student as s " +
              "join school_management.public.enrollments as e on s.student_id=e.student_id " +
              "join school_management.public.cource as c on e.cource_id = c.cource_id";
      ResultSet resultSet=DB.getSqlStatement().executeQuery(sql);
        ArrayList< EnrollmentDTO > objects = new ArrayList<>();
        while (resultSet.next()){
          objects.add(new EnrollmentDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
      }
        return objects;
    }
public List<Student> getStudentByFirstName(String first_name)throws SQLException{

    String sql= "select * from school_management.public.student where first_name=? ";
    PreparedStatement preparedStatement=DB.getDatabaseConnection().prepareStatement(sql);
    preparedStatement.setString(1,first_name);
    ResultSet resultSet=preparedStatement.executeQuery();
    List<Student> students=new ArrayList<>();
    while(resultSet.next()){
        students.add(new Student(resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getDate(5).toLocalDate(),
                resultSet.getDouble(6)));
    }
    return students;
}

public int updateStudent(String oldFirstName,String newFirstName)throws SQLException{
    /* language=sql */
        String updateSql="update school_management.public.student set first_name=? where first_name=?";
        PreparedStatement preparedStatement=DB.getDatabaseConnection().prepareStatement(updateSql);
        preparedStatement.setString(1,newFirstName);
        preparedStatement.setString(2,oldFirstName);
        int result=preparedStatement.executeUpdate();
        return result;
}
public int deleteStudent(String natCode) throws SQLException{
    /* language=sql */
        String deleteQuery="delete from school_management.public.student where national_code=?";
        PreparedStatement preparedStatement=DB.getDatabaseConnection().prepareStatement(deleteQuery);
        preparedStatement.setString(1,natCode);
       return preparedStatement.executeUpdate();
       
}

public Student findById(long id)throws SQLException{
        String findSql="select * from school_management.public.student where student_id=?";
        PreparedStatement preparedStatement=DB.getDatabaseConnection().prepareStatement(findSql);
        preparedStatement.setLong(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            return new Student(resultSet.getLong(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDate(5).toLocalDate(),
                    resultSet.getDouble(6));
        }
        return null;
}

}
