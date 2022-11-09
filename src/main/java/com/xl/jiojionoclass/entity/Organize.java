package com.xl.jiojionoclass.entity;

import lombok.Data;

@Data
public class Organize {

    private Long	id;

    private Long	organizeAdminId;

    private String	organizeName;

    private String	organizeBrief;

    private Integer	semesterId;
}
