package com.swb.web;

import com.swb.service.video.VideoService;
import com.swb.web.dto.SearchCondition;
import com.swb.web.dto.VideoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class VideoController {

    @Autowired
    private VideoService videoService;

    // 1. List
    @GetMapping("/videos")
    public ResponseEntity<?> list(SearchCondition condition) {

        List<VideoDto> list = videoService.search(condition);

        if (list == null || list.isEmpty())
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<VideoDto>>(list, HttpStatus.OK);
    }

    // 2. 상세보기
    @GetMapping("/videos/{id}")
    public ResponseEntity<VideoDto> detail(@PathVariable int id) {
        VideoDto video = videoService.getVideo(id);
        if (video != null)
            return new ResponseEntity<VideoDto>(video, HttpStatus.OK);
        return new ResponseEntity<VideoDto>(HttpStatus.NOT_FOUND);
    }

    // 3. 등록
    @PostMapping("/videos")
    public ResponseEntity<VideoDto> write(@RequestBody VideoDto video) {
        videoService.writeVideo(video);
        return new ResponseEntity<VideoDto>(video, HttpStatus.CREATED);
    }

    // 4. 삭제
    @DeleteMapping("/videos/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        if (videoService.removeVideo(id))
            return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        return new ResponseEntity<String>("FAIL", HttpStatus.NOT_FOUND);
    }

    // 5. 수정
    @PutMapping("/videos")
    public ResponseEntity<String> update(@RequestBody VideoDto video) {
        if (videoService.modifyVideo(video))
            return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        return new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
    }

    // 6. 좋아요
    @PutMapping("/videos/{id}")
    public ResponseEntity<String> like(@PathVariable int id) {
        videoService.likeVideo(id);
        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    }

}
