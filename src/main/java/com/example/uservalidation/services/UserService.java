package com.example.uservalidation.services;

import com.example.uservalidation.models.Event;
import com.example.uservalidation.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

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

    public Event registerForEvent(User user) {

        for (Event event : events) {
            if (event.getEventName().equals(user.getEventName())) {
                event.addUser(user);
                return (event);
            }
        }

        // if it doesnt exist

        Event newEvent = new Event(user.getEventName());
        newEvent.setId(nextId++);
        newEvent.addUser(user);
        events.add(newEvent);
        return newEvent;
    }
}
