package JDBC;

import JDBC.dao.ClientDAO;
import JDBC.entities.Client;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        String URL = "jdbc:mysql://localhost:3306/users";
        String USER = "root";
        String PASS = "root";

        //1 вариант регистрации драйвера
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //дефолтная загрузка класса

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //2 вариант регистрации драйвера:
//        try {
//            Driver driver = new com.mysql.cj.jdbc.Driver();
//            DriverManager.registerDriver(driver);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//-------------------------------------------------------------------

        //Стейтманы:

//        Connection connection = DriverManager.getConnection(URL, USER, PASS);

//        Statement statement = connection.createStatement();
//        PrepareStatement совершает "прекомпил" запроса исключая скл-иньекций,
//        позволяет легко добавлять не самые удобные типы данных, такие как даты и тд

//        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clients " +
//                "WHERE first_name = ?");
//        preparedStatement.setString(1, "Ivan");

//        CallableStatement callableStatement = connection.prepareCall("{call dbFunction}");

//-------------------------------------------------------------------------------------------

        //Методы для обращения к БД

//                - execute() возвращает true/fails
//                - executeUpdate() возвращает количество count отработаных запросов
//                - executeQuery() возвращает результат запроса из БД

//            Statement statement = connection.createStatement();

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

//------------------------------------------------------------------------------------

        //Отключение авто коммита и вклю в ручную:

//            connection.setAutoCommit(false);
//            Savepoint currentSavepoint = connection.setSavepoint(); - откат до начала запроса, при вознекновении ошибки rollback(currentSavepoint)
//            try {
//                System.out.println(connection.createStatement().executeUpdate("INSERT INTO clients" +
//                        "(first_name, last_name, age) VALUES ('Ivan', 'Ivanov', 35)"));
//                connection.commit();
//
//            } catch (SQLException e) {
//                connection.rollback(currentSavepoint);
//                e.printStackTrace();
//            }

//--------------------------------------------------------------

        //Пакеты:

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

        List<Client> clients = new ClientDAO().getAllClients();


        for (int i = 0; i < clients.size(); i++) {
            System.out.print("ID: " + clients.get(i).getId() + " ");
            System.out.print("AGE: " + clients.get(i).getAge() + " ");
            System.out.print("FIRST NAME: " + clients.get(i).getFirstName() + " ");
            System.out.print("LAST NAME : " + clients.get(i).getLastName() + '\n');
        }

        Client client = new ClientDAO().getClientById(10);
        System.out.print("ID: " + client.getId() + " ");
        System.out.print("AGE: " + client.getAge() + " ");
        System.out.print("FIRST NAME: " + client.getFirstName() + " ");
        System.out.print("LAST NAME : " + client.getLastName() + '\n');


        List<Client> cl = new ClientDAO().getFioClients();
        for (int i = 0; i < cl.size(); i++) {
            System.out.print("ID: " + cl.get(i).getId() + " ");
            System.out.print("AGE: " + cl.get(i).getAge() + " ");
            System.out.print("FIRST NAME: " + cl.get(i).getFirstName() + " ");
            System.out.print("LAST NAME : " + cl.get(i).getLastName() + '\n');
        }

        System.out.println(new ClientDAO().getCountRequest(2, "Petr", "Petrov", 27));

    }
}