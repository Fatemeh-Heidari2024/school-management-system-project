package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    public Connection getDatabaseConnection()throws SQLException{
        return DriverManager.getConnection(GlobalProperties.URL,GlobalProperties.USERNAME,GlobalProperties.PASSWORD);
    }

        public Statement getSqlStatement()throws SQLException {
            return getDatabaseConnection().createStatement();
    }
}

