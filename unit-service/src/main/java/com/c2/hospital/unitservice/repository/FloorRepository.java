package com.c2.hospital.unitservice.repository;

import com.c2.hospital.unitservice.model.FloorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends JpaRepository<FloorEntity, Integer> {

}
