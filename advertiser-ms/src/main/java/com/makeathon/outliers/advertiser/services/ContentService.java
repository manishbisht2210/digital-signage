package com.makeathon.outliers.advertiser.services;

import com.makeathon.outliers.advertiser.entity.Content;
import com.makeathon.outliers.advertiser.repositories.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;

    public Integer createContent(Content content) {
        return contentRepository.save(content).getId();
    }

    public void updateContent(Content content) {
        Content contentEntity = contentRepository.findById(content.getId()).orElse(null);
        if (contentEntity != null) {
            contentEntity.setLocation(content.getLocation());
            content.setContentType(content.getContentType());
            contentRepository.save(contentEntity);
        }
    }

    public Content getContent(Integer id) {
        return contentRepository.findById(id).orElse(null);
    }

    public void deleteContent(Integer id) {
        contentRepository.deleteById(id);
    }
}
