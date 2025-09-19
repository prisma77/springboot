package com.multi.springboot.model;

import lombok.Data;

@Data
public class Comment {
    private int id;
    private  String content;
    private String createdAt;

}