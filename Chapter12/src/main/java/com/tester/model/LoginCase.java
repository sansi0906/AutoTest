package com.tester.model;

import lombok.Data;

@Data
public class LoginCase {
    private int id ;
    private String userName;
    private String passWord;
    private String expected;
}
