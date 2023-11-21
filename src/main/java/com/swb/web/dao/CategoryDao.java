package com.swb.web.dao;

import com.swb.web.dto.CategoryDto;

import java.util.List;

public interface CategoryDao {

    List<CategoryDto> findAll();

}
