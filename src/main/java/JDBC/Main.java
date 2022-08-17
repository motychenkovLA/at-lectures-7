package JDBC;

import JDBC.dao.ClientDAO;
import JDBC.entities.Client;


import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args){

        String URL = "jdbc:mysql://localhost:3306/users";
        String USER = "root";
        String PASS = "root";

        Connection connection = null;
        PreparedStatement preparedStatement = null;


        //1 вариант регистрации драйвера
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //дефолтная загрузка класса

            System.out.println("Подключение к базе");
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Подключение удалось");


            ClientDAO.addClient(1, 15, "Ivanov", "Petr");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //2 вариант регистрации драйвера
//        try {
//            Driver driver = new com.mysql.cj.jdbc.Driver();
//            DriverManager.registerDriver(driver);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        try {
         //   Connection connection = DriverManager.getConnection(URL, USER, PASS);

//           Statement statement = connection.createStatement();
//        //PrepareStatement совершает "прекомпил" запроса исключая скл-иньекций,
//        //позволяет легко добавлять не самые удобные типы данных, такие как даты и тд
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clients " +
//                    "WHERE first_name = ?");
//            preparedStatement.setString(1, "Ivan");
//
//            CallableStatement callableStatement = connection.prepareCall("{call dbFunction}");






//           Statement statement = connection.createStatement();
//
//            Boolean execBoo = statement.execute("");
//            Integer execInt = statement.executeUpdate("");
//            ResultSet rs = statement.executeQuery("SELECT * FROM clients");
//
//            StringBuilder sb = new StringBuilder();
//
//            while (rs.next()){
//                sb.append("ID: ").append(rs.getInt("id")).append("; ")
//                        .append("Age: ").append(rs.getInt("age")).append("; ")
//                        .append("LastName: ").append(rs.getString("last_name")).append("; ")
//                        .append("FirstName: ").append(rs.getString("first_name")).append("; ")
//                        .append("\n");
//            }
//
//            System.out.println(sb.toString());

//            connection.setAutoCommit(false);
//            Savepoint currentSavepoint = connection.setSavepoint();
//            try {
//                System.out.println(connection.createStatement().executeUpdate("INSERT INTO clients" +
//                        "(first_name, last_name, age) VALUES ('Ivan', 'Ivanov', 35)"));
//                connection.commit();
//
//            } catch (SQLException e) {
//                connection.rollback(currentSavepoint);
//                e.printStackTrace();
//            }



//            connection.setAutoCommit(false);
//            Statement statement = connection.createStatement();
//
//            String SQL = "INSERT INTO clients (first_name, last_name, age) VALUES ('test1', 'test1', 44)";
//            statement.addBatch(SQL);
//            SQL = "INSERT INTO clients (first_name, last_name, age) VALUES ('test2', 'test2', 44)";
//            statement.addBatch(SQL);
//            SQL = "INSERT INTO clients (first_name, last_name, age) VALUES ('test1', 'test3', 44)";
//            statement.addBatch(SQL);
//
//            statement.executeBatch();
//            connection.commit();

//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        List<Client> clients = new ClientDAO().getAllClients();
//
//
//        for (int i = 0; i < clients.size(); i++) {
//            System.out.print("ID: " + clients.get(i).getId() + " ");
//            System.out.print("AGE: " + clients.get(i).getAge() + " ");
//            System.out.print("FIRST NAME: " + clients.get(i).getFirstName() + " ");
//            System.out.print("LAST NAME : " + clients.get(i).getLastName() + '\n');
//        }
    }
}
