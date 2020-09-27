package com.c2.hospital.admissionservice.service.impl;

import com.c2.hospital.admissionservice.co.AdmissionCO;
import com.c2.hospital.admissionservice.co.AdmissionServicesCO;
import com.c2.hospital.admissionservice.exception.ResourceNotFoundException;
import com.c2.hospital.admissionservice.model.AdmissionEntity;
import com.c2.hospital.admissionservice.model.AdmissionServiceEntity;
import com.c2.hospital.admissionservice.model.ServiceEntity;
import com.c2.hospital.admissionservice.repository.AdmissionRepository;
import com.c2.hospital.admissionservice.repository.AdmissionServiceRepository;
import com.c2.hospital.admissionservice.repository.ServiceRepository;
import com.c2.hospital.admissionservice.service.AdmissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class AdmissionServiceImpl implements AdmissionService {

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    AdmissionRepository admissionRepository;

    @Autowired
    AdmissionServiceRepository admissionServiceRepository;

    @Override
    public AdmissionCO findAdmissionServiceById(int admissionEntityId) throws ResourceNotFoundException {
        AdmissionCO admissionCO = new AdmissionCO();
        AdmissionEntity admissionEntity = admissionRepository.findById(admissionEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("AdmissionEntity not found for this id :: " + admissionEntityId));

        BeanUtils.copyProperties(admissionEntity, admissionCO);
        admissionCO.setAdmissionServicesList(returnAdmissionServicesCOList(admissionEntity));
        return admissionCO;
    }

    @Override
    public AdmissionCO saveAdmission(AdmissionCO admissionCO) throws ResourceNotFoundException {
        if(admissionCO.getId() == 0)
        {
            AdmissionEntity admissionEntity = new AdmissionEntity();
            admissionEntity.setCheckIn(Calendar.getInstance().getTime());
            if(null != admissionCO.getRoomId() && admissionCO.getRoomId() != 0)
            {
                admissionEntity.setRoomId(admissionCO.getRoomId());
            }
            admissionEntity.setNbrOfDays(1);
            admissionEntity = admissionRepository.save(admissionEntity);
            admissionCO.setId(admissionEntity.getId());
        }
        if(null == admissionCO.getServiceId() || 0 == admissionCO.getServiceId())
        {
            throw new ResourceNotFoundException("service not found for this id :: " + admissionCO.getServiceId());
        }
        AdmissionServiceEntity admissionServiceEntity = new AdmissionServiceEntity();
        admissionServiceEntity.setAdmissionId(admissionCO.getId());
        admissionServiceEntity.setServiceId(admissionCO.getServiceId());
        admissionServiceEntity.setServiceDate(admissionCO.getServiceDate());
        admissionServiceEntity.setServiceResult(admissionCO.getServiceResult());
        admissionServiceEntity = admissionServiceRepository.save(admissionServiceEntity);
        admissionCO.setAdmissionServiceId(admissionServiceEntity.getId());
        return admissionCO;
    }

    private List<AdmissionServicesCO> returnAdmissionServicesCOList(AdmissionEntity admissionEntity) {
        List<AdmissionServicesCO> admissionServicesList = new ArrayList<>();
        List<AdmissionServiceEntity> al = admissionServiceRepository.findAdmissionServicesByAdmissionId(admissionEntity.getId());
        al.forEach(admissionServiceEntity ->{
            int admissionServiceId = admissionServiceEntity.getId();
            AdmissionServicesCO admissionServicesCO = new AdmissionServicesCO();
            admissionServicesList.add(admissionServicesCO);
            BeanUtils.copyProperties(admissionServiceEntity, admissionServicesCO);
            admissionServicesCO.setServiceId(admissionEntity.getId());
            admissionServicesCO.setId(admissionServiceId);
            ServiceEntity serviceEntity = serviceRepository.findById(admissionServiceEntity.getServiceId()).orElse(new ServiceEntity());
            admissionServicesCO.setDescription(serviceEntity.getDescription());
            admissionServicesCO.setAvailableService(serviceEntity.isAvailableService());
        });
        return admissionServicesList;
    }
}
