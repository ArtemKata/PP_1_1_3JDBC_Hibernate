package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {



    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("fgd", "EFfd", (byte) 20);
        userService.saveUser("Dsgs", "EFfsd", (byte) 20);
        userService.saveUser("Dsfsf", "EFasfd", (byte) 20);
        userService.saveUser("DSfgjfh", "EFsdgsgg", (byte) 20);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();


    }

}

