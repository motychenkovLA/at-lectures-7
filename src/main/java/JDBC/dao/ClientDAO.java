package JDBC.dao;

import JDBC.entities.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    private static String URL = "jdbc:mysql://localhost:3306/users";
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


    //    Метод получения клиента по id  (ResultSet)
    public Client getClientById(int id) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, LOGIN, PASS);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clients " + "WHERE id = ?");
        preparedStatement.setString(1, String.valueOf(id));
        ResultSet rs = preparedStatement.executeQuery();

        int age = rs.getInt("age");
        String firstName = rs.getString("first_Name");
        String lastName = rs.getString("last_Name");
        Client client = new Client(id, age, firstName, lastName);

        preparedStatement.close();
        connection.close();
        return client;
    }


    //    Метод получения списка клиентов по фамилии/имени (ResultSet)
    public List<Client> getFioClients() {
        List<Client> client = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, LOGIN, PASS);
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM clients " + "WHERE first_name = ? AND Last_name = ?");
            preparedStatement.setString(1, "Petr");
            preparedStatement.setString(2, "Petrov");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String firstName = resultSet.getString("first_Name");
                String lastName = resultSet.getString("last_Name");
                client.add(new Client(id, age, firstName, lastName));

                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }


    //  Метод добавления клиентских данных(фамилия, имя, возраст) // Возвращать кол-во обновл. записей  (executeUpdate)
    public int getCountRequest(int id, String firstName, String lastName, int age) {
        int count = 0;
        try {
            Connection connection = DriverManager.getConnection(URL, LOGIN, PASS);
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO clients (firstName, " +
                            "lastName, age, id) Values (?, ?, ?, ?)");
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            preparedStatement.setString(3,String.valueOf(age));
            preparedStatement.setString(4,String.valueOf(id));
            count = preparedStatement.executeUpdate();

            connection.commit();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, LOGIN, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clients");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String firstName = resultSet.getString("first_Name");
                String lastName = resultSet.getString("last_Name");
                clients.add(new Client(id, age, firstName, lastName));

                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return clients;

    }
}
