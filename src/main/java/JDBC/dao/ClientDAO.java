package JDBC.dao;

import JDBC.entities.Client;
import org.checkerframework.checker.units.qual.C;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

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

    //    метод получения клиента по айди  //ResultSet
    public ResultSet getClientById(int id) throws SQLException {
        Connection connection = DriverManager.getConnection(USER, LOGIN, PASS);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CLIENTS WHERE ROW_ID = " + id);
        ResultSet rs = preparedStatement.executeQuery();
        preparedStatement.close();
        return rs;
    }

    //    метод получения списка клиентов по фамилии/имени //ResultSet
    public ResultSet getClientLastName(int lastName) throws SQLException {
        Connection connection = DriverManager.getConnection(USER, LOGIN, PASS);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM S_CONTACT WHERE LAST_NAME = " + lastName);
        ResultSet rs = preparedStatement.executeQuery();
        preparedStatement.close();
        return rs;
    }


    //    метод добавления клиентских данных(фамилия, имя, возраст) //возвращать кол во апдейтнутых записей  (executeUpdate)
    public static int addClientsData(String Id, String lastName, String firstName, int age) throws SQLException {
        Connection connection = DriverManager.getConnection(USER, LOGIN, PASS);
        Statement statement = connection.createStatement();
        Integer execInt = statement
                .executeUpdate("Update Client  set LAST_NAME='" + lastName + "', FIRST_NAME ='" + firstName + "', AGE ='" + age + "' WHERE ID='" + Id + "'");
        statement.close();
        return execInt;
    }

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(USER, LOGIN, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clients");
            // Выполнение запроса
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String firstName = rs.getString("first_Name");
                String lastName = rs.getString("last_Name");
                clients.add(new Client(id, age, firstName, lastName));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return clients;
    }

}
