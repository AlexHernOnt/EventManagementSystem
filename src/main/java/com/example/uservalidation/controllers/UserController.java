    package com.example.uservalidation.controllers;

    import com.example.uservalidation.models.Event;
    import com.example.uservalidation.models.User;
    import com.example.uservalidation.services.EventService;
    import jakarta.validation.Valid;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/events")
    public class UserController<user> {

        private final EventService eventService;

        @Autowired
        public UserController(EventService eventService) {
            this.eventService = eventService;
        }

        @GetMapping
        public List<Event> getAllEvents() {
            return eventService.getAllEvents();
        }

        @PostMapping("/registerForEvent")
        public Event registerForEvent(@RequestBody User user) {
            return eventService.registerForEvent(user);
        }


        @DeleteMapping("/removeUser")
        public Event removeUser(@RequestBody User user) {
            return eventService.removeUser(user);
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Event createEvent(@Valid @RequestBody Event event) {
            return eventService.createEvent(event);
        }
    }
