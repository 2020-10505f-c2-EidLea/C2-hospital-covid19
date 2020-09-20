package com.c2.hospital.unitservice.service;

import com.c2.hospital.unitservice.co.RoomCO;
import com.c2.hospital.unitservice.exception.ResourceNotFoundException;
import com.c2.hospital.unitservice.model.RoomEntity;

import java.util.List;

public interface UnitService {

    // List of all available units (still have free beds)
    List<RoomCO> findAvailableRoom();

    // List of fully reserved rooms
    List<RoomCO> findNonAvailableRoom();

    // Get unit details
    RoomCO findRoomDetails(RoomEntity roomEntity);

    // reserve/reset room depending on admission entry/end
    RoomEntity updateRoomReservation(int roomEntityId, boolean reserve) throws ResourceNotFoundException;
}
