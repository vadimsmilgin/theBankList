package app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/example";
    static final String USER = "root";
    static final String PASSWORD = "esc.pro1009117";

    public String getUserInformation (int id) {
        String sqlGetConcreteUser = "select * from user where userid = " + id;
        String result = null;

        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlGetConcreteUser);

            while(resultSet.next()){
                result = resultSet.getString(1) + " "
                        + resultSet.getString(2) + " "
                        + resultSet.getString(3);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List getListOfAccounts () {
        String sqlGetConcreteUser = "select * from account";
        List<String> listOfAccounts = new ArrayList<String>();

        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlGetConcreteUser);

            while(resultSet.next()){
                listOfAccounts.add(String.valueOf(resultSet.getInt(1)) + " "
                        + String.valueOf(resultSet.getInt(2)) + " "
                        + String.valueOf(resultSet.getInt(3)));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOfAccounts;
    }

    public String getTheRichestUser () {
        String getTheRichestUser = "select concat(u.name,' ',u.sureName) as fullName from user u " +
                "join account a on u.userid = a.userid " +
                "where account = (select max(account) from account);";
        String result = null;

        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(getTheRichestUser);

            while(resultSet.next()){
                result = resultSet.getString(1);

            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public String getSumOfAccounts () {
        String getTheRichestUser = "select sum(account) from account;";
        String result = null;

        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(getTheRichestUser);

            while(resultSet.next()){
                result = resultSet.getString(1);

            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}

