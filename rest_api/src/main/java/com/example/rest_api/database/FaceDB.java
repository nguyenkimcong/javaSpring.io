package com.example.rest_api.database;

import com.example.rest_api.model.User;

import java.util.ArrayList;
import java.util.List;

public class FaceDB {
    public static List<User> users =new ArrayList<>(List.of(
new User(1 , "nguyenkimcong","nkc123@gmail.com", "0986851578", "DB" ,"null" ,"123"),
new User(2 , "nguyenkimB","nkB122@gmail.com", "0986851123", "HN" ,"null","345"),
new User(3 , "nguyenkimD","nkD121@gmail.com", "0986821321", "HCM" ,"null","456"),
 new User(4 , "nguyenkimE","nkE111@gmail.com", "098684421", "HP" ,"null","567")
            ));

}
