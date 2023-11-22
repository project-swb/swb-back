package com.swb.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchCondition {

    private String key = "none";
    private String word;
    private String orderBy = "none";
    private String orderByDir;
    // 1 : 모든 영상
    private int categoryId = 1;
    // videoId는 1부터 시작
    private int videoId = 0;

}
