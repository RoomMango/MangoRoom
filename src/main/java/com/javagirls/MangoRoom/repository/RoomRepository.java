package com.javagirls.MangoRoom.repository;

import com.javagirls.MangoRoom.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {

}
