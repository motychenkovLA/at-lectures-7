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
