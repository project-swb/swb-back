package com.swb.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoDto {
    private int videoId;
    private int userId;
    private int categoryId;
    private String title;
    private String writer;
    private String regDate;
    private int viewCnt;
    private int likeCnt;
    private String thumbnail;
    private String url;

    public VideoDto(int videoId, int userId, int categoryId, String title, String writer, String regDate, int viewCnt, int likeCnt, String thumbnail, String url) {
        this.videoId = videoId;
        this.userId = userId;
        this.categoryId = categoryId;
        this.title = title;
        this.writer = writer;
        this.regDate = regDate;
        this.viewCnt = viewCnt;
        this.likeCnt = likeCnt;
        this.thumbnail = thumbnail;
        this.url = url;
    }

    public VideoDto(int userId, int categoryId, String title, String writer, String thumbnail, String url) {
        super();
        this.userId = userId;
        this.categoryId = categoryId;
        this.title = title;
        this.writer = writer;
        this.thumbnail = thumbnail;
        this.url = url;
    }

    public VideoDto(String title, String writer, int viewCnt, int likeCnt) {
        this.title = title;
        this.writer = writer;
        this.viewCnt = viewCnt;
        this.likeCnt = likeCnt;
    }

    public VideoDto() {

    }


}
