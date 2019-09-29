package com.infosys.outliers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.outliers.entity.ScreenEntity;

public interface ScreenRepository extends JpaRepository<ScreenEntity, Integer> {
	List<ScreenEntity> findByPartnerPartnerId(Integer partnerId);
}