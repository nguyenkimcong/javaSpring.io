package com.example.miniproject.database;
import com.example.miniproject.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserFakeDB {
    public static List<User> users = new ArrayList<>(List.of(
            new User(1,"CONG", "NGK123@gmail.com","cong123","avatar"),
            new User (3,"tung", "tung123@gmail.com","tung123","avatar1"),
            new User (5,"manh", "manh123@gmail.com","mann123","avatar2"),
            new User (7,"an", "an123@gmail.com","an123","avatar3")
    ));
}

