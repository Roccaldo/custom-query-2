package com.example.customquery2.repositories;

import com.example.customquery2.entities.Flight;
import com.example.customquery2.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {
    @Query(value = "SELECT * FROM flight ORDER BY from_Airport LIMIT :l OFFSET :o", nativeQuery = true)
    List<Flight> findOrdered(@Param("l") Integer limit, @Param("o") Integer offset);

    List<Flight> findByStatus(Status status);

    @Query(value = "SELECT * FROM flight WHERE flight.status = :p1 OR flight.status = :p2", nativeQuery = true)
    List<Flight> findBYMultipleStatus(@Param("p1") Integer firstStatus, @Param("p2") Integer secondStatus);
}
