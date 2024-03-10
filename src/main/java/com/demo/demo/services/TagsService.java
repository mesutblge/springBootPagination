package com.demo.demo.services;

import com.demo.demo.dao.Scenarios;
import com.demo.demo.dao.Tags;
import com.demo.demo.repository.TagsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagsService {

    private final TagsRepository tagsRepository;

    public TagsService(TagsRepository tagsRepository) {
        this.tagsRepository = tagsRepository;
    }
    public List<Tags> getAllTags() {
        return tagsRepository.findAll();
    }
}
