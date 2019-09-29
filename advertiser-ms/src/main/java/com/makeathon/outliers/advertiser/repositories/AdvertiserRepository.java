package com.makeathon.outliers.advertiser.repositories;

import com.makeathon.outliers.advertiser.entity.Advertiser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertiserRepository extends JpaRepository<Advertiser, Integer> {
}
