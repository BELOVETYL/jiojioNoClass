package com.xl.jiojionoclass.entity;
import lombok.Data;

@Data
public class User {
    private Long	id;
    private String	email;
    private String	password;
    private Long	associationId;
    private String  name;
}
