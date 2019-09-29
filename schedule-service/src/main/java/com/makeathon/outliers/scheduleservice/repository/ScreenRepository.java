package com.makeathon.outliers.scheduleservice.repository;

import com.makeathon.outliers.scheduleservice.entity.ScreenEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenRepository extends JpaRepository<ScreenEntity, Integer> {
  List<ScreenEntity> findByPartnerPartnerId(Integer partnerId);
}
