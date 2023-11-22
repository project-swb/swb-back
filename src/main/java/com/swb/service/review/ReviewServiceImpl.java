package com.swb.service.review;



import com.swb.web.dao.ReviewDao;
import com.swb.web.dto.ReviewDto;
import com.swb.web.dto.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDao reviewDao;

    @Override
    public void writeReview(ReviewDto review) {
        reviewDao.insertReview(review);
    }

    @Override
    public ReviewDto getReview(int id) {
        reviewDao.updateViewCnt(id);
        return reviewDao.selectOne(id);
    }

    @Override
    public boolean modifyReview(ReviewDto review) {
        return reviewDao.updateReview(review) > 0;
    }

    @Override
    public boolean removeReview(int id) {
        return reviewDao.deleteReview(id) == 1;
    }

    @Override
    public void likeReview(int id) {
        reviewDao.updateLikeCnt(id);
    }

    @Override
    public List<ReviewDto> search(SearchCondition condition) {
        return reviewDao.search(condition);
    }
}
