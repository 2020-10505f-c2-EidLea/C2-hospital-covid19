package com.c2.hospital.equipmentservice.service.impl;

import com.c2.hospital.equipmentservice.co.EquipmentCO;
import com.c2.hospital.equipmentservice.exception.ResourceNotFoundException;
import com.c2.hospital.equipmentservice.model.EquipmentEntity;
import com.c2.hospital.equipmentservice.model.EquipmentTypeEntity;
import com.c2.hospital.equipmentservice.model.ProviderEntity;
import com.c2.hospital.equipmentservice.repository.EquipmentRepository;
import com.c2.hospital.equipmentservice.repository.EquipmentTypeRepository;
import com.c2.hospital.equipmentservice.repository.ProviderRepository;
import com.c2.hospital.equipmentservice.service.EquipmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService
{
    @Autowired
    ProviderRepository providerRepository;

    @Autowired
    EquipmentRepository equipmentRepository;

    @Autowired
    EquipmentTypeRepository equipmentTypeRepository;

    @Override
    public List<EquipmentCO> findAvailableEquipment() {
        List<EquipmentCO> equipmentCOList = new ArrayList<>();
        List<EquipmentEntity> lst = equipmentRepository.findAvailableEquipment(1);
        lst.forEach(equipmentEntity -> equipmentCOList.add(findEquipmentDetails(equipmentEntity)));
        return equipmentCOList;
    }

    @Override
    public List<EquipmentCO> findNonAvailableEquipment() {
        List<EquipmentCO> equipmentCOList = new ArrayList<>();
        List<EquipmentEntity> lst = equipmentRepository.findAvailableEquipment(0);
        lst.forEach(equipmentEntity -> equipmentCOList.add(findEquipmentDetails(equipmentEntity)));
        return equipmentCOList;
    }

    @Override
    public EquipmentCO findEquipmentDetails(EquipmentEntity equipmentEntity) {
        EquipmentCO equipmentCO = new EquipmentCO();
        BeanUtils.copyProperties(equipmentEntity, equipmentCO);

        ProviderEntity providerEntity = null;
        Optional opt = providerRepository.findById(equipmentEntity.getProviderId());
        if(opt.isPresent())
        {
            providerEntity = (ProviderEntity) opt.get();
            equipmentCO.setProviderName(providerEntity.getName());
            equipmentCO.setProviderEmail(providerEntity.getEmail());
            equipmentCO.setProviderPhone(providerEntity.getPhone());
        }

        EquipmentTypeEntity equipmentTypeEntity = null;
        opt = equipmentTypeRepository.findById(equipmentEntity.getIdType());
        if(opt.isPresent())
        {
            equipmentTypeEntity = (EquipmentTypeEntity) opt.get();
            equipmentCO.setTypeName(equipmentTypeEntity.getName());
            equipmentCO.setTypeDescription(equipmentTypeEntity.getDescription());
        }
        return equipmentCO;
    }

    @Override
    public EquipmentEntity changeQty(int equipmentEntityId, int qty, float signum) throws ResourceNotFoundException {
        EquipmentEntity equipmentEntity = equipmentRepository.findById(equipmentEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("EquipmentEntity not found for this id :: " + equipmentEntityId));

        if(qty == 0 || signum == 0)
        {
            return equipmentEntity;
        }
        if(signum == 1)
        {
            equipmentEntity.setQuantity(equipmentEntity.getQuantity() + qty);
            equipmentEntity.setDisponibility(equipmentEntity.getQuantity() + qty);
        }
        else
        {
            if(equipmentEntity.getDisponibility() >= qty)
            {
                equipmentEntity.setDisponibility(equipmentEntity.getDisponibility() - qty);
            }
            else
            {
                throw new ResourceNotFoundException("Equipment with id : " + equipmentEntityId + " is only available with quantity " + equipmentEntity.getDisponibility());
            }

        }
        return equipmentRepository.save(equipmentEntity);
    }

    @Override
    public List<EquipmentCO> findByTypeId(int equipmentTypeId) throws ResourceNotFoundException {
        List<EquipmentCO> equipmentCOList = new ArrayList<>();
        List<EquipmentEntity> lst = equipmentRepository.findByTypeId(equipmentTypeId);
        lst.forEach(equipmentEntity -> equipmentCOList.add(findEquipmentDetails(equipmentEntity)));
        return equipmentCOList;
    }

    @Override
    public List<EquipmentCO> findByServiceId(int equipmentServiceId) throws ResourceNotFoundException {
        List<EquipmentCO> equipmentCOList = new ArrayList<>();
        List<EquipmentEntity> lst = equipmentRepository.findByServiceId(equipmentServiceId);
        lst.forEach(equipmentEntity -> equipmentCOList.add(findEquipmentDetails(equipmentEntity)));
        return equipmentCOList;
    }
}
