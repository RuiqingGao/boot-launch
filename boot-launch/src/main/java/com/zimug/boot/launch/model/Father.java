package com.zimug.boot.launch.model;

import lombok.Data;

import javax.validation.constraints.Min;

// 3. 爸爸有名字(name)和年龄（age）两个属性
@Data
public class Father {
    private String name;
    @Min(21)
    private Integer age;
}