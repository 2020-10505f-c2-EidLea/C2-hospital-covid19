package com.c2.hospital.patientservice.repository;

import com.c2.hospital.patientservice.model.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer> {

}
