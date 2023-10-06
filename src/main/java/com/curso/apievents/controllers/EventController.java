package com.curso.apievents.controllers;

import com.curso.apievents.entities.Event;
import com.curso.apievents.repositories.EventRepository;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EventController {
    
    /* @Autowired es como crear un constructor haciendo la inyección de dependencia.
    EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    } */
    @Autowired
    EventRepository eventRepository;

    @GetMapping
    String hola() {
        return "Hola, soy el controlador de los Eventos";
    }

    @GetMapping(value = "/api/events")
    List<Event> getEvents() {
        /* 
        List<Event> eventList = new ArrayList<Event>();
        eventList.add(new Event(1, "Graffiti", "Arte Urbano", "TV Boy realizará un mural en defensa de derechos LGBTI ante los ataques homófobos ocurridos en el mes de Junio", 
        "./img/Graffitti.jpeg", "Carrer Sant Pere més Baix, 70, 08003, Barcelona", "https://goo.gl/maps/BeF9NBvyn8jmjHvM7", 
        "12/08/2023", "12/08/2023", "19:00","22:00"));
        eventList.add(new Event(2, "Exposició Parc Ciutadella", "Cultural", "Exposición de obras de diferentes artistas vinculadas al constante cambio de la cultura",  
        "./img/Exposicio.jpg", "Passeig de Picasso, 21, 08003, Barcelona", "https://goo.gl/maps/rqxjMRnSX2uufEFG8", 
        "10/08/2023", "13/08/2023", "10:00","20:00"));
        eventList.add(new Event(3, "Llums BCN", "Art", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",  
        "./img/Llums.png", "Poblenou, 08018, Barcelona", "https://goo.gl/maps/oFo1ft8AueihjdZR6", 
        "03/02/2023", "05/02/2023", "18:00","23:00"));

        return eventList;
        */
        return eventRepository.findAll();
    }
 
    @PostMapping(value = "api/events")
    Integer newEvent(@RequestBody Event evt) {
        // Añadimos el evento a la lista. SaveAndFlush además de guardarlo ya lo manda.
        Event newEvt = eventRepository.saveAndFlush(evt);

        return newEvt.getEventID();
    }

    /* 
    @DeleteMapping(value = "api/events")
    Integer deleteEvent(@RequestBody Event evt) {

    }*/
}
