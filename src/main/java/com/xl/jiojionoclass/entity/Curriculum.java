package com.xl.jiojionoclass.entity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Curriculum {
    private Integer semesterId;
    private Long userId;
    private String classSchedule;
    private Long organizeId;
    private String name;
}
