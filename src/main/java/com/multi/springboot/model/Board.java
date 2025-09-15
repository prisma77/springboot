package com.multi.springboot.model;

import lombok.Data;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Board {
    private int id;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime createdAt;
    private int views;
    // createdAt을 "yyyy-MM-dd HH:mm" 형식 문자열로 반환 (null이면 빈 문자열
    public String getCreatedAtStr() {
        return (createdAt == null)
                ? ""
                : createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}