package com.zimug.boot.launch.model;

import lombok.Data;

import java.util.List;

//5. 孩子除了名字(name)和年龄（age）两个属性，还有一个friends的集合
@Data
public class Child {
    private String name;
    private Integer age;
    private List<Friend> friends;
}