package com.c2.hospital.equipmentservice.service;

import com.c2.hospital.equipmentservice.co.EquipmentCO;
import com.c2.hospital.equipmentservice.exception.ResourceNotFoundException;
import com.c2.hospital.equipmentservice.model.EquipmentEntity;

import java.util.List;

public interface EquipmentService
{
    List<EquipmentCO> findAvailableEquipment();

    List<EquipmentCO> findNonAvailableEquipment();

    EquipmentCO findEquipmentDetails(EquipmentEntity equipmentEntity);

    EquipmentEntity changeQty(int equipmentEntityId, int qty, float signum) throws ResourceNotFoundException;

    List<EquipmentCO> findByTypeId(int equipmentTypeId) throws ResourceNotFoundException;

    List<EquipmentCO> findByServiceId(int equipmentServiceId) throws ResourceNotFoundException;
}
