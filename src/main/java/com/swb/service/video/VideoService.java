package com.swb.service.video;

import com.swb.web.dto.SearchCondition;
import com.swb.web.dto.VideoDto;

import java.util.List;

public interface VideoService {

    // 게시글 등록
    void writeVideo(VideoDto video);

    // 게시글 상세 조회
    VideoDto getVideo(int id);

    // 게시글 수정
    boolean modifyVideo(VideoDto video);

    // 게시글 삭제
    boolean removeVideo(int id);

    // 좋아요 기능
    void likeVideo(int id);

    // 검색 버튼 눌렀을 때 및 기본적으로 영상 화면에 나타낼 메서드
    List<VideoDto> search(SearchCondition condition);

}
