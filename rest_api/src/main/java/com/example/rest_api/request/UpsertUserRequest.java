package com.example.rest_api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpsertUserRequest {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String avatar;
    private String password;
}
