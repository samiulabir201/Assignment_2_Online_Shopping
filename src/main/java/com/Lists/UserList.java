package com.Lists;

import java.util.Arrays;
import java.util.List;


public class UserList {
    public static int userID;
    public static int userCart;
    public String userName;
    public String password;
    public static List<UserList> userList = Arrays.asList(
            new UserList(1,"Abir","180041221"),
            new UserList(2,"Sajid","180041203"),
            new UserList(3,"Sartaj","180041204"),
            new UserList(4,"Minhaz","180041231")
    );

    public UserList(int userID, String userName, String password) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
    }

    public UserList(){}
}








