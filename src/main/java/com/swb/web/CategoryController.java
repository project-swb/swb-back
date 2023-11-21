package com.swb.web;


import com.swb.service.category.CategoryService;
import com.swb.web.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Get Category List
    @GetMapping("/categories")
    public ResponseEntity<?> list() {

        List<CategoryDto> list = categoryService.findAll();

        if(list == null || list.isEmpty())
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<CategoryDto>>(list, HttpStatus.OK);
    }

}
