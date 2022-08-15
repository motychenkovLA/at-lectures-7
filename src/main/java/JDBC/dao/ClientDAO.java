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

        } catch (SQLException e) {
            e.printStackTrace();
        } return clients;
    }


    public Client getClientById(int clientId){
        Client client = new Client();
        try {
            Connection connection = DriverManager.getConnection(USER,LOGIN, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clients WHERE id = ?");
            preparedStatement.setString(1, String.valueOf(clientId));
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String firstName = rs.getString("first_Name");
                String lastName = rs.getString("last_Name");
                client = new Client(id, age, firstName, lastName);

                rs.close();
                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return client;
    }


    public List<Client> getListOfClientsByFI(String clientLastName, String clientFirstName){
        List<Client> clients = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(USER,LOGIN, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clients WHERE " +
                    "firstName = ? OR WHERE lastName = ?");
            preparedStatement.setString(1, clientFirstName);
            preparedStatement.setString(2, clientLastName);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String firstName = rs.getString("first_Name");
                String lastName = rs.getString("last_Name");
                clients.add(new Client(id, age, firstName, lastName));

                rs.close();
                preparedStatement.close();
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } return clients;

    }


    public int getClientById(Client client){
        int result = 0;
        try {
            Connection connection = DriverManager.getConnection(USER,LOGIN, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO clients (firstName, " +
                    "lastName, age) Values (?, ?, ?)");
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, client.getAge());

            result = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } return result;


    }

}
