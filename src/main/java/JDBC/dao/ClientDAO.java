package JDBC.dao;

import JDBC.entities.Client;

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

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(USER, LOGIN, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clients");

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String firstName = rs.getString("first_Name");
                String lastName = rs.getString("last_Name");
                clients.add(new Client(id, age, firstName, lastName));

                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return clients;
    }

    public Client getClientId(int id) throws SQLException {
        Connection connection = DriverManager.getConnection(USER, LOGIN, PASS);
        PreparedStatement pr = connection
                .prepareStatement("SELECT * FROM clients " + "WHERE id = ?");
        pr.setString(1, String.valueOf(id));
        ResultSet result = pr.executeQuery();

        int age = result.getInt("age");
        String firstName = result.getString("first_Name");
        String lastName = result.getString("last_Name");
        Client client = new Client(id, age, firstName, lastName);

        pr.close();
        connection.close();

        return client;
    }

    public List<Client> getFirstNameAndLastNameClients() {
        List<Client> cl = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(USER, LOGIN, PASS);
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM clients " + "WHERE first_name = ? AND Last_name = ?");
            preparedStatement.setString(1, "Ivan");
            preparedStatement.setString(2, "Ivanov");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String firstName = rs.getString("first_Name");
                String lastName = rs.getString("last_Name");
                cl.add(new Client(id, age, firstName, lastName));

                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cl;
    }

    public int getCountRequest(int id, String firstName, String lastName, int age) {
        int count = 0;

        try {
            Connection connection = DriverManager.getConnection(USER, LOGIN, PASS);
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE clients SET " + "first_name = ?, last_name = ?, age = ? " + "WHERE id = ?");
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            preparedStatement.setString(3,String.valueOf(age);
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
}
