package com.example.rest_api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class UpsertPasswordRequest {
    private String oldPassword;
    private String newPassword;
}