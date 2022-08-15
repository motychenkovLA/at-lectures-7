package JDBC.helpers;

import java.sql.*;

public class JBDCExecutor {
    private static String USER = "jdbc:mysql://localhost:3306/users";
    private static String LOGIN = "root";
    private static String PASS = "root";
    private static final String driverClassName = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int executeUpdate(String sqlQuery){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Savepoint currentSavepoint = null;
        int returnInt = 0;

        try {
            connection = DriverManager.getConnection(USER, LOGIN, PASS);
            preparedStatement = connection.prepareStatement(sqlQuery);

            connection.setAutoCommit(false);
            currentSavepoint = connection.setSavepoint();

            returnInt = preparedStatement.executeUpdate();
            connection.commit();

            preparedStatement.close();

        } catch (SQLException e) {

            try {
                connection.rollback(currentSavepoint);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException | NullPointerException throwables) {
                throwables.printStackTrace();
            }finally {
                return returnInt;
            }
        }
    }
}
