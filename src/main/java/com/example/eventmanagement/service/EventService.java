package com.example.eventmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.eventmanagement.model.Event;
import com.example.eventmanagement.model.Booking;
import com.example.eventmanagement.repository.EventRepository;
import com.example.eventmanagement.repository.BookingRepository;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepo;

    @Autowired
    private BookingRepository bookingRepo;

    // 🔹 Get all events
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    // 🔹 Add new event (Admin)
    public Event addEvent(Event event) {
        event.setAvailableSeats(event.getTotalSeats()); // initialize seats
        return eventRepo.save(event);
    }

    // 🔥 MAIN LOGIC: Book Seats
    @Transactional
    public String bookSeats(Long eventId, int seats, String userName) {

        Event event = eventRepo.findById(eventId).orElse(null);

        if (event == null) {
            return "Event not found";
        }

        if (event.getAvailableSeats() >= seats) {

            // Reduce seats
            event.setAvailableSeats(event.getAvailableSeats() - seats);
            eventRepo.save(event);

            // Save booking
            Booking booking = new Booking();
            booking.setEventId(eventId);
            booking.setSeatsBooked(seats);
            booking.setUserName(userName);

            bookingRepo.save(booking);

            return "Booking Successful ✅";
        } else {
            return "Not enough seats ❌";
        }
    }
}