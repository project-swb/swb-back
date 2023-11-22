package com.swb.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewDto {

    private int reviewId;
    private int videoId;
    private int userId;
    private int categoryId;
    private String title;
    private String writer;
    private String regDate;
    private int viewCnt;
    private int likeCnt;
    private String contents;

}
