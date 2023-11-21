package com.swb.service.category;

import com.swb.web.dao.CategoryDao;
import com.swb.web.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<CategoryDto> findAll() {
        return categoryDao.findAll();
    }
}
