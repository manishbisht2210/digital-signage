package com.makeathon.outliers.scheduleservice.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class User {
    private String name;
    private String type = "user";

    public User(String name) {
        this.name = "User:" + name;
    }
}
