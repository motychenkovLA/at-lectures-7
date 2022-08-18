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
    public Client getClientById(int id) throws SQLException {
        Client client = new Client();
        Connection connection = DriverManager.getConnection(USER, LOGIN, PASS);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CLIENTS WHERE ID = " + id);
        ResultSet rs = preparedStatement.executeQuery();
        client.setId(rs.getInt("id"));
        connection.close();
        return client;
    }


    //    метод получения списка клиентов по фамилии/имени //ResultSet
    public Client getClientLastName(int lastName) throws SQLException {
        Client client = new Client();
        Connection connection = DriverManager.getConnection(USER, LOGIN, PASS);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CLIENTS WHERE LAST_NAME = " + lastName);
        ResultSet rs = preparedStatement.executeQuery();
        client.setLastName(rs.getString("last_Name"));
        connection.close();
        return client;
    }


    //    метод добавления клиентских данных(фамилия, имя, возраст) //возвращать кол во апдейтнутых записей  (executeUpdate)
    public static int addClientsData(int Id, String lastName, String firstName, int age) throws SQLException {
        Connection connection = DriverManager.getConnection(USER, LOGIN, PASS);
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        Integer execInt = statement.executeUpdate("INSERT INTO Clients (first_name, last_name, age, id) VALUES ('" + firstName + "','"
                + lastName + "', '" + age + "' ,'" + Id + "'");
        statement.close();
        connection.close();
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
        } return clients;
    }

}
