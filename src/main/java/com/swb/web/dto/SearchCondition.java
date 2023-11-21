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

}
