package com.c2.hospital.admissionservice.repository;

import com.c2.hospital.admissionservice.model.AdmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepository extends JpaRepository<AdmissionEntity, Integer> {

}
