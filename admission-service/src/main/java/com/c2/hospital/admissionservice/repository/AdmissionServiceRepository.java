package com.c2.hospital.admissionservice.repository;

import com.c2.hospital.admissionservice.model.AdmissionServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdmissionServiceRepository extends JpaRepository<AdmissionServiceEntity, Integer> {

    @Query("SELECT u FROM AdmissionServiceEntity u WHERE u.admissionId = ?1 ")
    List<AdmissionServiceEntity> findAdmissionServicesByAdmissionId(int admissionEntityId);
}
