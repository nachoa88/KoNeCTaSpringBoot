package com.curso.apievents.controllers;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.apievents.entities.Event;
import com.curso.apievents.repositories.EventRepository;

@RestController
@CrossOrigin
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @GetMapping
    String hola() {
        return "Hola, soy el controlador de los Eventos";
    }

    @GetMapping(value = "/api/events")
    List<Event> getEvents() {
        /*
         * List<Event> eventList = new ArrayList<Event>();
         * eventList.add(new Event(1, "Graffiti", "Arte Urbano",
         * "TV Boy realizará un mural en defensa de derechos LGBTI ante los ataques homófobos ocurridos en el mes de Junio"
         * ,
         * "./img/Graffitti.jpeg", "Carrer Sant Pere més Baix, 70, 08003, Barcelona",
         * "https://goo.gl/maps/BeF9NBvyn8jmjHvM7",
         * "12/08/2023", "12/08/2023", "19:00","22:00"));
         * eventList.add(new Event(2, "Exposició Parc Ciutadella", "Cultural",
         * "Exposición de obras de diferentes artistas vinculadas al constante cambio de la cultura"
         * ,
         * "./img/Exposicio.jpg", "Passeig de Picasso, 21, 08003, Barcelona",
         * "https://goo.gl/maps/rqxjMRnSX2uufEFG8",
         * "10/08/2023", "13/08/2023", "10:00","20:00"));
         * eventList.add(new Event(3, "Llums BCN", "Art",
         * "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
         * ,
         * "./img/Llums.png", "Poblenou, 08018, Barcelona",
         * "https://goo.gl/maps/oFo1ft8AueihjdZR6",
         * "03/02/2023", "05/02/2023", "18:00","23:00"));
         * 
         * return eventList;
         */
        return eventRepository.findAll();
    }

    @PostMapping(value = "api/events")
    Integer newEvent(@RequestBody Event evt) {
        // Añadimos el evento a la lista. SaveAndFlush además de guardarlo ya lo manda.
        Event newEvt = eventRepository.saveAndFlush(evt);

        return newEvt.getEventID();
    }

    @PutMapping(value = "/api/events/{eventID}")
    public ResponseEntity<Event> updateEvent(@PathVariable Integer eventID, @RequestBody Event updatedEvent) {
        // Retrieve the existing event from the database
        Optional<Event> existingEvent = eventRepository.findById(eventID);
        if (!existingEvent.isPresent()) {
            // If the event with the given ID is not found, return a 404 response
            return ResponseEntity.notFound().build();
        }

        // Update the properties of the existing event with the values from updatedEvent
        Event eventToUpdate = existingEvent.get();
        eventToUpdate.setEventName(updatedEvent.getEventName());
        eventToUpdate.setEventType(updatedEvent.getEventType());
        eventToUpdate.setDescription(updatedEvent.getDescription());
        eventToUpdate.setImg(updatedEvent.getImg());
        eventToUpdate.setLocation(updatedEvent.getLocation());
        eventToUpdate.setLocationHtml(updatedEvent.getLocationHtml());
        eventToUpdate.setStartingDate(updatedEvent.getStartingDate());
        eventToUpdate.setFinishingDate(updatedEvent.getFinishingDate());
        eventToUpdate.setStartingTime(updatedEvent.getStartingTime());
        eventToUpdate.setFinishingTime(updatedEvent.getFinishingTime());

        // Save the updated event to the database
        eventRepository.save(eventToUpdate);

        // Return a 200 OK response with the updated event
        return ResponseEntity.ok(eventToUpdate);
    }

    /* PARA LUEGO HACER EL DELETE
     * @DeleteMapping(value = "api/events")
     * Integer deleteEvent(@RequestBody Event evt) {
     * 
     * }
     */
}
