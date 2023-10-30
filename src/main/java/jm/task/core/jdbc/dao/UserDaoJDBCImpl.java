package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }
    public void createUsersTable() {
        try (Connection connection = Util.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "id BIGINT NOT NULL AUTO_INCREMENT," +
                    "name VARCHAR(45) NOT NULL," +
                    "lastName VARCHAR(45) NOT NULL," +
                    "age TINYINT NOT NULL," +
                    "PRIMARY KEY (id))");

            System.out.println("Таблица успешно создана");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Connection connection = Util.getConnection(); Statement statement = connection.createStatement()){
            statement.execute("DROP TABLE IF EXISTS users");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO users( name, lastName, age) VALUES ( ?, ?, ?)";
        try (Connection connection = Util.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            int count = preparedStatement.executeUpdate();
            if(count>0) {
                System.out.println("User с именем – " + name + " добавлен в базу данных");
            }
            else {
                System.out.println("Произошла ошибка по добавлению ");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removeUserById(long id) {
        try (Connection connection = Util.getConnection()){
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println("Запись  успешно удалена из таблицы ");
            } else {
                System.out.println("Ошибка: Запись не была удалена из таблицы.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        try (Statement statement = Util.getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                byte age = resultSet.getByte("age");

                User user = new User(name, lastName, age);
                userList.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Не удалось получить данные");
        }
        return userList;
    }

    public void cleanUsersTable() {
        try(Connection connection = Util.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute("DELETE FROM Users");
            System.out.println("Успешная очистка");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
