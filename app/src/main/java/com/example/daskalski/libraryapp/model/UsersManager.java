package com.example.daskalski.libraryapp.model;

import java.util.TreeMap;

/**
 * Created by Daskalski on 2/17/16.
 */
public class UsersManager {

    private static UsersManager instance;
    TreeMap<String, String> users = new TreeMap<>();//username -> password

    private UsersManager(){
        users.put("Krasi", "123");
        users.put("Niki", "456");
    }

    public static UsersManager getInstance() {
        if(instance == null)
            instance = new UsersManager();
        return instance;
    }

    public boolean existsUser(String username) {
        return users.containsKey(username);
    }

    public boolean validPass(String user, String pass) {
        if(!users.containsKey(user))
            return false;
        else
            return users.get(user).equals(pass);
    }

    public void add(String user, String pass){
        users.put(user,pass);
    }

}
