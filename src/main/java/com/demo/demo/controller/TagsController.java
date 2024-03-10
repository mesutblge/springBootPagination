package com.demo.demo.controller;

import com.demo.demo.dao.Alerts;
import com.demo.demo.dao.Tags;
import com.demo.demo.services.AlertsService;
import com.demo.demo.services.TagsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class TagsController {

    private final TagsService tagsService;

    public TagsController(TagsService tagsService) {
        this.tagsService = tagsService;
    }


    @GetMapping("/getAllTags")
    public ResponseEntity<List<Tags>> getAllTags(){

        List<Tags> tags = tagsService.getAllTags();
        System.out.println(tags);

        return new ResponseEntity<>(tags, HttpStatus.OK);

    }

}
