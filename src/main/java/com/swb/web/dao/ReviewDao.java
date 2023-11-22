package com.swb.web.dao;

import com.swb.web.dto.ReviewDto;
import com.swb.web.dto.SearchCondition;

import java.util.List;

public interface ReviewDao {

    public ReviewDto selectOne(int id);
    // CUD는 테이블이 변경됨 -> mybatis에서는 처리할 때 변경된 행의 개수를 반환한다
    // int로 받으면 행의 개수를 사용할 수 있다.
    public void insertReview(ReviewDto review);
    public int deleteReview(int id);
    public int updateReview(ReviewDto review);
    public void updateViewCnt(int id);
    public void updateLikeCnt(int id);
    public List<ReviewDto> search(SearchCondition condition);

}
