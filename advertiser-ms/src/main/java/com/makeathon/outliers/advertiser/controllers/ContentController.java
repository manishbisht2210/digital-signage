package com.makeathon.outliers.advertiser.controllers;

import com.makeathon.outliers.advertiser.entity.Content;
import com.makeathon.outliers.advertiser.services.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/content")
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @PostMapping(value = "/create", produces = "application/json")
    public Integer createContent(@RequestBody Content content) {
        return contentService.createContent(content);
    }

    @PutMapping(value = "/update")
    public void updateContent(@RequestBody Content content) {
        contentService.updateContent(content);
    }

    @GetMapping(value = "/get/{contentId}", produces = "application/json")
    public Content getContent(@PathVariable("contentId") Integer contentId) {
        return contentService.getContent(contentId);
    }

    @DeleteMapping(value = "/delete/{contentId}")
    public void deleteContent(@PathVariable("contentId") Integer contentId) {
        contentService.deleteContent(contentId);
        ;
    }

}
