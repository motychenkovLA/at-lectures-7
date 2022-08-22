package JDBC.dao;

import JDBC.entities.Client;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    //реализовать:
//    метод получения клиента по айди  //ResultSet
//    метод получения списка клиентов по фамилии/имени //ResultSet
//    метод добавления клиентских данных(фамилия, имя, возраст) //возвращать кол во апдейтнутых записей  (executeUpdate)

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


    public static int addClient(Client client) {
        int rows = 0;
        try {
            Connection connection = DriverManager.getConnection(USER, LOGIN, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(id, age, " +
                    "firstname, lastname) VALUES (?, ?, ?, ?)");
            // Выполнение запроса
            preparedStatement.setInt(1, client.getId());
            preparedStatement.setInt(2, client.getAge());
            preparedStatement.setString(3, client.getFirstName());
            preparedStatement.setString(4, client.getLastName());

            rows = preparedStatement.executeUpdate();

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }


    public Client getClientById(int id) {
        Client client = null;
        try {
            Connection connection = DriverManager.getConnection(USER, LOGIN, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users where id = ?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            int userId = resultSet.getInt("id");
            int userAge = resultSet.getInt("age");
            String userFirstName = resultSet.getString("first_name");
            String userLastName = resultSet.getString("last_name");
            client = new Client(userId, userAge, userFirstName, userLastName);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public Client getClientByNameAndSurname(String name, String surname) {
        Client client = null;
        try {
            Connection connection = DriverManager.getConnection(USER, LOGIN, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users" +
                    "where first_name = ? " +
                    "AND last_name = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(1, surname);

            ResultSet resultSet = preparedStatement.executeQuery();
            int userId = resultSet.getInt("id");
            int userAge = resultSet.getInt("age");
            String userFirstName = resultSet.getString("first_name");
            String userLastName = resultSet.getString("last_name");
            client = new Client(userId, userAge, userFirstName, userLastName);
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

     public List<Client> getAllClients(){
        List<Client> clients = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection( USER,LOGIN, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clients");
            // Выполнение запроса
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
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
