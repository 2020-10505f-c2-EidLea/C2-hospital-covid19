package com.c2.hospital.unitservice.repository;

import com.c2.hospital.unitservice.model.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {

    @Query("SELECT u FROM RoomEntity u WHERE u.isAvailable = ?1")
    List<RoomEntity> findAvailableRoom(int isAvailable);

}
