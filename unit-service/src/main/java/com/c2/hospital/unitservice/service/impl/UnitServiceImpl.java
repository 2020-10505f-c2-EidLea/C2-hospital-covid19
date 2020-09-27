package com.c2.hospital.unitservice.service.impl;

import com.c2.hospital.unitservice.co.RoomCO;
import com.c2.hospital.unitservice.exception.ResourceNotFoundException;
import com.c2.hospital.unitservice.model.ClassesEntity;
import com.c2.hospital.unitservice.model.FloorEntity;
import com.c2.hospital.unitservice.model.RoomEntity;
import com.c2.hospital.unitservice.model.TypeEntity;
import com.c2.hospital.unitservice.repository.ClassesRepository;
import com.c2.hospital.unitservice.repository.FloorRepository;
import com.c2.hospital.unitservice.repository.RoomRepository;
import com.c2.hospital.unitservice.repository.TypeRepository;
import com.c2.hospital.unitservice.service.UnitService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private ClassesRepository classesRepository;

    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<RoomCO> findAvailableRoom() {
        List<RoomCO> roomCOList = new ArrayList<>();
        List<RoomEntity> lst = roomRepository.findAvailableRoom(true);
        lst.forEach(roomEntity -> roomCOList.add(findRoomDetails(roomEntity)));
        return roomCOList;
    }

    @Override
    public List<RoomCO> findNonAvailableRoom() {
        List<RoomCO> roomCOList = new ArrayList<>();
        List<RoomEntity> lst = roomRepository.findAvailableRoom(false);
        lst.forEach(roomEntity -> roomCOList.add(findRoomDetails(roomEntity)));
        return roomCOList;
    }

    public RoomCO findRoomDetails(RoomEntity roomEntity) {
        RoomCO roomCO = new RoomCO();
        BeanUtils.copyProperties(roomEntity, roomCO);

        FloorEntity floorEntity = null;
        ClassesEntity classesEntity = null;
        TypeEntity typeEntity = null;
        // get unit floor details
        Optional opt = floorRepository.findById(roomEntity.getIdFloor());
        if(opt.isPresent())
        {
            floorEntity = (FloorEntity) opt.get();
            roomCO.setFloor_bloc(floorEntity.getBloc());
            roomCO.setFloor_nbr(floorEntity.getNbr());
            roomCO.setFloor_specialization(floorEntity.getSpecialization());
        }
        // get unit class details
        opt = classesRepository.findById(roomEntity.getIdClass());
        if(opt.isPresent())
        {
            classesEntity = (ClassesEntity) opt.get();
            roomCO.setClasses_name(classesEntity.getName());
            roomCO.setClasses_nbrOfBed(classesEntity.getNbrOfBed());
        }
        // get unit type details
        opt = typeRepository.findById(roomEntity.getIdType());
        if(opt.isPresent())
        {
            typeEntity = (TypeEntity) opt.get();
            roomCO.setType_description(typeEntity.getDescription());
            roomCO.setType_name(typeEntity.getName());
        }
        return roomCO;
    }

    @Override
    public RoomEntity updateRoomReservation(int roomEntityId, boolean reserve) throws ResourceNotFoundException
    {
        RoomEntity roomEntity = roomRepository.findById(roomEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("RoomEntity not found for this id :: " + roomEntityId));

        roomEntity.setAvailable(true);
        int nbrOfReservedBed = roomEntity.getNbrReservedBeds();
        // if new admission --> action reserve
        if(reserve)
        {
            ClassesEntity classesEntity = classesRepository.findById(roomEntityId)
                    .orElseThrow(() -> new ResourceNotFoundException("Classes not found for this Room id :: " + roomEntityId));

            if(nbrOfReservedBed < classesEntity.getNbrOfBed())  
            { // if still have free bed
                nbrOfReservedBed++; // reserve new bed
                if(nbrOfReservedBed == classesEntity.getNbrOfBed())
                { // if no free beds --> room is unavailable
                    roomEntity.setAvailable(false);
                }
            }
            else
            {
                throw new ResourceNotFoundException("Room is Full");
            }
        }
        else
        { // if end admission --> action reset
            if(nbrOfReservedBed > 0)
            {
                nbrOfReservedBed--; // free reserved bed
            }
            else
            {
                throw new ResourceNotFoundException("Room is Empty");
            }
        }

        roomEntity.setNbrReservedBeds(nbrOfReservedBed);
        return roomRepository.save(roomEntity);
    }
}
