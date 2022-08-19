package JDBC;

import JDBC.dao.ClientDAO;
import JDBC.entities.Client;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ClientDAO dao = new ClientDAO();
        String URL = "jdbc:mysql://localhost:3306/users";
        String USER = "root";
        String PASS = "root";

        String FirstName = "Ivanov";
        int id = 7;

        //1 вариант регистрации драйвера
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //дефолтная загрузка класса

        } catch (ClassNotFoundException e) {
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
//            Connection connection = DriverManager.getConnection(URL, USER, PASS);

//           Statement statement = connection.createStatement();
//        //PrepareStatement совершает "прекомпил" запроса исключая скл-иньекций,
//        //позволяет легко добавлять не самые удобные типы данных, такие как даты и тд
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clients " +
//                    "WHERE first_name = ?");
//            preparedStatement.setString(1, "Ivan");
//
//            CallableStatement callableStatement = connection.prepareCall("{call dbFunction}");


//           Statement statement = connection.createStatement();
////
////            Boolean execBoo = statement.execute("");
////            Integer execInt = statement.executeUpdate("");
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


//// наполнение бд
//            connection.setAutoCommit(false);
//            Statement statement = connection.createStatement();
//
//            String SQL = "INSERT INTO clients (first_name, last_name, age) VALUES ('Ivanov', 'test1', 1)";
//            statement.addBatch(SQL);
//            SQL = "INSERT INTO clients (first_name, last_name, age) VALUES ('Petrov', 'Ivanov', 17)";
//            statement.addBatch(SQL);
//            SQL = "INSERT INTO clients (first_name, last_name, age) VALUES ('ivanov', 'Petr', 154)";
//            statement.addBatch(SQL);
//            SQL = "INSERT INTO clients (first_name, last_name, age) VALUES ('Ivan', 'Petr', 28)";
//            statement.addBatch(SQL);
//
//            statement.executeBatch();
//            connection.commit();
//
//

        System.out.println(dao.addClient("Name1", "Name2",22));
        List<Client> searchByFirstNameResult = dao.getClientByFirstName(FirstName);
        List<Client> searchByIdResult = dao.getClientById(id);
        if (searchByFirstNameResult.isEmpty()) {
            System.out.println("нет таких клиентов");
        } else {
            System.out.println("FirstName = "+FirstName+":");
            for (Client cl : searchByFirstNameResult) {
                showClient(cl);
            }
        }
        if (searchByIdResult.isEmpty()) {

            System.out.println("нет таких клиентов");
        } else {
            System.out.println("ID = "+id+":");
            for (Client cl : searchByIdResult) {
                showClient(cl);
            }
        }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        //showTable(URL, USER, PASS); //вывод всей таблицы clients

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

    public static void showTable(String URL, String USER, String PASS) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM clients");
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append("ID: ").append(rs.getInt("id")).append("; ")
                        .append("Age: ").append(rs.getInt("age")).append("; ")
                        .append("LastName: ").append(rs.getString("last_name")).append("; ")
                        .append("FirstName: ").append(rs.getString("first_name")).append("; ")
                        .append("\n");
            }
            System.out.println(sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showClient(Client client) {
        System.out.println(client.getId() + "; " + client.getFirstName() + "; " + client.getLastName() + "; " + client.getAge());
    }
}
