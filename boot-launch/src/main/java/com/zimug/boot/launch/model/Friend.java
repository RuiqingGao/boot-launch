package com.zimug.boot.launch.model;

import lombok.Data;

//  6. 每个friend有两个属性：hobby(爱好)和性别(sex)
@Data
public class Friend {
    private String hobby;
    private String sex;
}