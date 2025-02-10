package com.example.uservalidation.services;

import com.example.uservalidation.models.Event;
import com.example.uservalidation.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private final List<Event> events = new ArrayList<>();
    private Long nextId = 1L;

    public List<Event> getAllEvents() {
        return events;
    }

    public Event createEvent(Event event) {
        event.setId(nextId++);
        events.add(event);
        return event;
    }

    public Event removeUser(User user) {
        for (Event event : events) {
            if (event.getEventName().equals(user.getEventName())) {

                for (User user1 : event.getUsers()) {
                    if (user1.getEmail().equals(user.getEmail())) {
                        event.removeUser(user1);
                    }
                }
                return event;
            }
        }
        return null;
    }

    public Event registerForEvent(User user) {

        for (Event event : events) {
            if (event.getEventName().equals(user.getEventName())) {
                event.addUser(user);
                return (event);
            }
        }

        // if it doesn't exist

        Event newEvent = new Event(user.getEventName());
        newEvent.setId(nextId++);
        newEvent.addUser(user);
        events.add(newEvent);
        return newEvent;
    }
}
