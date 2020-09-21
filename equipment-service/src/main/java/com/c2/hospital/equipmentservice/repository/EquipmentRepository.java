package com.c2.hospital.equipmentservice.repository;

import com.c2.hospital.equipmentservice.model.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<EquipmentEntity, Integer> {

    @Query("SELECT u FROM EquipmentEntity u WHERE (u.disponibility > 0 and 1 = ?1) or (u.disponibility = 0 and 0 = ?1) ")
    List<EquipmentEntity> findAvailableEquipment(int i);

    @Query("SELECT u FROM EquipmentEntity u WHERE u.idType = ?1")
    List<EquipmentEntity> findByTypeId(int equipmentTypeId);

    @Query("SELECT u FROM EquipmentEntity u WHERE u.idType IN (SELECT n.id FROM EquipmentTypeEntity n where n.serviceId = ?1 )")
    List<EquipmentEntity> findByServiceId(int equipmentServiceId);
}
