package com.swb.service.video;

import com.swb.web.dao.VideoDao;
import com.swb.web.dto.SearchCondition;
import com.swb.web.dto.VideoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;

    @Override
    public void writeVideo(VideoDto video) {
        videoDao.insertVideo(video);
    }

    @Override
    public VideoDto getVideo(int id) {
        videoDao.updateViewCnt(id);
        return videoDao.selectOne(id);
    }

    @Override
    public boolean modifyVideo(VideoDto video) {
        return videoDao.updateVideo(video) > 0;
    }

    @Override
    public boolean removeVideo(int id) {
        return videoDao.deleteVideo(id) == 1;
    }

    @Override
    public void likeVideo(int id) {
        videoDao.updateLikeCnt(id);
    }

    @Override
    public List<VideoDto> search(SearchCondition condition) {
        return videoDao.search(condition);
    }
}
