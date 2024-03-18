package com.example.customquery2.controllers;

import com.example.customquery2.entities.Flight;
import com.example.customquery2.enums.Status;
import com.example.customquery2.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @PostMapping("/create")
    public ResponseEntity<List<Flight>> create(@RequestParam(required = false) Integer n) {
        return ResponseEntity.ok(flightService.createFlights(n));
    }

    @GetMapping("ordered")
    public ResponseEntity<List<Flight>> findAll(@RequestParam(required = false) Integer pageNumber,
                                                @RequestParam(required = false) Integer pageSize) {
        List<Flight> flightsFound = flightService.findWithPage(pageNumber, pageSize);
        if (flightsFound.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(flightService.findWithPage(pageNumber, pageSize));
        }
    }

    @GetMapping("available")
    public ResponseEntity<List<Flight>> findAvailable(Status status) {
        List<Flight> flightFound = flightService.findAvailable(status);
        if (flightFound.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(flightService.findAvailable(status));
        }
    }

    @GetMapping("multiple")
    public ResponseEntity<List<Flight>> findByMultipleStatus(@RequestParam Integer p1, @RequestParam Integer p2) {
        List<Flight> flightsFound = flightService.findByMultipleStatus(p1, p2);
        if (flightsFound.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(flightService.findByMultipleStatus(p1, p2));
        }
    }
}
