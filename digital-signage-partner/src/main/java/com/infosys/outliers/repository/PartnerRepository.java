package com.infosys.outliers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.outliers.entity.PartnerEntity;

public interface PartnerRepository extends JpaRepository<PartnerEntity, Integer> {
}