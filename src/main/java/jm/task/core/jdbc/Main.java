package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    private static final UserServiceImpl userService = new UserServiceImpl();
    public static void main(String[] args) {
        userService.createUsersTable();
        userService.saveUser("Pivo_first", "Kozel", (byte) 20);
        userService.saveUser("Pivo_second", "Baltika", (byte) 21);
        userService.saveUser("Pivo_third", "Korona", (byte) 22);
        userService.saveUser("Pivo_fourth", "Goose", (byte) 23);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();










    }
}
