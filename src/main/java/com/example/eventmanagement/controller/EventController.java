package com.example.eventmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.eventmanagement.model.Event;
import com.example.eventmanagement.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin
public class EventController {

    @Autowired
    private EventService eventService;

    // 🔹 Get all events
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // 🔹 Add event (Admin)
    @PostMapping
    public Event addEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }

    // 🔥 Book seats
    @PostMapping("/book")
    public String bookSeats(@RequestParam Long eventId,
                            @RequestParam int seats,
                            @RequestParam String userName) {

        return eventService.bookSeats(eventId, seats, userName);
    }
}