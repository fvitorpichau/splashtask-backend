package com.splash.task.dto;


import lombok.Data;

@Data
public class BookmarkDTO {

    private Long id;

    private String name;

    private String url;

    private byte[] profileImage;

}