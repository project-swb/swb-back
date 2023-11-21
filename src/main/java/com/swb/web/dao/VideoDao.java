package com.swb.web.dao;

import com.swb.web.dto.SearchCondition;
import com.swb.web.dto.VideoDto;

import java.util.List;

public interface VideoDao {

    // id에 해당하는 비디오 정보
    public VideoDto selectOne(int id);

    // 게시글 등록
    public void insertVideo(VideoDto video);

    // 게시글 삭제
    public int deleteVideo(int id);

    // 게시글 수정
    public int updateVideo(VideoDto video);

    // 조회수 증가
    public void updateViewCnt(int id);

    // 좋아요
    public void updateLikeCnt(int id);

    // 검색 기능
    public List<VideoDto> search(SearchCondition condition);

}
