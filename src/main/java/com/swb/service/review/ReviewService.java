package com.swb.service.review;

import com.swb.web.dto.SearchCondition;
import com.swb.web.dto.ReviewDto;

import java.util.List;


public interface ReviewService {

    // 게시글 등록
    void writeReview(ReviewDto review);

    // 게시글 상세 조회
    ReviewDto getReview(int id);

    // 게시글 수정
    boolean modifyReview(ReviewDto review);

    // 게시글 삭제
    boolean removeReview(int id);

    // 좋아요 기능
    void likeReview(int id);

    // 검색 버튼 눌렀을 때 및 기본적으로 영상 화면에 나타낼 메서드
    List<ReviewDto> search(SearchCondition condition);

}
