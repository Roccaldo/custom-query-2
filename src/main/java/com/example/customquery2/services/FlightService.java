package com.example.customquery2.services;

import com.example.customquery2.entities.Flight;
import com.example.customquery2.enums.Status;
import com.example.customquery2.repositories.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FlightService {

    @Autowired
    FlightRepo flightRepo;

    public List<Flight> createFlights(Integer n) {
        if (n == null) {
            n = 100;
        }
        List<Flight> flightList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            Flight flight = new Flight();
            flight.setDescription("flight number: " + random.nextInt(10));
            flight.setFromAirport("From Airport: " + random.nextInt(10));
            flight.setToAirport("To Airport: " + random.nextInt(10));
            flight.setStatus(Status.ONTIME);
            flightList.add(flight);
        }
        return flightRepo.saveAll(flightList);
    }

    public List<Flight> findWithPage(Integer limit, Integer offset) {
        if (limit == null || offset == null) {
            limit = 100;
            offset = 0;
            return flightRepo.findOrdered(limit, offset);
        } else {
            return flightRepo.findOrdered(limit, offset);
        }
    }

    public List<Flight> findAvailable(Status status) {
        status = Status.ONTIME;
        return flightRepo.findByStatus(status);
    }

    public List<Flight> findByMultipleStatus(Integer p1, Integer p2) {
        return flightRepo.findBYMultipleStatus(p1, p2);
    }
}

