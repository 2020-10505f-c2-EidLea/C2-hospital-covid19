package com.c2.hospital.unitservice.service;

import com.c2.hospital.unitservice.co.RoomCO;
import com.c2.hospital.unitservice.exception.ResourceNotFoundException;
import com.c2.hospital.unitservice.model.RoomEntity;

import java.util.List;

public interface UnitService {

    List<RoomCO> findAvailableRoom();

    List<RoomCO> findNonAvailableRoom();

    RoomCO findRoomDetails(RoomEntity roomEntity);

    RoomEntity updateRoomReservation(int roomEntityId, boolean reserve) throws ResourceNotFoundException;

    List<RoomCO> findRoomInfo(int typeId, int filterCriteria);
}
