package com.c2.hospital.patientservice.repository;

import com.c2.hospital.patientservice.model.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<HistoryEntity, Integer> {

    @Query("SELECT u FROM HistoryEntity u WHERE u.profileId = ?1")
    List<HistoryEntity> findHistoryByProfileId(int profileId);
}
