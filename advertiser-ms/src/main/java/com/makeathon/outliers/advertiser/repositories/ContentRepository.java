package com.makeathon.outliers.advertiser.repositories;

import com.makeathon.outliers.advertiser.entity.Advertiser;
import com.makeathon.outliers.advertiser.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Integer> {
}
