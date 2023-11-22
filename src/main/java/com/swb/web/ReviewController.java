package com.swb.web;

import com.swb.service.review.ReviewService;
import com.swb.web.dto.ReviewDto;
import com.swb.web.dto.SearchCondition;
import com.swb.web.dto.VideoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 1. List
    @GetMapping("/reviews")
    public ResponseEntity<?> list(SearchCondition condition) {

        List<ReviewDto> list = reviewService.search(condition);

        if (list == null || list.isEmpty())
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<ReviewDto>>(list, HttpStatus.OK);
    }

    // 2. 상세보기
    @GetMapping("/reviews/{id}")
    public ResponseEntity<ReviewDto> detail(@PathVariable int id) {
        ReviewDto review = reviewService.getReview(id);
        if (review != null)
            return new ResponseEntity<ReviewDto>(review, HttpStatus.OK);
        return new ResponseEntity<ReviewDto>(HttpStatus.NOT_FOUND);
    }

    // 3. 등록
    @PostMapping("/reviews")
    public ResponseEntity<ReviewDto> write(@RequestBody ReviewDto review) {
        reviewService.writeReview(review);
        return new ResponseEntity<ReviewDto>(review, HttpStatus.CREATED);
    }

    // 4. 삭제
    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        if (reviewService.removeReview(id))
            return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        return new ResponseEntity<String>("FAIL", HttpStatus.NOT_FOUND);
    }

    // 5. 수정
    @PutMapping("/reviews")
    public ResponseEntity<String> update(@RequestBody ReviewDto review) {
        if (reviewService.modifyReview(review))
            return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        return new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
    }

    // 6. 좋아요
    @PutMapping("/reviews/{id}")
    public ResponseEntity<String> like(@PathVariable int id) {
        reviewService.likeReview(id);
        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    }

}
