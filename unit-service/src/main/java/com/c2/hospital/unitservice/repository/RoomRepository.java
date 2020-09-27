package com.c2.hospital.unitservice.repository;

import com.c2.hospital.unitservice.model.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {

<<<<<<< HEAD
    @Query("SELECT u FROM RoomEntity u WHERE u.isAvailable = ?1")
    List<RoomEntity> findAvailableRoom(int isAvailable);
=======
    @Query("SELECT u FROM RoomEntity u WHERE u.available = ?1")
    List<RoomEntity> findAvailableRoom(boolean isAvailable);
>>>>>>> 843bce3a8594a0b515ebea54194158354a1d5ce2

}
