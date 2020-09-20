package com.c2.hospital.unitservice.controllers; 

import com.c2.hospital.unitservice.co.RoomCO;
import com.c2.hospital.unitservice.exception.ResourceNotFoundException;
import com.c2.hospital.unitservice.model.RoomEntity;
import com.c2.hospital.unitservice.repository.RoomRepository;
import com.c2.hospital.unitservice.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private UnitService unitService;

    @Autowired
    private RoomRepository roomRepository;

    // Get List of all units in the covid-19 bloc
    @GetMapping("/")
    public List<RoomEntity> getAllRoomEntitys() {
        return roomRepository.findAll();
    }

    // Get unit by ID
    @GetMapping("/{id}")
    public ResponseEntity<RoomEntity> getRoomEntityById(@PathVariable(value = "id") int roomEntityId) throws ResourceNotFoundException {
        RoomEntity RoomEntity = roomRepository.findById(roomEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("RoomEntity not found for this id :: " + roomEntityId));
        return ResponseEntity.ok().body(RoomEntity);
    }

    // Add new unit
    @PostMapping("/")
    public RoomEntity createRoomEntity(@Valid @RequestBody RoomEntity RoomEntity) {
        return roomRepository.save(RoomEntity);
    }

    // Update unit code, typeId, classId, floorId, number of beds reserved and availibility by unit ID
    @PutMapping("/{id}")
    public ResponseEntity<RoomEntity> updateRoomEntity(@PathVariable(value = "id") int roomEntityId,  @Valid @RequestBody RoomEntity roomEntityDetails) throws ResourceNotFoundException {
        RoomEntity roomEntity = roomRepository.findById(roomEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("RoomEntity not found for this id :: " + roomEntityId));

        roomEntity.setNbr(roomEntityDetails.getNbr());
        roomEntity.setIdType(roomEntityDetails.getIdType());
        roomEntity.setIdClass(roomEntityDetails.getIdClass());
        roomEntity.setIdFloor(roomEntityDetails.getIdFloor());
        roomEntity.setAvailable(roomEntityDetails.isAvailable());
        roomEntity.setNbrReservedBeds(roomEntityDetails.getNbrReservedBeds());
        final RoomEntity updatedRoomEntity = roomRepository.save(roomEntity);
        return ResponseEntity.ok(updatedRoomEntity);
    }

    // Delete unit by ID
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteRoomEntity(@PathVariable(value = "id") int roomEntityId)
            throws ResourceNotFoundException {
        RoomEntity roomEntity = roomRepository.findById(roomEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("RoomEntity not found for this id :: " + roomEntityId));

        roomRepository.delete(roomEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    // Get List of all avaiable units
    @GetMapping("/available")
    public List<RoomCO> getAvailableRoom() {
        return unitService.findAvailableRoom();
    }

    // Get list of all unavailable units
    @GetMapping("/notAvailable")
    public List<RoomCO> getNonAvailableRoom() {
        return unitService.findNonAvailableRoom();
    }

    // Get unit details and info by unitId
    @GetMapping("/{id}/info")
    public ResponseEntity<RoomCO> getRoomInfoById(@PathVariable(value = "id") int roomEntityId) throws ResourceNotFoundException {
        RoomEntity RoomEntity = roomRepository.findById(roomEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("RoomEntity not found for this id :: " + roomEntityId));
        return ResponseEntity.ok().body(unitService.findRoomDetails(RoomEntity));
    }

    // Reserve bed (unit) after new admission
    @GetMapping("/{id}/reserve")
    public ResponseEntity<RoomEntity> reserveRoom(@PathVariable(value = "id") int roomEntityId) throws ResourceNotFoundException {
        RoomEntity updatedRoomEntity = unitService.updateRoomReservation(roomEntityId, true);
        return ResponseEntity.ok(updatedRoomEntity);
    }

    // Reset bed reserved (unit) after admission end (patient left room)
    @GetMapping("/{id}/reset")
    public ResponseEntity<RoomEntity> resetRoom(@PathVariable(value = "id") int roomEntityId) throws ResourceNotFoundException {
        RoomEntity updatedRoomEntity = unitService.updateRoomReservation(roomEntityId, false);
        return ResponseEntity.ok(updatedRoomEntity);
    }
}
